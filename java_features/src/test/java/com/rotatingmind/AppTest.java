package com.rotatingmind;


import com.rotatingmind.java16.pattern.Person;
import com.rotatingmind.java8.functional.predicate.Predicate;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        List<Employee1> empList = new ArrayList<>();
        List<Employee1> modifiedEmpList = empList.stream()
                .filter(Objects::nonNull)
                .filter(emp -> emp.getName().length() > 3)
                .collect(Collectors.toList());
        assertTrue( true );
    }



    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("US", "travel");
        map.put("US", "play");
        map.put("IND", "work");
        map.put(null, "work");

        assertTrue(map.size() == 3);
    }
}

class Employee1 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
