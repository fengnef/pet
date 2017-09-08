package com._520it.crm.mapper;

import com._520it.crm.domain.Sufficienttake;
import java.util.List;

public interface SufficienttakeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Sufficienttake record);
    int updeteTalamount(Sufficienttake record);

    Sufficienttake selectByPrimaryKey(Long id);

    List<Sufficienttake> selectAll();

    int updateByPrimaryKey(Sufficienttake record);

    void saveMeeberFirstPunch(Sufficienttake take);
}