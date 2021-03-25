import java.util.*;
public class ProducerConsumerDemo{
	
	public static void main(String args[]){
		 List<Integer> stack = new ArrayList<Integer>();
		Producer p = new Producer(stack);
		Consumer c = new Consumer(stack);
		p.start();
		c.start();
		
		
	}

}

class Producer extends Thread{
	
	public Producer(List<Integer> s) {
            mStack = s;
        }

        private List<Integer> mStack = null;
        private int mNumber = 0;
	
	public void run(){
		while(true){
			 
			synchronized(mStack){
				System.out.println("producer produces :  and notify ");
				
				while(mStack.size() != 0){
					try{
                            mStack.wait(); // this.wait();
                        } catch(Exception e)
                        {
                            e.printStackTrace();
                        }
				}
				
				mNumber++;
			
				System.out.println("Producer generates number:" + mNumber);
                mStack.add(0, mNumber);
                mStack.notifyAll();// this.notifyAll();
				
				try{
					Thread.sleep(2000);
				}catch(Exception e){}
			}
		}
	}

}

class Consumer extends Thread{
	
	public Consumer(List<Integer> s) {
            mStack = s;
        }

        private List<Integer> mStack = null;
	
	public void run(){
		while(true){
			
			 System.out.println("q size : "+mStack.size());
			synchronized(mStack){
				while(mStack.size() == 0){
					System.out.println("q size : in wait "+mStack.size());
					try{
                            mStack.wait(); // this.wait();
                        } catch(Exception e)
                        {
                            e.printStackTrace();
                        }
					
				}
				int number = mStack.get(0);
				mStack.clear();
                System.out.println("Consumer consumes number:" + number);
                mStack.notifyAll();
				
				try{
					Thread.sleep(2000);
				}catch(Exception e){}
			}
		}
	}
}