package com.rotatingmind.carrental.domain;

import com.rotatingmind.carrental.domain.enums.CarType;
import lombok.Builder;
import lombok.Data;

public class CarCategory {



    private Long categoryId;

    private String name;

    private int capacity;

    private double pricePerHr;

    private double lateFeePerHr;

    private CarType carType;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPricePerHr() {
        return pricePerHr;
    }

    public void setPricePerHr(double pricePerHr) {
        this.pricePerHr = pricePerHr;
    }

    public double getLateFeePerHr() {
        return lateFeePerHr;
    }

    public void setLateFeePerHr(double lateFeePerHr) {
        this.lateFeePerHr = lateFeePerHr;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
