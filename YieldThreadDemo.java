class YieldThread extends Thread{ 
	public static Thread mainThread;
   @Override
   public void run(){
	   //try{
		//	mainThread.join();
		//}catch(InterruptedException ie){}
	
	   for(int i = 0; i< 10; i++){
		   System.out.println("Child Thread");
		   
	   }
   }
}

public class YieldThreadDemo{
 
  public static void main(String[] args){
	YieldThread t = new YieldThread();
	t.mainThread = Thread.currentThread();
	t.start();
	
	try{
		t.join();
	}catch(InterruptedException ie){}
	
	for(int i = 0; i< 10; i++){
		   System.out.println("Main Thread");
		  // Thread.yield();
	   }
  }
}