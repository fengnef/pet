package com._520it.crm.web.controller;

import com._520it.crm.domain.OrderBill;
import com._520it.crm.domain.ProductStock;
import com._520it.crm.domain.Shopkeeper;
import com._520it.crm.domain.StockIncomeBillItem;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StockIncomeBillItemQuery;
import com._520it.crm.service.IOrderBillService;
import com._520it.crm.service.IProductStockService;
import com._520it.crm.service.IStockIncomeBillItemService;
import com._520it.crm.util.AjaxResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;

@Controller
public class StockIncomeBillItemController extends BaseController {

    @Autowired
    private IStockIncomeBillItemService service;
    @Autowired
    private IOrderBillService orderBillService;
    @Autowired
    private IProductStockService productStockService;

    @RequestMapping("/stockIncomeBillItem")
    public String index() {
        return "stockIncomeBillItem";
    }

    @RequestMapping("/stockIndex")
    public String index1() {
        return "stockIndex";
    }

    @RequestMapping("/stockIncomeBillItem_list")
    @ResponseBody
    public PageResult list(StockIncomeBillItemQuery qo) {
        //获取当前的入库明细对象
        return service.queryPageResult(qo);
    }

    @RequestMapping("/stockIncomeBillItem_saveAll")
    @ResponseBody
    public AjaxResult saveAll(@RequestParam("orderBills[]") Long[] orderBills) {
        try {
            System.out.println(Arrays.toString(orderBills));
            //新建一个入库对象
            StockIncomeBillItem item = new StockIncomeBillItem();
            //新建一个库存对象
            ProductStock productStock = new ProductStock();
            for (int i = 0; i < orderBills.length; i++) {
                //根据订单id获取到订单对象
                OrderBill orderBill = orderBillService.selectByPrimaryKey(orderBills[i]);
                //设置入库对象的值
                //入库时间
                item.setInputtime(new Date());
                //进价
                item.setCostPrice(orderBill.getCostPrice());
                //售价
                item.setSaleprice(orderBill.getSaleprice());
                //数量
                item.setCount(orderBill.getCount());
                //进货总价
                item.setTotalamout(orderBill.getCostPrice().multiply(orderBill.getCount()));
                //会员价
                item.setMemberprice(orderBill.getDiscount());
                //商品名称
                item.setProductName(orderBill.getProductName());
                //商品品牌
                item.setProductBrand(orderBill.getProductBrand());
                //商品类别
                item.setProductCategory(orderBill.getProductCategory());
                //商品规格
                item.setProductSpecification(orderBill.getProductSpecification());
                //操作人
                Shopkeeper principal = (Shopkeeper) SecurityUtils.getSubject().getPrincipal();
                //保质期
                item.setWarrantydate(orderBill.getWarrantyDate());
                item.setOperator(principal.getStorehead());
                //保存入库对象
                service.insert(item);
                //================================================
                //更新库存
                //设置库存编号
                productStock.setSn(orderBill.getSn());
                //设置库存结余
                productStock.setBalancestock(item.getCount());
                //设置库存的商品69码
                productStock.getProduct().setSn(orderBill.getProductSn());
                //商品类别
                productStock.setProductCategory(orderBill.getProductCategory());
                //商品品牌
                productStock.setProductBrand(orderBill.getProductBrand());
                //商品规格
                productStock.setProductSpecification(orderBill.getProductSpecification());
                //生产日期
                productStock.setProductDate(orderBill.getProductDate());
                //保质期
                productStock.setWarrantyDate(orderBill.getWarrantyDate());
                //新增一条库存
                productStockService.insert(productStock);
            }
            //入库后删除所有订单
            service.deleteAllOrderBill();
            return new AjaxResult(true, "入库成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "入库失败!");
    }

}
