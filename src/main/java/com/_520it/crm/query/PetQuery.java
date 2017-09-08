package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetQuery extends QueryObject{
    private String petNameQuery;
    private String telQuery;
    private String statusQuery;
    private String menuIdQuery;
}
