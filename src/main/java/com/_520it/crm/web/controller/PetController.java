package com._520it.crm.web.controller;

import com._520it.crm.domain.Member;
import com._520it.crm.domain.Pet;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetQuery;
import com._520it.crm.service.IPetService;
import com._520it.crm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PetController {

    @Autowired
    private IPetService service;


    @RequestMapping("/pet")
    public String list() {
        return "pet";
    }

    @RequestMapping("/pet_selectOneConectionData")
    @ResponseBody
    public Pet selectOneConectionData(Long memberNumber) {
        return service.selectOneConectionData(memberNumber);
    }

    @RequestMapping("/petServiceDialog")
    public String petServiceDialog() {
        return "petServiceDialog";
    }

    @RequestMapping("/pet_listAll")
    @ResponseBody
    public PageResult list(PetQuery qo) {
        return service.queryPageResult(qo);
    }

    @RequestMapping("/petAndMemberAndServiceitem_save")
    @ResponseBody
    public AjaxResult save(Pet p, Member m, Long serviceId, Long categoryId, Long breedId){
        try{
            service.insert(p,m,serviceId,categoryId,breedId);
            return new AjaxResult(true,"保存成功!");
        }catch(Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"保存失败!");
    }
    @RequestMapping("/addData_save")
    @ResponseBody
    public AjaxResult addData(){
        try{
            return new AjaxResult(true,"保存成功!");
        }catch(Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"保存失败!");
    }
}
