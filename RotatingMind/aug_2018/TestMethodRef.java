package com.test.sample;

interface Interf1{

	public void m1();
}

public class TestMethodRef {

	public static void m2() {
		System.out.println("Method Reference...");
	}

	public  void m3() {
		System.out.println("Instance Method Reference... ");
	}

	public void runRef() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Index "+i);
			sleep(1000);

		}
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//Interf1 i = TestMethodRef() :: m2; // class method static
		Interf1 i = new TestMethodRef() :: m3; // instance method
		i.m1();

		//new Thread(new TestThread()::run).start(); 1st way
		
		Runnable r = new TestMethodRef() :: runRef;
		new Thread(r).start();
		
		
	}

}


class TestThread implements Runnable{

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println("Index "+i);
			sleep(1000);

		}

	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}