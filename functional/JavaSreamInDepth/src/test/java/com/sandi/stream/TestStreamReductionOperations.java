package com.sandi.stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestStreamReductionOperations {
	
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
	
	
	/**
	 * A reduction operation (also called as fold) takes a sequence of input elements and combines them into a single summary result by repeated application of 
	 * a combining operation. We already saw few reduction operations like findFirst(), min() and max().
	 * 
	 * Let's see the general-purpose reduce() operation in action. The most common form of reduce() is:
	 * 
	 * T reduce(T identity, BinaryOperator<T> accumulator)
	 * 
	 * Where identity is the starting value and accumulator is the binary operation we repeated apply.
	 */
	
	@Test
	@DisplayName("Reduction example")
	@Disabled
	public void whenApplyReduceOnStream_thenGetValue() {
	    Double sumSal = empList.stream()
	      .map(Employee::getSalary)
	      .reduce(0.0, Double::sum);
	    assertTrue(sumSal== 600000);
	}
	
	@Test
	@DisplayName("Reduction GetJoinedString")
	@Disabled
	public void whenCollectByJoining_thenGetJoinedString() {
	    String empNames = empList.stream()
	      .map(Employee::getName)
	      .collect(Collectors.joining(", "))
	      .toString();
	    assertTrue(empNames.equalsIgnoreCase("Jeff Bezos, Bill Gates, Mark Zuckerberg"));
	}

	@Test
	@DisplayName("GetBasicStats")
	public void whenApplySummarizing_thenGetBasicStats() {
	    DoubleSummaryStatistics stats = empList.stream()
	      .collect(Collectors.summarizingDouble(Employee::getSalary));
	    assertTrue(stats.getCount()==3);
	    assertTrue(stats.getSum() == 600000.0);
	    assertTrue(stats.getMin() == 100000.0);
	    assertTrue(stats.getMax() == 300000.0);
	    assertTrue(stats.getAverage() == 200000.0);
	}
	
	@Test
	public void whenApplySummaryStatistics_thenGetBasicStats() {
	    DoubleSummaryStatistics stats = empList.stream()
	      .mapToDouble(Employee::getSalary)
	      .summaryStatistics();

	    assertTrue(stats.getCount()==3);
	    assertTrue(stats.getSum() == 600000.0);
	    assertTrue(stats.getMin() == 100000.0);
	    assertTrue(stats.getMax() == 300000.0);
	    assertTrue(stats.getAverage() == 200000.0);
	}
	
	/**
	 * partitioningBy
	 * We can partition a stream into two — based on whether the elements satisfy certain criteria or not.
	 * Let's split our List of numerical data, into even and ods:
	 */
	@Test
	@DisplayName("Partition test of even/odd")
	public void whenStreamPartition_thenGetMap() {
	    List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
	    Map<Boolean, List<Integer>> isEven = 
	    				intList.stream()
	    				.collect(Collectors.partitioningBy(i -> i % 2 == 0));
	    
	    
	    assertTrue(isEven.get(true).size() == 4);
	    assertTrue(isEven.get(false).size() == 1);
	}
	
	/*
	 * groupingBy
	 * groupingBy() offers advanced partitioning — where we can partition the stream into more than just two groups.
	 * It takes a classification function as its parameter. This classification function is applied to each element of the stream.
	 * The value returned by the function is used as a key to the map that we get from the groupingBy collector:
	 */
	@Test
	@DisplayName("Grouping test of even/odd")
	@Disabled
	public void whenStreamGroupingBy_thenGetMap() {
		Map<Character, List<Employee>> groupByAlphabet = empList.stream().collect(
			      Collectors.groupingBy(e -> e.getName().charAt(0)));
		//System.out.println(groupByAlphabet);
		
		assertTrue(groupByAlphabet.get('B').get(0).getName().equals("Bill Gates"));
		assertTrue(groupByAlphabet.get('J').get(0).getName().equals("Jeff Bezos"));
		assertTrue(groupByAlphabet.get('M').get(0).getName().equals("Mark Zuckerberg"));
	}
	
	/**
	 * reducing() is similar to reduce() — which we explored before. It simply returns a collector which performs a reduction of its input elements:
	 */
	@Test
	@DisplayName("StreamReducing_thenGetValue")
	public void whenStreamReducing_thenGetValue() {
	    Double percentage = 10.0;
	    Double salIncrOverhead = empList.stream().collect(Collectors.reducing(
	        0.0, e -> e.getSalary() * percentage / 100, (s1, s2) -> s1 + s2));
	    assertTrue(salIncrOverhead == 60000.0);
	}
	
	@Test
	@DisplayName("StreamGroupingAndReducing_thenGetMap")
	public void whenStreamGroupingAndReducing_thenGetMap() {
	    Comparator<Employee> byNameLength = Comparator.comparing(Employee::getName);
	    
	    Map<Character, Optional<Employee>> longestNameByAlphabet = empList.stream().collect(
	      Collectors.groupingBy(e -> e.getName().charAt(0),
	        Collectors.reducing(BinaryOperator.maxBy(byNameLength))));
	    
	    System.out.println(longestNameByAlphabet);
	    
	    //assertTrue(longestNameByAlphabet.get('B').get().getName().equals("Bill Gates"));
	    //assertTrue(longestNameByAlphabet.get('J').get().getName().equals("Jeff Bezos"));
	    //assertTrue(longestNameByAlphabet.get('M').get().getName().equals("Mark Zuckerberg"));
	}
}
