package com._520it.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemController {
    @RequestMapping("/systemSet")
    public String index(){
        return "systemSet";
    }
}
