package com.test.teggig;

public class EvenOddNumberDemo {

	public static void main(String[] args) {
		Printer printer = new Printer();
		
		Thread evenTask = new Thread(new EvenOddTask(printer, 20, true));
		Thread oddTask = new Thread(new EvenOddTask(printer, 20, false));
		
		evenTask.start();
		oddTask.start();
	}

}

class EvenOddTask implements Runnable{
	private Printer print;
	private int max;
	private boolean isEvenNumber;
	
	public EvenOddTask(Printer print, int max, boolean isEvenNumber){
		this.print = print;
		this.max = max;
		this.isEvenNumber = isEvenNumber;
	}

	@Override
	public void run() {
		
		int number = isEvenNumber == true ? 2 : 1; 
		
		while(number < max){
			if(isEvenNumber){
				print.printEven(number);
			}else{
				print.printOdd(number);
			}
			
			number += 2;
		}
		
	}
	
}


class Printer {
	
	boolean isOdd = false;
	
	public void printEven(int number){
		synchronized (this) {
			while(!isOdd){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(number);
			isOdd = false;
			notifyAll();
		}
	}
	
	public void printOdd(int number){
		synchronized (this) {
			while(isOdd){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(number);
			isOdd = true;
			notifyAll();
		}
	}
	
}