package com.rotatingmind.java8.stream.groupby;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question1 {

    public static void main(String[] args) {
        People p1 = new People(1, "A");
        People p2 = new People(1, "A");
        People p3 = new People(2, "B");
        People p4 = new People(3, "C");
        People p5 = new People(3, "C");

        List<People> peoples = List.of(p1, p2, p3, p4, p5);
        Map<Integer, Long> groupByPeople = peoples.stream()
                .collect(Collectors.groupingBy(People::getId, Collectors.counting()));
        System.out.println("Map :: " + groupByPeople);
    }
}

class People {
    private int id;
    private String name;

    public People(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}