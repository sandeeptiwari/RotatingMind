package com.test.sample;

public class Main {

	public static void main(String[] args) {
      
		Object lock = new Object();
		
		MyThread myThread = new MyThread(lock);
		myThread.start();
		
		System.out.println("JITOptimization method is going to release lock");
		
		try {
			synchronized (lock) {
				lock.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("JITOptimization method get notified by other one");
		
	}

}

class MyThread extends Thread{
	private Object lock;
	
	public MyThread(Object lock) {
		this.lock = lock;
	}
	public void run() {
		for (int index = 0; index < 10; index++) {
			System.out.println("index => "+index);
		}
		
		synchronized (lock) {
			lock.notify();
		}
	}
	
}
