package com._520it.crm.web.controller;

import com._520it.crm.domain.ProductStock;
import com._520it.crm.domain.StockOutcomeBill;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IProductStockService;
import com._520it.crm.service.IStockOutcomeBillService;
import com._520it.crm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@SuppressWarnings("Duplicates")
@Controller
public class StockOutcomeBillController extends BaseController {
    //出库单
    @Autowired
    private IStockOutcomeBillService service;
    //库存
    @Autowired
    private IProductStockService productStockService;

    @RequestMapping("/stockOutcomeBill")
    public String index() {
        return "stockOutcomeBill";
    }

    @RequestMapping("/stockOutcomeBill_list")
    @ResponseBody
    public PageResult list(QueryObject qo) {
        //获取当前的出库单对象
        return service.queryPageResult(qo);
    }

    //保存一条订单
    @RequestMapping("/stockOutcomeBill_save")
    @ResponseBody
    public AjaxResult save(StockOutcomeBill record) {
        try {
            //设置录入时间
            record.setInputtime(new Date());
            //设置出货总价=出货数量*单个商品成本
            record.setTotalamount(record.getCostPrice().multiply(record.getCount()));
            //插入一条订单数据
            service.insert(record);
            return new AjaxResult(true, "新增成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "新增失败!");

    }

    //更新一条订单
    @RequestMapping("/stockOutcomeBill_update")
    @ResponseBody
    public AjaxResult edit(StockOutcomeBill record) {
        try {
            //设置录入时间
            record.setInputtime(new Date());
            //设置出货总价=出货数量*单个商品成本
            record.setTotalamount(record.getCostPrice().multiply(record.getCount()));
            //更新一条订单数据
            service.updateByPrimaryKey(record);
            return new AjaxResult(true, "更新成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "更新失败!");
    }

    //删除一条订单
    @RequestMapping("/stockOutcomeBill_remove")
    @ResponseBody
    public AjaxResult remove(Long id) {
        try {
            service.deleteByPrimaryKey(id);
            return new AjaxResult(true, "删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "删除失败!");
    }


    //根据商品69码返回一个库存参数
    @RequestMapping("/stockOutcomeBill_getStockByProductSn")
    @ResponseBody
    public ProductStock getStockByProductSn(String productSn) {
        System.out.println("======getStockByProductSn========");
        return productStockService.getStockByProductSn(productSn);
    }

}
