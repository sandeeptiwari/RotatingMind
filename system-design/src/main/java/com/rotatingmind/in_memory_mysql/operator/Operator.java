package com.rotatingmind.in_memory_mysql.operator;

public interface Operator {
    boolean operate(String currVal, String expectedVal);
}
