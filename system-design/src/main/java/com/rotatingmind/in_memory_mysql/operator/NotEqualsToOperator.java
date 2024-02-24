package com.rotatingmind.in_memory_mysql.operator;

public class NotEqualsToOperator implements Operator{
    @Override
    public boolean operate(String currVal, String expectedVal) {
        return !currVal.equals(expectedVal);
    }
}
