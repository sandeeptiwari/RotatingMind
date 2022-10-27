package interview;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee1 {
    private int id;
    private String firstName;
    private String lastName;

    public Employee1(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static void main(String[] args) {
        List<Employee1> emps = new ArrayList<>();
        emps.add(new Employee1(1, "Sandeep", "Tiwari"));
        emps.add(new Employee1(2, "Naman", "Tiwari"));
        emps.add(new Employee1(3, "Kavya", "Tiwari"));
        emps.add(new Employee1(4, "Aadvik", "Tiwari"));
        emps.add(new Employee1(5, "Manish", "Anand"));
        emps.add(new Employee1(5, "Manish", "Bij"));
        emps.add(new Employee1(5, "Manish", "AAAA"));
        List<Employee1> s = emps
                .stream()
                .sorted(Comparator.comparing(Employee1::getFirstName)
                        .thenComparing(Employee1::getLastName))
                .toList();

     // emps.removeIf(emp -> emp.)
        System.out.println(s);
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.lastName;
    }
}
