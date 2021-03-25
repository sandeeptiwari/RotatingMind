public class WaitNotifyDemo{
	
	public static void main(String[] args){
	  ThreadB b = new ThreadB();
	  b.start();
	  synchronized(b){
		  try{
			 b.wait(); //1
		  }catch(InterruptedException ie){}
		  
	  }
	  System.out.print(b.total);
	}
}

class ThreadB extends Thread{
	int total = 0;
	
	@Override
	public void run(){
		for(int i = 1; i <= 100; i++){
			total = total + i;
		}
		synchronized(this){
			this.notify();
		}
		
	}
}