package com.sandi.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestStreamOps {

	//Let\'s first obtain a stream from an existing array:

	private static Employee[] arrayOfEmps = {
			new Employee(1, "Jeff Bezos", 100000.0), 
			new Employee(2, "Bill Gates", 200000.0), 
			new Employee(3, "Mark Zuckerberg", 300000.0)
	};

	//1- Stream.of(arrayOfEmps);

	//2- We can also obtain a stream from an existing list:
	private static List<Employee> empList;
	// empList.stream();

	//3- And we can create a stream from individual objects using Stream.of():
	/* Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]);
	 * Or simply using Stream.builder():
	 * 
	 * Stream.Pizza<Employee> empStreamBuilder = Stream.builder();
	 * empStreamBuilder.accept(arrayOfEmps[0]);
	 * empStreamBuilder.accept(arrayOfEmps[1]);
	 * empStreamBuilder.accept(arrayOfEmps[2]);
	 * Stream<Employee> empStream = empStreamBuilder.build();
	 */

	/******************************************** TEST ******************************************/
	
	@BeforeEach
	public void setUp() {
		empList = Arrays.asList(arrayOfEmps);
	}
	
	@Test
	@Disabled
	public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {
		empList.stream()
			   .forEach(emp -> emp.salaryIncrement(10.0));
		/*contain(
			      hasProperty("salary", equals(110000.0)),
			      hasProperty("salary", equals(220000.0)),
			      hasProperty("salary", equals(330000.0))
			    )*/
		double actual = empList.get(0).getSalary();
		double expected = 100010.0;
		assertEquals(expected, actual);
	}
	/**Detail :: 
	 *  This will effectively call the salaryIncrement() on each element in the empList.
	 *  forEach() is a terminal operation, which means that, after the operation is performed, the stream pipeline is considered consumed, and can no longer
	 *   be used. We'll talk more about terminal operations in the next section.
	 *   
	 *   map() produces a new stream after applying a function to each element of the original stream. The new stream could be of different type.
	 *   The following example converts the stream of Integers into the stream of Employee s:
	 */
	
	@Test
	@DisplayName("map method exaple")
	@Disabled
	public void whenMapIdToEmployees_thenGetEmployeeStream() {
		 /*Integer[] empIds = { 1, 2, 3 };
		    List<Employee> employees = Stream.of(empIds)
		      .map(employeeRepository::findById)
		      .collect(Collectors.toList());
		    assertEquals(employees.size(), empIds.length);*/
	}
	
	@Test
	@DisplayName("collect method example")
	public void whenCollectStreamToList_thenGetList() {
		List<Employee> employees = empList.stream().collect(Collectors.toList());
	    assertEquals(empList, employees);
	}
	
	@Test
	@DisplayName("filter method example")
	public void whenFilterEmployees_thenGetFilteredStream() {
	   // Integer[] empIds = { 1, 2, 3, 4 };
	    List<Employee> employees = //Stream.of(empIds)
	      //.map(employeeRepository::findById)
	      empList.stream()
	             .filter(e -> e != null)
	             .filter(e -> e.getSalary() > 200000)
	             .collect(Collectors.toList());
	    assertEquals(Arrays.asList(arrayOfEmps[2]), employees);
	}
	
	@Test
	@DisplayName("stream to array converter")
	@Disabled
	public void whenStreamToArray_thenGetArray() {
	    Employee[] employees = empList.stream().toArray(Employee[]::new);
	    assertEquals(empList.toArray(), employees);
	}
	
	/*
	 * A stream can hold complex data structures like Stream<List<String>>. In cases like this, flatMap() helps us to flatten the data structure
	 * to simplify further operations:
	 */
	@Test
	public void whenFlatMapEmployeeNames_thenGetNameStream() {
		 List<List<String>> namesNested = Arrays.asList( 
			      Arrays.asList("Jeff", "Bezos"), 
			      Arrays.asList("Bill", "Gates"), 
			      Arrays.asList("Mark", "Zuckerberg"));
		 
		 List<String> namesFlatStream = namesNested.stream()
			      //.flatMap(Collection::stream)
				  .flatMap( li -> li.stream())
			      .collect(Collectors.toList());
		 
		 assertEquals(namesFlatStream.size(), namesNested.size() * 2);
	}
	
	/**
	 * We saw forEach() earlier in this section, which is a terminal operation. However, sometimes we need to perform multiple operations on each element of the 
	 * stream before any terminal operation is applied.peek() can be useful in situations like this. Simply put, it performs the specified operation on each element
	 * of the stream and returns a new stream which can be used further. peek() is an intermediate operation:
	 */
	@Test
	@DisplayName("peek() example here")
	public void whenIncrementSalaryUsingPeek_thenApplyNewSalary() {
		Employee[] arrayOfEmps = {
		        new Employee(1, "Jeff Bezos", 100000.0), 
		        new Employee(2, "Bill Gates", 200000.0), 
		        new Employee(3, "Mark Zuckerberg", 300000.0)
		    };
		List<Employee> empList = Arrays.asList(arrayOfEmps);
		
		empList.stream()
	      .peek(e -> e.salaryIncrement(10.0))
	      .peek(System.out::println)
	      .collect(Collectors.toList());
      
		double actual = empList.get(0).getSalary();
		double expected = 100010.0;
		assertEquals(expected, actual);
	}
	
	/**
	 * Method Types and Pipelines
	 * As we've been discussing, stream operations are divided into intermediate and terminal operations.
	 * Intermediate operations such as filter() return a new stream on which further processing can be done. Terminal operations, such as forEach(), mark the 
	 * stream as consumed, after which point it can no longer be used further.
	 * 
	 * A stream pipeline consists of a stream source, followed by zero or more intermediate operations, and a terminal operation.
	 */
	
	@Test
	@DisplayName("Terminal operation example")
	public void whenStreamCount_thenGetElementCount() {
		Long empCount = empList.stream()
		       .filter(e -> e.getSalary() > 200000)
		       .count();
		assertTrue(empCount == 1);
	}
	
	@Test
	@DisplayName("Skip example")
	public void whenLimitInfiniteStream_thenGetFiniteElements() {
	    Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);
	    List<Integer> collect = infiniteStream
	      .skip(3)
	      .limit(5)
	      .peek(System.out::println)
	      .collect(Collectors.toList());
	    assertEquals(collect, Arrays.asList(16, 32, 64, 128, 256));
	}
	
	/**
	 * Lazy Evaluation 
	 * One of the most important characteristics of streams is that they allow for significant optimizations through lazy evaluations. 
	 * Computation on the source data is only performed when the terminal operation is initiated, and source elements are consumed only as needed.All intermediate 
	 * operations are lazy, so they're not executed until a result of a processing is actually needed.
	 * 
	 * For example, consider the findFirst() example we saw earlier. How many times is the map() operation performed here? 4 times, since the input array contains 
	 * 4 elements?
	 */
	
	@Test
	public void whenFindFirst_thenGetFirstEmployeeInStream() {
		/*Integer[] empIds = { 1, 2, 3, 4 };
	    Employee employee = Stream.of(empIds)
	      .map(employeeRepository::findById)
	      .filter(e -> e != null)
	      .filter(e -> e.getSalary() > 100000)
	      .findFirst()
	      .orElse(null);
	    assertEquals(employee.getSalary(), new Double(200000));*/
	}
}
