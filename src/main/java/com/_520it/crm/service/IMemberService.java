package com._520it.crm.service;

import com._520it.crm.domain.*;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.MemberQuery;

import java.util.List;

public interface IMemberService {
	int deleteByPrimaryKey(Long id);

	int insert(Member record);

	Member selectByPrimaryKey(Long id);

	List<Member> selectAll();

	int updateByPrimaryKey(Member record);



	List<Vipmember> selectVIPMember();

    void saveSufficientitem(Sufficientitem item);

	Sufficienttake sufficientTake(Long id);

    void updatMemberstart(Long id);


	 PageResult queryPageResult(MemberQuery qo) ;

    void saveMemberAndPet(Member member, Pet pet);

    List<Employee> selectEmployee();
}
