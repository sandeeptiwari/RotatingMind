package com.test.teggig;

import java.util.Set;
import java.util.TreeSet;



public class General {

	public static void main(String[] args) {
		/*Integer i = new Integer(1) + new Integer(2);
		System.out.println(i);*/

		//StringBuilder s = new StringBuilder("123456789");
		//s.delete(0,3).delete(1,3).delete(2,5).insert(1, "24");
		/*
		 * 1- s = 123456789
		 * s.delete(0, 3) = 456789
		 * s.delete(1, 3) = 4789
		 * s.delete(2, 5) = 47
		 * s.insert(1, "24") = 4247
		 */
		//System.out.println(s);

		/*StringBuilder str = new StringBuilder("12345");
	      System.out.println("string = " + str);

	      // deleting characters from index 4 to index 9
	      str.delete(0, 3);
	      System.out.println("After deletion = " + str);*/



		/*Set set = new TreeSet();
		//set.add(new Integer(2));
		//set.add(new Integer(1));

		set.add(new String("3"));
		set.add(new String("3"));
		System.out.println(set);*/


		m1();

	}

	public static void m1(){
		try {
			throw new IllegalArgumentException();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}

}


 class Test03_2 extends Test03 {

	public Test03_2() {
		//System.out.println(super.num);
	}

	/*public static void main(String[] args) {
		Test03_2 test03_2 = new Test03_2();
	}*/
}



 class Test03 {
	private int num = 25;
}

abstract class Session implements Runnable, Cloneable {
	public void run() { /* do something */ }
	public Object clone() {
		return null; /*make a copy */ }
}

class Alligator {
	/*public static void main(String[] args) {
		int []x[] = {{1,2}, {3,4,5}, {6,7,8,9}};
		int [][]y = x;
		System.out.println(y[2][1]);
	}*/
}

class Hello {
	String title;
	int value;
	public Hello() {
		title += " World";
	}
	public Hello(int value) {
		this.value = value;
		title = "Hello";
	}
}

class AA {
	void processA() {
		System.out.println("hi");
	}
}

class BB {
	AA aa;
	void processB() {
		aa.processA();//null pointer exception
		System.out.println("hello");
	}
}


/*static class AA {
void process() throws Exception { throw new Exception(); }
}
 static class B extends AA {
 void process() { System.out.println("B"); }
 }
 public static void main(String[] args) {
 new B().process();
 } */