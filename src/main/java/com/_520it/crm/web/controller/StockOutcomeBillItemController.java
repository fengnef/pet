package com._520it.crm.web.controller;

import com._520it.crm.domain.ProductStock;
import com._520it.crm.domain.Shopkeeper;
import com._520it.crm.domain.StockOutcomeBill;
import com._520it.crm.domain.StockOutcomeBillItem;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StockIncomeBillItemQuery;
import com._520it.crm.service.IProductStockService;
import com._520it.crm.service.IStockOutcomeBillItemService;
import com._520it.crm.service.IStockOutcomeBillService;
import com._520it.crm.util.AjaxResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@SuppressWarnings("Duplicates")
@Controller
public class StockOutcomeBillItemController extends BaseController {
    //出库记录
    @Autowired
    private IStockOutcomeBillItemService service;
    //出库单
    @Autowired
    private IStockOutcomeBillService stockOutcomeBillService;
    //库存
    @Autowired
    private IProductStockService productStockService;

    @RequestMapping("/stockOutcomeBillItem")
    public String index() {
        return "stockOutcomeBillItem";
    }

    @RequestMapping("/stockOutcomeBillItem_list")
    @ResponseBody
    public PageResult list(StockIncomeBillItemQuery qo) {
        //获取当前的出库明细对象
        return service.queryPageResult(qo);
    }

    @RequestMapping("/stockOutcomeBillItem_saveAll")
    @ResponseBody
    public AjaxResult saveAll(@RequestParam("stockOutcomeBills[]") Long[] stockOutcomeBills) {
        try {
            System.out.println(Arrays.toString(stockOutcomeBills));
            //新建一个出库对象
            StockOutcomeBillItem item = new StockOutcomeBillItem();
            for (int i = 0; i < stockOutcomeBills.length; i++) {
                //根据订单id获取到订单对象
                StockOutcomeBill stockOutcomeBill = stockOutcomeBillService.selectByPrimaryKey(stockOutcomeBills[i]);
                //设置出库对象的值
                //出库时间
                item.setInputtime(new Date());
                //进价
                item.setCostPrice(stockOutcomeBill.getCostPrice());
                //售价
                item.setSaleprice(stockOutcomeBill.getSaleprice());
                //数量
                item.setCount(stockOutcomeBill.getCount());
                //进货总价
                item.setTotalamout(stockOutcomeBill.getCostPrice().multiply(stockOutcomeBill.getCount()));
                //商品名称
                item.setProductName(stockOutcomeBill.getProductName());
                //操作人
                Shopkeeper principal = (Shopkeeper) SecurityUtils.getSubject().getPrincipal();
                item.setOperator(principal.getStorehead());
                //分店
                item.setSubStore(stockOutcomeBill.getSubStore());
                //会员价
                item.setMemberprice(stockOutcomeBill.getDiscount());
                //商品类别
                item.setProductCategory(stockOutcomeBill.getProductCategory());
                //商品规格
                item.setProductSpecification(stockOutcomeBill.getProductSpecification());
                //保存出库对象
                service.insert(item);
                /**************************************************/
                //更新库存数量
                //根据库存编码获取相应的库存
                ProductStock ps = productStockService.getStockByStockSn(stockOutcomeBill.getSn());
                BigDecimal bs = ps.getBalancestock();
                bs = bs.subtract(item.getCount());
                //更新库存结余
                productStockService.updateBalanceStore(bs, ps.getSn());


            }
            //出库后删除出库单
            stockOutcomeBillService.deleteAllOutcomeBill();
            return new AjaxResult(true, "出库成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "出库失败!");
    }


}
