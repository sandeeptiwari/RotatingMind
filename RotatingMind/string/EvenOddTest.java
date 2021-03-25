package com.basic;

interface EvenOddTester{
	
	boolean isOdd(int number);
	
}
public class EvenOddTest {
	
	public EvenOddTester checker(int number) {
		 
		return (n) -> (number % 2 != 0);
	}

	public static void main(String[] args) {
      
		EvenOddTester et = (n) -> (n % 2 != 0);
		boolean isOdd = et.isOdd(10);
		System.out.println(isOdd ? "ODD" : "EVEN");
	}

}
