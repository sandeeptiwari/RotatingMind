package com.rotatingmind.ocjp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int age;

    void Student() {
        Student("John", 25);
    }

    void Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Test {
    public static void main(String[] args) {
        //Student s = new Student();
        //System.out.println(s.getName() + ":" + s.getAge());
       /* LocalDate date = LocalDate.parse("1947-08-14");
        LocalTime time = LocalTime.MAX;
        System.out.println(date.atTime(time));*/

        short arr [] = new short[2];
        arr[0] = 5;
        arr[1] = 10;
        //System.out.println("[" + arr[0] + ", " + arr[1] + "]");

        StringBuilder sb = new StringBuilder();
        //System.out.println(sb.append(null).length());

        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("D");

        List<String> list2 = new ArrayList<>();
        list2.add("B");
        list2.add("C");

        list1.addAll(1, list2);

        System.out.println(list1);
    }
}
