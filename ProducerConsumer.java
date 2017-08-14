package com.test.teggig;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ProducerConsumer {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.submit(new Producer(stack));
		executorService.submit(new Consumer(stack));
		
		executorService.shutdown();
	}

}

class Producer implements Runnable{
	private Stack<Integer> stack;
	private Random random = new Random();

	public Producer(Stack<Integer> stack){
		this.stack = stack;
	}

	@Override
	public void run() {
		while(true){
			synchronized (stack) {

				if(stack.size() == 0){
					int num = random.nextInt(10);
					System.out.println("Producer :: "+num);
					this.stack.push(num);
				}
				//System.out.println("1");
				try {
					this.stack.notifyAll();
					this.stack.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}

class Consumer implements Runnable{
	private Stack<Integer> stack;

	public Consumer(Stack<Integer> stack){
		this.stack = stack;
	}
	@Override
	public void run() {
		while(true){
			synchronized (stack) {

				if(stack.size() != 0){
					System.out.println("Consume :: "+this.stack.pop());
				}else{
					try {
						this.stack.notifyAll();
						this.stack.wait();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

}
