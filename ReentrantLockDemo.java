package com.test.teggig;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

	public static void main(String[] args) throws InterruptedException {
		final ReentrantProcessor proc = new ReentrantProcessor();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				proc.firstThread();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				proc.secondThread();
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		proc.finished();
	}

}

class ReentrantProcessor{
	private int counter = 0;
	private ReentrantLock lock = new ReentrantLock();

	public void increment(){
		for (int i = 0; i < 1000; i++) {
			counter++;	
		}
	}
	public void firstThread(){
		lock.lock();
		try{
			increment();
		}finally{
			lock.unlock();
		}
	}

	public void secondThread(){
		lock.lock();
		try{
			increment();
		}finally{
			lock.unlock();
		}
	}

	public void finished(){
		System.out.println("final value of counter :: "+counter);
	}
}
