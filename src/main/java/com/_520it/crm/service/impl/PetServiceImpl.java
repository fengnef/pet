package com._520it.crm.service.impl;

import com._520it.crm.domain.*;
import com._520it.crm.mapper.*;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetQuery;
import com._520it.crm.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PetServiceImpl implements IPetService {
	@Autowired
	private PetMapper mapper;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private ServiceitemMapper serviceitemMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private BreedMapper breedMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Pet p, Member m, Long serviceId,Long categoryId, Long breedId)
	{
		//先保存主人
		memberMapper.insert(m);
		//根据主人id查到对应的主人对象
		Member member = memberMapper.selectByPrimaryKey(m.getId());
		//设置宠物属于哪个主人
		p.setMember(member);
		//根据serviceId查到整个项目
		Serviceitem s = serviceitemMapper.selectByItemId(serviceId);
		//根据categoryId查到类别
		Category category = categoryMapper.selectByPrimaryKey(categoryId);
		//根据breedId查到品种
		Breed breed = breedMapper.selectByPrimaryKey(breedId);
		//设置类别
		p.setCategory(category);
		//设置品种
		p.setBreed(breed);
		//将宠物跟项目关联
		p.setServiceitem(s);
		//最后保存到数据库
		return mapper.insert(p);
	}

	@Override
	public Pet selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Pet> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Pet record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPageResult(PetQuery qo) {
		//查询总结果数
		Long count = mapper.queryPageCount(qo);
		if (count == 0) {
			return new PageResult(count, Collections.EMPTY_LIST);
		}

		//查询结果集
		return new PageResult(count, mapper.queryPageResult(qo));
	}

//	保存一只宠物
	public void savePet(Pet pet) {
		mapper.savePet(pet);
	}

//	保存和修改宠物图片
	public void updatPhotoUpload(String path ,Long id) {

		mapper.updatPhotoUpload(path,id);
	}

	@Override
	public Pet selectOneConectionData(Long memberNumber) {
		return mapper.selectOneConectionData(memberNumber);
	}


}
