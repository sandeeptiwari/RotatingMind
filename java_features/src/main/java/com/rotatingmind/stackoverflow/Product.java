package com.rotatingmind.stackoverflow;

import java.math.BigDecimal;

public class Product {
    private String name;
    private Action action;
    BigDecimal price;

    public Product(String name, Action action, BigDecimal price) {
        this.name = name;
        this.action = action;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
