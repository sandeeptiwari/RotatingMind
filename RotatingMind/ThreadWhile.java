public class ThreadWhile{
	static int loop=1;// loop = true;
	public static void main(String args[]){
	Thread t = new Thread(new Runnable(){
		 public void run()
		 {
		while(loop==1){
			System.out.println("Khajan "+loop);
		 }}
	 });
	 t.start();
//System.out.println("dljfdljfdljf");	 

	Thread t2 = new Thread(new Runnable(){
		 public void run()
		 {
		loop=0;
		
		}
	});
	
	 t2.start();
	
}

}