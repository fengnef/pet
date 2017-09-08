package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Shop {
    private Long id;

    private String name;

    private Byte type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}