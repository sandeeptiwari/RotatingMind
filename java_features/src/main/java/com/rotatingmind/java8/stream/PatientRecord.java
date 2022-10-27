package com.rotatingmind.java8.stream;

import java.util.List;
import java.util.stream.Collectors;

public class PatientRecord {

    public static void main(String[] args) {
        List<String> names =
                List.of("ABC", "DEF", "GHI", "JKL", "MNO", "DEF", "LTI", "UBS", "GHI");
        System.out.println(getRegisteredPatient(names));
    }

    private static List<String> getRegisteredPatient(List<String> names) {
        return names.stream().distinct().collect(Collectors.toList());
    }
}
