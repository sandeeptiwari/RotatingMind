class JoinThread extends Thread{
	public void run(){
	    for(int i = 0; i < 10; i++){
			System.out.println("Seetha Thread running...");
			try{
				Thread.sleep(200);
			}catch(Exception e){
			}
		}
	}
}

public class JoinThreadDemo{
  public static void main(String args[]){
	JoinThread joinThread = new JoinThread();
	joinThread.start();
	try{
		joinThread.join();
	}catch(InterruptedException e){
	}
	
	for(int i = 0; i < 10; i++){
	   System.out.println("Rama Thread running...");
	}
  }
}