package com.test.teggig;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		
		final CountDownLatch latch = new CountDownLatch(3);
		System.out.println("Process started");
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("Count "+i);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					latch.countDown();
				}
				System.out.println("Done!");
			}
		});
		
		t1.start();
		latch.await();
		System.out.println("Process completed");
	}

}
