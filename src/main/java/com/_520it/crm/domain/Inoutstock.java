package com._520it.crm.domain;

public class Inoutstock {
    private Long id;

    private String name;

    private Byte start;

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

    public Byte getStart() {
        return start;
    }

    public void setStart(Byte start) {
        this.start = start;
    }
}