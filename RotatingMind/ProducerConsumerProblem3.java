import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class ProducerConsumerProblem3{
   public volatile static boolean isEven = false;
   
   public static void main(String...args){
	   //List<Integer> l = new ArrayList<Integer>();
	   
	   Object lock = new Object();
	   EvenNumberGenerator e = new EvenNumberGenerator(lock);
	   OddNumberGenerator o = new OddNumberGenerator(lock);
	   
	   Thread pThread = new Thread(e);
	   Thread cThread = new Thread(o);
	   
	   pThread.start(); //start producer thread
	   cThread.start(); //start consumer thread
   }
}

class EvenNumberGenerator implements Runnable{
  private int num = 2;
  //private volatile boolean isEven;
  private Object lock;
  //private Random random;
  
  public EvenNumberGenerator(Object lock){
	  //this.isEven = isEven;
	  this.lock = lock;
	 // this.random = new Random();
  }
  @Override
  public void run(){
	  while(true){
		   synchronized(this.lock){
		//System.out.println("here "+ProducerConsumerProblem3.isEven);
		  if(ProducerConsumerProblem3.isEven){
			  System.out.println(num);
			  num += 2;
			  ProducerConsumerProblem3.isEven = !ProducerConsumerProblem3.isEven;
			  
					  this.lock.notifyAll();
			//System.out.println(ProducerConsumerProblem3.isEven+" num 3 "+num);
				 
		  }else{
			  
				  try{
					  //System.out.println("wait 3 ");
					   this.lock.wait();
					   //System.out.println("wait 4 ");
				  }catch(InterruptedException ie){};
			  
		  }
		   }
		  try{
					  Thread.sleep(1000);
				  }catch(InterruptedException ie){};
	  }
  }
}

class OddNumberGenerator implements Runnable {
   //private List<Integer> l;
   private int num = 1;
   //private volatile boolean isEven;
   private Object lock;
   public OddNumberGenerator(Object lock){
	   //this.isEven = isEven;
	   this.lock = lock;
   }
   @Override
  public void run(){
	  while(true){
		  synchronized(this.lock){
			  if(!ProducerConsumerProblem3.isEven){
				  
				  System.out.println(num);
				  num += 2;
				  ProducerConsumerProblem3.isEven = !ProducerConsumerProblem3.isEven;
				  this.lock.notifyAll();
				 // System.out.println(ProducerConsumerProblem3.isEven+" num 1 "+num);
			  }else{
				  try{
					//  System.out.println("wait 1 ");
					   this.lock.wait();
					  // System.out.println("wait 2 ");
				     }catch(InterruptedException ie){};
			  }
	   }
		  try{
					  Thread.sleep(1000);
				  }catch(InterruptedException ie){};
	  }
  }
}