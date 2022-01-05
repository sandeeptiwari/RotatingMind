package com.rotatingmind.string;

import java.util.ArrayList;
import java.util.List;

public class Generic {
    void addNumber(Number num) {
        List<? extends Number> foo1 = new ArrayList<Number>();  // Number "extends" Number (in this context)
        List<? extends Number> foo2 = new ArrayList<Integer>(); // Integer extends Number
        List<? extends Number> foo3 = new ArrayList<Double>();  // Double extends Number

        //foo2.add(Integer.decode("123"));
    }
}
