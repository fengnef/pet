package com._520it.crm.mapper;

import com._520it.crm.domain.Breed;
import com._520it.crm.query.BreedQuery;

import java.util.List;

public interface BreedMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Breed record);

    Breed selectByPrimaryKey(Long id);

    List<Breed> selectAll();

    int updateByPrimaryKey(Breed record);

    Long queryPageCount(BreedQuery qo);

    List<Breed> queryPageResult(BreedQuery qo);

    List<Breed> selectBreedByCategoryId(Long id);
}