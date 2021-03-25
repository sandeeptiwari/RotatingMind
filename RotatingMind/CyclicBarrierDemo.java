package com.test.teggig;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("T1 Run start");
				try {
					cyclicBarrier.await();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
				
				System.out.println("T1 Run completed");
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("T2 Run start");
				try {
					cyclicBarrier.await();
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("T2 Run completed");
			}
		});


		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("T3 Run start");
				try {
					cyclicBarrier.await();
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("T3 Run completed");
			}
		});
		
		t1.start();
		t2.start();
		t3.start();

	}

}
