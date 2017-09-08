package com._520it.crm.web.controller;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.OrderBill;
import com._520it.crm.domain.Product;
import com._520it.crm.domain.ProductCategory;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IBrandService;
import com._520it.crm.service.IOrderBillService;
import com._520it.crm.service.IProductCategoryService;
import com._520it.crm.service.IProductService;
import com._520it.crm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class OrderBillController extends BaseController {
    //订单service
    @Autowired
    private IOrderBillService service;
    //商品service
    @Autowired
    private IProductService productService;
    //商品类别service
    @Autowired
    private IProductCategoryService productCategoryService;
    //商品品牌service
    @Autowired
    private IBrandService brandService;

    @RequestMapping("/orderBill")
    public String index() {
        return "orderBill";
    }

    @RequestMapping("/orderBill_list")
    @ResponseBody
    public PageResult list(QueryObject qo) {
        //获取当前的入库明细对象
        return service.queryPageResult(qo);
    }

    //保存一条订单
    @RequestMapping("/orderBill_save")
    @ResponseBody
    public AjaxResult save(OrderBill record) {
        try {
            //设置录入时间
            record.setInputtime(new Date());
            //设置进货总价=进货数量*单个商品成本
            record.setTotalamount(record.getCostPrice().multiply(record.getCount()));
            //插入一条订单数据
            service.insert(record);
            return new AjaxResult(true, "新增成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "新增失败,请填写必须的数据!");

    }

    //更新一条订单
    @RequestMapping("/orderBill_update")
    @ResponseBody
    public AjaxResult edit(OrderBill record) {
        try {
            //设置录入时间
            record.setInputtime(new Date());
            //设置进货总价=进货数量*单个商品成本
            record.setTotalamount(record.getCostPrice().multiply(record.getCount()));
            //更新一条订单数据
            service.updateByPrimaryKey(record);
            return new AjaxResult(true, "更新成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "更新失败,请填写必须的数据!");

    }

    //删除一条订单
    @RequestMapping("/orderBill_remove")
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

    //返回库单号
    @RequestMapping("/orderBill_sn")
    @ResponseBody
    public String uuid() {
        //获取uuid的值,从第25位开始
        return UUID.randomUUID().toString().substring(25);
    }

    //返回商品名称的列表
    @RequestMapping("/orderBill_productNameList")
    @ResponseBody
    public List<Product> productNameList() {
        return productService.selectAll();
    }

    //返回商品69编码的列表
    @RequestMapping("/orderBill_getProductBySn")
    @ResponseBody
    public Product getProductBySn(String sn) {
        return productService.getProductBySn(sn);
    }

    //返回商品类别的列表
    @RequestMapping("/orderBill_getProductCategory")
    @ResponseBody
    public List<ProductCategory> getProductCategory() {
        return productCategoryService.selectAll();
    }

    //返回商品品牌的列表
    @RequestMapping("/orderBill_getBrand")
    @ResponseBody
    public List<Brand> getProductBrand() {
        return brandService.selectAll();
    }

}
