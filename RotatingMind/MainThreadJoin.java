class MyThreadJoin extends Thread{
	
	static int updatedValue = 1;
	static Thread mt;
	
	@Override
	public void run(){
		try{
			mt.join();
		}catch(InterruptedException ie){}
		
		for(int i = 0; i < 10; i++){
		System.out.println("child thread "+(100/updatedValue));		
		}
	}
}

public class MainThreadJoin{
 
 public static void main(String[] args){
	
	MyThreadJoin.mt = Thread.currentThread();
	MyThreadJoin t = new MyThreadJoin();
	t.start();
	//t.join();  deadlock situation example 
	/*
	  Thread.currentThread().join();
	  main thread calls join on main thread, its also a dealock condition
	  if thread calls join method on same thread itself, then thread the
	  program will be stucked, its something like deadlock.
	  t.interrupt() ->  child thread interrupted by main thread after interruption
	  thread execution stopped.
	*/
	for(int i = 0; i < 10; i++){
		System.out.println("main thread "+MyThreadJoin.updatedValue);
		try{
			Thread.sleep(2000);
		}catch(InterruptedException ie){
			
		}
		MyThreadJoin.updatedValue = MyThreadJoin.updatedValue + i;
	}
 
 }

}