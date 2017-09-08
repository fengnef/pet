package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberQuery extends QueryObject {

//    会员姓名
    private String menberName;
//    会员卡号
    private String  membernumber;
//    订单编号
    private  String rechargenumber;
}
