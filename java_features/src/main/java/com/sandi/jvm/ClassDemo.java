package com.sandi.jvm;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ClassDemo {
    private int age  = 0;

    public void show() {}

    public static void main(String[] args) {
        Class classDemo = ClassDemo.class;
        System.out.println("Class Loader" + classDemo.getClassLoader());
        Field[] fields = classDemo.getFields();
        System.out.println(Arrays.stream(fields).count());
    }
}
