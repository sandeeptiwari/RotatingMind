package com.rotatingmind.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NonRepeatingChar {
    /*abcdabc*/
    public Character nonRepeating1(String str) {
        return (char)str.chars().boxed().reduce((a, b) -> a^b).get().intValue();
    }

    public static void main(String[] args) {
        NonRepeatingChar obj = new NonRepeatingChar();
        System.out.println(obj.nonRepeating1("abcdabc"));
    }

    public Character nonRepeating(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            map.merge(str.charAt(i), 1, Integer::sum);
        }

        //use for loop here
        List<Map.Entry<Character, Integer>> collect = map.entrySet()
                .stream()
                .filter(ele -> ele.getValue() == 1)
                .collect(Collectors.toList());

        return collect == null ? null :
                collect.size() > 1 ? (str.indexOf(collect.get(0).getKey()) < str.indexOf(collect.get(1).getKey())
                        ? collect.get(0).getKey()
                        : collect.get(1).getKey()) : collect.get(0).getKey();
    }
}
