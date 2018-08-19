package com.sandi.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestComparisonBasedStream {

	private static Employee[] arrayOfEmps = {
			new Employee(1, "Jeff Bezos", 100000.0), 
			new Employee(2, "Bill Gates", 200000.0), 
			new Employee(3, "Mark Zuckerberg", 300000.0)
	};
	
	private static List<Employee> empList;
	
	@BeforeEach
	public void setUp() {
		empList = Arrays.asList(arrayOfEmps);
	}
	
	@Test
	@DisplayName("Sort employee by name")
	public void whenSortStream_thenGetSortedStream() {
		List<Employee> emps = empList.stream()
									 .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
									 .collect(Collectors.toList());
		
		String expected = "Bill Gates";
		String actual = emps.get(0).getName();
		
		assertEquals(expected, actual);
	}
	
	//Note that short-circuiting will not be applied for sorted().
	
	@Test
	@DisplayName("Find min element from stream")
	public void whenFindMin_thenGetMinElementFromStream() {
		 Employee firstEmp = empList.stream()
				 					.min((e1, e2) -> e1.getId() - e2.getId())
				 					.orElseThrow(NoSuchElementException::new);
		 
		 assertTrue(firstEmp.getId() == 1);
	}
	
	@Test
	public void whenFindMax_thenGetMaxElementFromStream() {
	    Employee maxSalEmp = empList.stream()
	      .max(Comparator.comparing(Employee::getSalary))
	      .orElseThrow(NoSuchElementException::new);
	    assertTrue(maxSalEmp.getSalary() == 300000.0);
	}
	
	/**
	 * distinct() does not take any argument and returns the distinct elements in the stream, eliminating duplicates. It uses the equals() method 
	 * of the elements to decide whether two elements are equal or not:
	 */
	@Test
	@DisplayName("Distinct method example")
	public void whenApplyDistinct_thenRemoveDuplicatesFromStream() {
	    List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
	    List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());
	    assertEquals(distinctIntList, Arrays.asList(2, 5, 3, 4));
	}
	
	/**
	 * allMatch, anyMatch, and noneMatch
	 * These operations all take a predicate and return a boolean. Short-circuiting is applied and processing is stopped as soon as the answer is determined:
	 */
	
	@Test
	@DisplayName("allMatch, anyMatch, and noneMatch example")
	public void whenApplyMatch_thenReturnBoolean() {
	    List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
	    boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
	    boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
	    boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);
	    assertEquals(allEven, false);
	    assertEquals(oneEven, true);
	    assertEquals(noneMultipleOfThree, false);
	}
	
	/**
	 * Stream Specializations
	 * From what we discussed so far, Stream is a stream of object references. However, there are also the IntStream, LongStream, and DoubleStream — 
	 * which are primitive specializations for int, long and double respectively. These are quite convenient when dealing with a lot of numerical primitives.
	 * 
	 * IntStream.of(1, 2, 3);
	 * 
	 * IntStream.range(10, 20)
	 * 
	 * Stream.of(1, 2, 3)
	 */
	@Test
	@DisplayName("Create stream for primitives")
	public void whenFindMaxOnIntStream_thenGetMaxInteger() {
	    Integer latestEmpId = empList.stream()
	      .mapToInt(Employee::getId)
	      .peek(System.out::println)
	      .max()
	      .orElseThrow(NoSuchElementException::new);
	    assertTrue(latestEmpId == 3);
	}
	
	/**
	 * Specialized Operations
	 * Specialized streams provide additional operations as compared to the standard Stream — which are quite convenient when dealing with numbers.
	 * 
	 * For example sum(), average(), range() etc:
	 */
	
	@Test
	public void whenApplySumOnIntStream_thenGetSum() {
	    Double avgSal = empList.stream()
	      .mapToDouble(Employee::getSalary)
	      .average()
	      .orElseThrow(NoSuchElementException::new);
	    assertTrue(avgSal == 200000);
	}
}
