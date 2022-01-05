package com.rottaingmind.ds.linklist;

import java.util.Comparator;

public class Person implements Comparable<Person>{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return Comparator.comparing(Person::getName)
                .thenComparing(Person::getAge)
                .compare(this, o);
    }

    @Override
    public String toString() {
        return name;
    }
}
