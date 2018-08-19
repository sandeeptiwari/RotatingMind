package com.sandi.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestParallelStreams {

	private static Employee[] arrayOfEmps = {
			new Employee(1, "Jeff Bezos", 100000.0), 
			new Employee(2, "Bill Gates", 200000.0), 
			new Employee(3, "Birendra", 250000.0),
			new Employee(4, "Mark Zuckerberg", 300000.0)
	};

	private static List<Employee> empList;

	@BeforeEach
	public void setUp() {
		empList = Arrays.asList(arrayOfEmps);
	}
	
	@Test
	public void whenParallelStream_thenPerformOperationsInParallel() {
	    Employee[] arrayOfEmps = {
	      new Employee(1, "Jeff Bezos", 100000.0), 
	      new Employee(2, "Bill Gates", 200000.0), 
	      new Employee(3, "Mark Zuckerberg", 300000.0)
	    };
	    List<Employee> empList = Arrays.asList(arrayOfEmps);
	    empList.stream().parallel().forEach(e -> e.salaryIncrement(10.0));
	    
	    double actual = empList.get(0).getSalary();
		double expected = 100010.0;
		assertEquals(expected, actual);
	}
}
