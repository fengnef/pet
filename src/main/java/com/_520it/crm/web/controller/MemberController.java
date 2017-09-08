package com._520it.crm.web.controller;

import com._520it.crm.domain.*;
import com._520it.crm.mapper.PetMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.MemberQuery;
import com._520it.crm.service.IMemberService;
import com._520it.crm.service.IPetService;
import com._520it.crm.service.impl.PetServiceImpl;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableWorkbook;
import org.apache.commons.io.IOUtils;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.util.calendar.Gregorian;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private IMemberService memberService;
    @Autowired
    private IPetService petService;


    @RequestMapping("/member_view")
    @PermissionName("会员页面页面")
    public String shopkeeper() {
        return "member";
    }


    @RequestMapping("/member_list")
    @ResponseBody
    public List<Member> list() {
//        会员信息查询
        List<Member> members = memberService.selectAll();
        return members;
    }


    @RequestMapping("/photoUpload")
    @ResponseBody
    public void upload(MultipartFile file, HttpServletRequest request, Long id) throws Exception {
//     主页图片上传
        // 自定义的文件名称
        String trueFileName = String.valueOf(System.currentTimeMillis()) + file.getOriginalFilename();
        //获取upload文件夹得真实路径
        // 设置存放图片文件的路径
        String realpath = request.getSession().getServletContext().getRealPath("/static/png/" + trueFileName);
        System.out.println("文件在容器中存放的位置" + realpath);
        System.out.println("System.currentTimeMillis()=" + System.currentTimeMillis());

        FileOutputStream fileOutputStream = new FileOutputStream(realpath);
        IOUtils.copy(file.getInputStream(), fileOutputStream);
        fileOutputStream.close();
//        图片的路径保存到数据库

        petService.updatPhotoUpload(trueFileName, id);
      //  return new AjaxResult(true, "保存图片成功!");
    }


    //     删除宠物delete_pet
    @RequestMapping("/delete_pet")
    @ResponseBody
    public AjaxResult deletePet(Long id) {
//      保存新增宠物
        try {
            petService.deleteByPrimaryKey(id);
            return new AjaxResult(true, "删除宠物成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "删除宠物失败!");
    }


    @RequestMapping("/save_pet")
    @ResponseBody
    public AjaxResult savePeT(Pet pet) {
//      保存新增宠物
        try {
            petService.savePet(pet);
            return new AjaxResult(true, "保存会员和宠物成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "保存会员和宠物失败!");
    }


    @RequestMapping("/saveMemberAndPet_save")
    @ResponseBody
    public AjaxResult saveMemberAndPet(Member member, Pet pet) {
//        会员保存
        try {
            memberService.saveMemberAndPet(member, pet);
            return new AjaxResult(true, "保存会员和宠物成功!");
        } catch (Exception e) {
            e.printStackTrace();
        return new AjaxResult(false, "保存会员和宠物失败!");
        }
    }


    @RequestMapping("/member_save")
    @ResponseBody
    public AjaxResult save(Member shop) {
//        店铺注册
        try {
            memberService.insert(shop);
            return new AjaxResult(true, "保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "保存失败!");
    }

    @RequestMapping("/recharge_save")
    @ResponseBody
    public AjaxResult recharge(Sufficientitem item) {
//        充值保存
        try {
            memberService.saveSufficientitem(item);
            return new AjaxResult(true, "保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "保存失败!");
    }

    @RequestMapping("/select_VIPMember")
    @ResponseBody
    public List<Vipmember> selectVIPMember() {
//       查询会员等级
        List<Vipmember> vipmembers = memberService.selectVIPMember();
        return vipmembers;
    }

    @RequestMapping("/sufficientTake")
    @ResponseBody
    public Sufficienttake sufficientTake(Long id) {
//       查询会员卡内余额和消费总额
        Sufficienttake sufficienttake = memberService.sufficientTake(id);
        return sufficienttake;
    }

    @RequestMapping("/updatMemberstart")
    @ResponseBody
    public AjaxResult updatMemberstart(Long id) {
//        会员退卡改变状态
        try {
            memberService.updatMemberstart(id);
            return new AjaxResult(true, "退卡成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "退卡失败!");
    }

    //    会员导入
    @RequestMapping("/memeber_import")
    @ResponseBody
    public void inportFile(MultipartFile file) throws Exception {
//        获取用户上传的文件
        Workbook workbook = Workbook.getWorkbook(file.getInputStream());
//        获取工作簿sheet
        Sheet sheet = workbook.getSheet(0);
//        获取总行数
        int rows = sheet.getRows();
        for (int i = 0; i < rows; i++) {
            Member member = new Member();
            member.setMembername(sheet.getCell(0, i).getContents());
            member.setMemberarddess(sheet.getCell(1, i).getContents());
            member.setMembernote(sheet.getCell(2, i).getContents());
//            添加到数据库中
            memberService.insert(member);
        }
//    关闭资源
        workbook.close();
    }


    //文件下载，SpringMVC并没有做过多的封装,还是使用原来的下载方式
    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
//       获取文件的存储位置
        String   tp = request.getSession().getServletContext().getRealPath("/static/json/1.xls");
        response.setHeader("Content-Disposition", "attachment;filename=a.xls");
        OutputStream out = response.getOutputStream();
        FileInputStream in= new FileInputStream(tp);
        IOUtils.copy(in, out);
        in.close();
        out.close();


    }

    @RequestMapping("/sufficientitem")
    @PermissionName("充值订单明细页面")
    public String sufficientitem() {
        return "sufficientitem";
    }

    @RequestMapping("/sufficientitem_list")
    @PermissionName("充值订单明细数据列表")
    @ResponseBody
    public PageResult selectSufficientitem(MemberQuery qo) {

        return memberService.queryPageResult(qo);
    }

    @RequestMapping("/select_employee")
    @PermissionName("充值订单查询会员")
    @ResponseBody
    public List<Employee> selectEmployee() {
        List<Employee> employees = memberService.selectEmployee();
        return employees;
    }

}
