package stream.java8stackoverflow;

public class Employee {
    private long id;
    private String name;
    private int age;
    private int salary;
    private String departmentId;

    public Employee(long id, String name, int age, int salary, String departmentId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", departmentId "+departmentId+
                '}';
    }
}
