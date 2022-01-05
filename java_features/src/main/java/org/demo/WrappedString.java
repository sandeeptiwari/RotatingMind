package org.demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class WrappedString {
    private String s;

    public WrappedString(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        HashSet<Object> hs = new HashSet<Object>();
        WrappedString ws1 = new WrappedString("A");
        WrappedString ws2 = new WrappedString("B");

        String s1 = new String("A");
        String s2 = new String("B");
        hs.add(ws1);
        hs.add(ws2);
        hs.add(s1);
        hs.add(s2);

        System.out.println(hs.size());

    }
}
