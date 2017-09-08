package com._520it.crm.service.impl;

import com._520it.crm.domain.*;
import com._520it.crm.mapper.*;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.MemberQuery;
import com._520it.crm.service.IMemberService;
import org.apache.ibatis.jdbc.Null;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.weaver.MemberKind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private MemberMapper mapper;
    @Autowired
    private SufficientitemMapper sufficientitemMapper;
    @Autowired
    private SufficienttakeMapper sufficienttakeMapper;
    @Autowired
    private PetMapper petMapper;



    //	 保存会员功能
    public void saveMemberAndPet(Member member, Pet pet) {
//        保存会员
        member.setMemberstart(true);
        mapper.insert(member);
//        保存会员首冲金额
        Sufficienttake take = new Sufficienttake();
        take.setTotalamount(member.getMemberprice());
        take.setMembername(member);
        take.setVipmember(member.getVipmember());
        sufficienttakeMapper.saveMeeberFirstPunch(take);
//        保存宠物
        pet.setMember(member);
         petMapper.savePet(pet);
    }

//    查询员工
    public List<Employee> selectEmployee() {
      return mapper.selectEmployee();
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Member record) {
        return mapper.insert(record);
    }

    @Override
    public Member selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Member> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Member record) {
        return mapper.updateByPrimaryKey(record);
    }


    //	会员等级查询
    public List<Vipmember> selectVIPMember() {
        return mapper.selectVIPMember();
    }

    //	保存会员充值明细
    public void saveSufficientitem(Sufficientitem item) {
//		先保存订单明细
        Member member = mapper.selectByPrimaryKey(item.getMembername().getId());
        item.setRechargetime(new Date());
        item.setUsergroupname(member.getMembername());
        item.setUsergroupcode(item.getId().toString());
        sufficientitemMapper.insert(item);
//查询会员充值记录 ,并保存总价格和最大充值数
        Sufficienttake take = sufficienttakeMapper.selectByPrimaryKey(item.getMembername().getId());
        if(take.getTotalamount()!=null){
        take.setTotalamount(take.getTotalamount().add(item.getRechargeprice()));
        }else {
            take.setTotalamount(item.getRechargeprice());
        }
        if (take.getMaxrechargeprice().compareTo(item.getRechargeprice()) > 0) {
            take.setMaxrechargeprice(item.getRechargeprice());
        }
        sufficienttakeMapper.updeteTalamount(take);

    }

    @Override
    public Sufficienttake sufficientTake(Long id) {
        return sufficienttakeMapper.selectByPrimaryKey(id);
    }

    //会员退卡
    public void updatMemberstart(Long id) {
        mapper.updatMemberstart(id);
    }



    //账单查询
    public PageResult queryPageResult(MemberQuery qo) {
        //查询总结果数
        Long count = sufficientitemMapper.queryPageCount(qo);
        if (count == 0) {
            return new PageResult(count, Collections.EMPTY_LIST);
        }

        //查询结果集
        return new PageResult(count, sufficientitemMapper.selectSufficientitem(qo));
    }


}
