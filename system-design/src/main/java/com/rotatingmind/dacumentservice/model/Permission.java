package com.rotatingmind.dacumentservice.model;

public enum Permission {
    READ,
    WRITE;

    public boolean includes(Permission other) {
        switch (this) {
            case WRITE -> {
                return other == WRITE || other == READ;
            }
            case READ -> {
                return other == READ;
            }
            default -> {
                return false;
            }
        }
    }

}
