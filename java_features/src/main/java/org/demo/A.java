package org.demo;


import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A {
    
    private static Integer getAllSalary() {
        Employee e1 = new Employee(100, "A", 1, "E", null);
        Employee e2 = new Employee(101, "A2", 2, "E", null);
        Employee e3 = new Employee(103, "A3", 3, "E", null);
        Employee e4 = new Employee(104, "A4", 4, "E", null);
        Employee e5 = new Employee(105, "A5", 5, "E", null);
        Employee e6 = new Employee(106, "A6", 6, "M", null);
        Employee e7 = new Employee(107, "A7", 7, "E", null);
        Employee e8 = new Employee(108, "A8", 8, "E", null);
        Employee e9 = new Employee(109, "A9", 9, "E", null);
        List<Employee> emps = List.of(e1, e2, e3, e4, e9);
        List<Employee> emps1 = List.of(e5, e6, e7, e8);
        Employee e10 = new Employee(111111111, "A10", 10, "M", emps);
        Employee e11 = new Employee(1111111111, "A11", 11, "M", emps1);

        List<Employee> empList = List.of(e10, e11);

        return empList.stream()
                .flatMap(emp -> Stream.concat(emp.getReporties().stream(), Stream.of(emp)))
                .mapToInt(Employee::getSalary).sum();
    }

    public static void main(String[] args) {
        String strs[] = "I am going to indore".split(" ");
       /* for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }*/
       // Arrays.stream(strs).forEach(System.out::println);

        // addition of two number

        BiFunction<Integer, Integer, Integer> addFun = Integer::sum;

       // System.out.println(addFun.apply(10, 20));

        int a[] = {1, 16, 22, 43, 80};

        int sum = Arrays.stream(a).sum();

       // System.out.println(sum);

        System.out.println(getAllSalary());
    }
}

class Employee {
    private int id;
    private String name;
    private int salary;
    private String role;
    private List<Employee> reporties;

    public Employee(int id, String name, int salary, String role, List<Employee> reporties) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.role = role;
        this.reporties = reporties;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Employee> getReporties() {
        return reporties;
    }

    public void setReporties(List<Employee> reporties) {
        this.reporties = reporties;
    }
}
