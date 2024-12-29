package com.rotatingmind.stackoverflow;

import java.util.List;

public class Probleme78708472 {

    public static void main(String[] args) {
        List<String> list = List.of("100:250:33","100:234:590","100:250:3400");
        String prefix = "vn433";
        List<String> list1 = list.stream().map(ele -> prefix + ele).toList();
    }
}

