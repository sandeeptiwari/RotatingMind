class DeadlockA{

	//after declaring synchronized
	// then thread required lock for execution 
	public synchronized void dead1(DeadlockB b){
		System.out.println("Thread1 starts execution of dead1 method");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException ie){}
		
		System.out.println("Thread1 trying to call B's last() method");
		b.last();
	}
	
	public synchronized void last(){
	  System.out.println("Inside A's last method");
	}
}

class DeadlockB{
	
	public synchronized void dead2(DeadlockA a){
		System.out.println("Thread2 starts execution of dead2 method");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException ie){}
		
		System.out.println("Thread2 trying to call B's last() method");
		a.last();
	}
	
	public synchronized void last(){
		System.out.println("Inside B's last method");
	}
}

class MyThread extends Thread{
	DeadlockA a = new DeadlockA();
	DeadlockB b = new DeadlockB();
	
	public void threadHandler(){
		this.start();
		a.dead1(b);  
	}
	
	@Override
	public void run(){
		b.dead2(a);
		System.out.println("execution end of Mythread");
	} 
}

public class DeadlockDemo{

	public static void main(String[] args){
		System.out.println("Inside main method");
		MyThread t = new MyThread();
		t.threadHandler();
		System.out.println("execution end of main thread");
	}

}