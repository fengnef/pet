
package com._520it.crm.web.controller;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductStockQuery;
import com._520it.crm.service.IProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductStockController extends BaseController {

    @Autowired
    private IProductStockService service;

    @RequestMapping("/productStock")
    // @RequiresPermissions("productStock:view")
    // @PermissionName("库存主页")
    public String index() {
        return "productStock";
    }

    @RequestMapping("/productStock_list")
    @ResponseBody
    public PageResult list(ProductStockQuery qo) {
        //获取当前的库存明细对象
        return service.queryPageResult(qo);
    }
}
