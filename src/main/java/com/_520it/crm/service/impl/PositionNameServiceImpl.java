package com._520it.crm.service.impl;

import com._520it.crm.domain.PositionName;
import com._520it.crm.mapper.PositionNameMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IPositionNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PositionNameServiceImpl implements IPositionNameService {
    @Autowired
    private PositionNameMapper mapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PositionName record) {

        return mapper.insert(record);
    }

    @Override
    public PositionName selectByPrimaryKey(Long id) {

        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PositionName> selectAll() {

        return mapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(PositionName record) {

        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPageResult(QueryObject qo) {
        //查询总结果数
        Long count = mapper.queryPageCount(qo);
        if(count==0){
            return new PageResult(count, Collections.EMPTY_LIST);
        }

        //查询结果集
        return new PageResult(count, mapper.queryPageResult(qo));
    }

    /*@Override
    public PageResult querySalalryPageResult(SalaryQuery qo) {
        Long count = mapper.querySalaryPageCount(qo);
        if (count==0){
            return new PageResult(count, Collections.EMPTY_LIST);
        }
        List<PositionName> lists = mapper.querySalaryPageResult(qo);
        for (PositionName p :lists){

            if (p.getLeaver()==null || !p.getLeaver().getState()){
                //提成
                BigDecimal base = p.getPostallowance().add(p.getTrafficsubsidies()).add(
                        p.getPhonesubsidies()).add(p.getSubsidizedmeals()).add(p.getFulltime());
                p.setCommission(p.getCommission().divide(new BigDecimal("100")).multiply(base));
                p.setSalary(new BigDecimal("0"));
                p.setTotal(base.add(p.getCommission()).add(p.getEmployee().getBasicSalary()));
            }else {
                p.setFulltime(new BigDecimal("0"));
                BigDecimal base = p.getPostallowance().add(p.getTrafficsubsidies()).add(
                        p.getPhonesubsidies()).add(p.getSubsidizedmeals());
                p.setCommission(p.getCommission().divide(new BigDecimal("100")).multiply(base));
                //请假一次扣除一天的工资
                BigDecimal divide1 = p.getEmployee().getBasicSalary().divide(new BigDecimal("21.75"),2, RoundingMode.HALF_UP );
                p.setSalary(divide1.multiply(new BigDecimal(p.getLeaver().getLeaveDuration())));
                p.setTotal(p.getEmployee().getBasicSalary().add(base).add(p.getCommission()).subtract(p.getCommission()));
            }
        }
        return new  PageResult(count,lists);
    }*/

}
