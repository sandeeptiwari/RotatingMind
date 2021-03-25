package com.test.teggig;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
	
	/**
	 * Available permits 
	 * @param permits
	 * @throws InterruptedException 
	 */
	public void init(int permits) throws InterruptedException{
		Semaphore semaphore = new Semaphore(permits);
		
		semaphore.release();//increment the available permits
		
		/**
		 * decrement the permits
		 * wait if there is no permit available
		 */
		semaphore.acquire();
		
		System.out.println("Available permits :: "+semaphore.availablePermits());
	}
	
	
	
	public static void main(String args[]) throws InterruptedException{
		
		/*SemaphoreDemo sem = new SemaphoreDemo();
		try {
			sem.init(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(new Runnable() {
			
			@Override
			public void run() {
			  for (int i = 0; i < 100; i++) {
				Connection.getInstance().connect();
			}
			}
		});
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
	}

}
