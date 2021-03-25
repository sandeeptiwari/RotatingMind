/* Producer consumer problem */
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class ProducerConsumerDemoTwo{
   
   public static void main(String...args){
	  List<Integer> data = new ArrayList<Integer>();
	  Producer producer = new Producer(data);
	  Consumer consumer = new Consumer(data);
	  producer.start();
	  consumer.start();
   }
}

class Producer extends Thread{
	private List<Integer> data;
	private int number;
	private Random random;
	Producer(List<Integer> data){
		this.data = data;
        random = new Random();
	}
	
	@Override
	public void run(){
		while(true){
			if(data.size() == 0){
				number = random.nextInt(10);
				System.out.println("Produce "+number);
				data.add(0, number);
				synchronized(data){
					data.notifyAll();
				}
			}else{
				synchronized(data){
					try{
						data.wait();
					}catch(InterruptedException ie){}
				}
			}
			
			try{
						Thread.sleep(1000);
					}catch(InterruptedException ie){}
		}
	}
}
class Consumer extends Thread{
	private List<Integer> data;
	
	public Consumer(List<Integer> data){
		this.data = data;
	}
	@Override
	public void run(){
		while(true){
			if(data.size() != 0){
				System.out.println("Consumed "+data.get(0));
				data.clear();
				synchronized(data){
					data.notifyAll();
				}
			}else{
				synchronized(data){
					try{
						data.wait();
					}catch(InterruptedException ie){}
					
				}
			}
			
			try{
						Thread.sleep(1000);
					}catch(InterruptedException ie){}
		}
	}
}