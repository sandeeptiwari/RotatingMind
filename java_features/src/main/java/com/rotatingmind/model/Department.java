package com.rotatingmind.model;

import java.math.BigDecimal;

public class Department {
    private Integer id;
    private String name;
    private BigDecimal size;

    public Department(Integer id, String name, BigDecimal size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }
}
