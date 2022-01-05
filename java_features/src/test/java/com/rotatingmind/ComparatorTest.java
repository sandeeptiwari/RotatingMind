package com.rotatingmind;

import com.rotatingmind.youtube.Comparator;
import com.rotatingmind.youtube.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComparatorTest {

    @Test
    public void testComparator() {
        Employee e1 = new Employee("Jhon", 22000);
        Employee e2 = new Employee("Mike", 32000);
        Employee e3 = new Employee("Peter", 30000);
        Employee e4 = new Employee("James", 2000);

        Comparator<Employee> cmp = (emp1, emp2) -> {
            String name1 = emp1.getName();
            String name2 = emp2.getName();
            return name1.compareTo(name2);
        };

        assertTrue(cmp.compare(e2, e1) > 0);
    }
}
