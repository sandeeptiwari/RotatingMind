package com.rotatingmind.carrental.domain;

import com.rotatingmind.carrental.domain.enums.CarLogType;
import com.rotatingmind.carrental.domain.enums.CarStatus;
import com.rotatingmind.carrental.domain.enums.CarType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

public class Car extends CarCategory {
    private Long id;

    private String color;

    private String carNo;

    private double ratings;

    private List<Review> reviews;

    private Engine engine;

    private String ownerId;

    private String carImage;

    private CarStatus status;

    private CarLogType carLogType;

    private Car(Builder builder) {
        this.id = builder.id;
        this.color = builder.color;
        this.carNo = builder.carNo;
        this.ratings = builder.ratings;
        this.reviews = builder.reviews;
        this.engine = builder.engine;
        this.ownerId = builder.ownerId;
        this.carImage = builder.carImage;
        this.status = builder.status;
        this.carLogType = builder.carLogType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public CarLogType getCarLogType() {
        return carLogType;
    }

    public void setCarLogType(CarLogType carLogType) {
        this.carLogType = carLogType;
    }

    public static class Builder {
        private Long id;

        private String color;

        private String carNo;

        private double ratings;

        private List<Review> reviews;

        private Engine engine;

        private String ownerId;

        private String carImage;

        private CarStatus status;

        private CarLogType carLogType;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setCarNo(String carNo) {
            this.carNo = carNo;
            return this;
        }

        public Builder setRatings(double ratings) {
            this.ratings = ratings;
            return this;
        }

        public Builder setReviews(List<Review> reviews) {
            this.reviews = reviews;
            return this;
        }

        public Builder setEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Builder setOwnerId(String ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public Builder setCarImage(String carImage) {
            this.carImage = carImage;
            return this;
        }

        public Builder setStatus(CarStatus status) {
            this.status = status;
            return this;
        }

        public Builder setCarLogType(CarLogType carLogType) {
            this.carLogType = carLogType;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
