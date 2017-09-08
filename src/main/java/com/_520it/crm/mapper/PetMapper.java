package com._520it.crm.mapper;

import com._520it.crm.domain.Pet;
import com._520it.crm.query.PetQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PetMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Pet record);

    Pet selectByPrimaryKey(Long id);

    Pet selectOneConectionData(Long memberNumber);

    List<Pet> selectAll();

    int updateByPrimaryKey(Pet record);

    Long queryPageCount(PetQuery qo);

    List<?> queryPageResult(PetQuery qo);

    void savePet(Pet pet);

    //保存宠物图片
    void updatPhotoUpload(@Param("path") String path, @Param("petId") Long petId);
}