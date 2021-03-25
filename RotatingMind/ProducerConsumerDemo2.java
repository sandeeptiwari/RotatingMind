package com.test.teggig;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumerDemo2 {

	public static void main(String[] args) throws InterruptedException {
		final Processor process = new Processor();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					process.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					process.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}


class Processor {
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private Object lock = new Object();
	private static final int LIMIT = 10;
	private int value = 0;
	public void produce() throws InterruptedException{
		while(true){
			synchronized (lock) {
				while(list.size() == LIMIT){
					//System.out.println("==========pppp");
					lock.wait();
				}
				
				list.add(value++);
				lock.notify();
			}
			
		}

	}

	public void consume() throws InterruptedException{
		Random r = new Random();
		while(true){
			synchronized (lock) {
				while(list.size() == 0){
					//System.out.println("==========cccc");
					lock.wait();
				}
				
				System.out.println("List size is :: "+list.size());
				int value = list.removeFirst();
				System.out.println("value is :: "+value);
				lock.notify();

			}
			
			Thread.sleep(r.nextInt(3000));
		}
	}
}