package com.sandi.jvm.classloading;

import java.util.List;
import java.util.stream.Collectors;

//Java Virtual Machine: Class Loading

/**
 * 1- Setup intellij?eclipse
 * 2- JDK
 * 3-
 */
public class ClassLoading {

    public static void main(String[] args) {
        var  nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> allEvens = nums.stream().filter(num -> !(num % 2 == 0)).collect(Collectors.toList());
        allEvens.forEach(System.out::println);
    }
}
