public class PrintEvenOddTester{
	
	public static void main(String args[]){
		Printer print = new Printer();
		Thread oddTask = new Thread(new TaskEvenOdd(print, 20, false));
		Thread evenTask = new Thread(new TaskEvenOdd(print, 20, true));
		
		oddTask.start();
		evenTask.start();
	}
}

class TaskEvenOdd implements Runnable{
	private Printer print;
	private int max;
	private	boolean isEvenNumber;
	public TaskEvenOdd(Printer print, int max, boolean isEvenNumber){
		this.print = print;
		this.max = max;
		this.isEvenNumber = isEvenNumber;
	}
	
	public void run(){
		int number = isEvenNumber == true ? 2 : 1;
		while(number < max){
			if(isEvenNumber){
				
				print.printEvenNumber(number);
			}else{
				print.printOddNumber(number);
			}
			
			number += 2;
		}
	}
}

class Printer{
	private boolean isOdd = false;
	
	public void printEvenNumber(int number){
		synchronized(this){
			while(isOdd == false){
					try{
					wait();
				 }catch(InterruptedException ie){}
			}
		
		System.out.println(number);
		isOdd = false;
		notifyAll();
		try{
					Thread.sleep(1000);
				 }catch(InterruptedException ie){}
		}
	}
	
	public void printOddNumber(int number){
		synchronized(this){
			while(isOdd == true){
					try{
					wait();
				 }catch(InterruptedException ie){}
			}
		
		System.out.println(number);
		isOdd = true;
		notifyAll();
		try{
					Thread.sleep(1000);
				 }catch(InterruptedException ie){}
		}
	}

}