package com.test.teggig;

public class ThreadDemo {

	public static void main(String[] args) {
		/* 1-	TestFive five = new TestFive();
		five.go();
		 */

		/* 2- Runnable r = new Runnable() {
			public void run() {
				System.out.print("Cat");
			}
		};


		Thread t = new Thread(r) {
			public void run() {
				System.out.print("Dog");
			}
		};
		t.start();*/
		
		/* 3-
		 * 
		 */
		Sales s = new Sales();
		System.out.println(s.getCommision());

	}



}


abstract class Employee {
	protected abstract double getSalesAmount();
	public double getCommision() {
		return getSalesAmount() * 0.15;
	}
}
class Sales extends Employee {

	@Override
	protected double getSalesAmount() {
		return 1230.45;
	}

}

class TestFive {
	private  int x;
	public void foo() {
		int current = x;
		x = current + 1;
		System.out.print(x + ", ");
	}
	public void go() {
		for(int i = 0; i < 5; i++) {
			new Thread() {
				public void run() {
					foo();
				} }.start();
		} }
}
