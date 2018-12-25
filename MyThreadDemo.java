class MyThread extends Thread{
	
	@Override
	public void start(){
		System.out.println("Child start");
		super.start();
	}
	@Override
	public void run(){
	 for(int i = 0; i< 10 ; i++){
		System.out.println("Child Thread");
	  }
	}
}
public class MyThreadDemo{
	
	public static void main(String[] args){
	  
	  //,MyThread myThread = new MyThread();
	  for(int i = 0; i< 10 ; i++){
		System.out.println("JITOptimization Thread");
	  }
	  System.out.println("Before setting priority of main thread");
	  System.out.println("mainThread priority is "+Thread.currentThread().getPriority());// 5
	  //System.out.println("MyThread priority is "+myThread.getPriority());// 5
	  
	  Thread.currentThread().setPriority(7);
	  MyThread myThread = new MyThread();//if you instantiate it before setting main thread priority then its priority would be 5
	  System.out.println("after setting priority of main thread");
	  System.out.println(" JITOptimization thread priority "+Thread.currentThread().getPriority());//7
	  System.out.println("MyThread priority is "+myThread.getPriority());// 7
	  
	  myThread.start();
	}

}

