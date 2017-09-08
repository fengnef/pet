package com._520it.crm.mapper;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Member;
import com._520it.crm.domain.Vipmember;
import sun.rmi.runtime.Log;

import java.util.List;

public interface MemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Member record);

    Member selectByPrimaryKey(Long id);

    List<Member> selectAll();

    int updateByPrimaryKey(Member record);

    /**
     * 会员等级查询
     * @return
     */
    List<Vipmember> selectVIPMember();

//    会员退卡
    void updatMemberstart(Long id);

    List<Employee> selectEmployee();
}