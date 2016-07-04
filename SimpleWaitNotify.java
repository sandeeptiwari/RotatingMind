import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleWaitNotify implements Runnable{ 

	final static Object obj = new Object();
	static boolean value = true;

	/* 
	 * You're calling wait and notifyAll on obj, but you're synchronizing on this (because you've got synchronized methods).
     * In order to wait or notify, you need to "own" the monitor first. Unsynchronize the methods, and synchronize on obj instead:
	*/
	/*public synchronized void flag()  {
    System.out.println("Before Wait");
    try {
        wait();
    } catch (InterruptedException e) {
        System.out.println("Thread interrupted");
    }
    System.out.println("After Being Notified");
  }

	public synchronized void unflag() {
		System.out.println("Before Notify All");
		notifyAll();
		System.out.println("After Notify All Method Call");
	} */
	
	public void flag()  {
    System.out.println("Before Wait");
    synchronized (obj) {
        try {
            obj.wait();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
	//SimpleWaitNotify.value = false;
    System.out.println("After Being Notified");
  }

	public void unflag() {
		System.out.println("Before Notify All");
		synchronized (obj) {
			obj.notifyAll();
		}
		//SimpleWaitNotify.value = true;
		System.out.println("After Notify All Method Call");
	}

	@Override
	public void run(){
		//while(true){
		if (value) {
        flag();
		} else {
			unflag();
		}
	 // }
	}
	
	public static void main(String...args){
		ExecutorService pool = Executors.newFixedThreadPool(4);
		SimpleWaitNotify sWait = new SimpleWaitNotify();
		pool.execute(sWait);
		for(int i = 0; i< 100; i++){
			System.out.print(i);
		}
		SimpleWaitNotify.value = false;
		SimpleWaitNotify sNotify = new SimpleWaitNotify();
		pool.execute(sNotify);
		pool.shutdown();
	}
}
