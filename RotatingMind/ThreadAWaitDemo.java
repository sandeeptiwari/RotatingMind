public class ThreadAWaitDemo{
	public static Object lock = new Object();
	
	public static void main(String args[]){
		ThreadAWait waitObj = new ThreadAWait(lock);
		waitObj.start();
		synchronized(waitObj){
			try{
				waitObj.wait();
			}catch(InterruptedException ie){}
		}
		System.out.println(waitObj.total);
	}
	
	

}

class ThreadAWait extends Thread{
	public int total = 0;
	private Object demo;
	public ThreadAWait(Object demo){
		this.demo = demo;
	}
	
	public void run(){
		for(int i = 0; i < 100; i++){
			total = total + i;
		}
		synchronized(this){
		//notify
		this.notify();
		}
	}
	
}