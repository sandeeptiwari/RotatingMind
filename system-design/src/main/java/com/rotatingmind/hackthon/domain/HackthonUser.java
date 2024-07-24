package com.rotatingmind.hackthon.domain;

import lombok.Data;

import java.util.List;

@Data
public class HackthonUser {
    private Long userId;
    private String name;
    private List<Long> department;

    public HackthonUser(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.department = builder.department;
    }


    public static class Builder {
        private Long userId;
        private String name;
        private List<Long> department;

        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDepartment(List<Long> department) {
            this.department = department;
            return this;
        }

        public HackthonUser build() {
            return new HackthonUser(this);
        }
    }
}
