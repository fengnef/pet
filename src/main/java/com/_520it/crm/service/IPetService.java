package com._520it.crm.service;

import com._520it.crm.domain.Member;
import com._520it.crm.domain.Pet;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetQuery;

import java.util.List;

public interface IPetService {
	int deleteByPrimaryKey(Long id);

	int insert(Pet p, Member m, Long serviceId,Long categoryId, Long breedId);

	Pet selectByPrimaryKey(Long id);

	List<Pet> selectAll();

	int updateByPrimaryKey(Pet record);

	//查询分页结果
	PageResult queryPageResult(PetQuery qo);

	void savePet(Pet pet);

    void updatPhotoUpload(String path,Long id);

	Pet selectOneConectionData(Long memberNumber);
}
