package com.rotatingmind.java8.comparator;

import com.rotatingmind.youtube.Comparator;
import com.rotatingmind.youtube.Employee;

import java.util.function.Function;

public class ComparableDemo {

    public static void main(String[] args) {
        Employee e1 = new Employee("Jhon", 22000);
        Employee e2 = new Employee("Mike", 32000);
        Employee e3 = new Employee("Peter", 30000);
        Employee e4 = new Employee("James", 2000);

        Function<Employee, Integer> getName = Employee::getSalary;
        Comparator<Employee> cmp = Comparator.comparing(getName);

        System.out.println(cmp.compare(e3, e4) > 0);
    }
}
