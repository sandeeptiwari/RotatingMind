class Display{
	int percent = 10, j;
	//case 1 : static synchronized void output would be regular output
	// case 2: if only synchronized method in that case irregular output would come
	public static synchronized void wish(String name){
		for(int i = 1; i < 11; i++){
			
			System.out.println(name+" Drinking milk : "+j+"%");
			j = percent * i;
			try{
				Thread.sleep(2000);
			}catch(InterruptedException ie){}
		}
		System.out.println(name+" Drinking milk : "+j+"%");
		percent = 10;
		System.out.println(" oho "+name+" mera babu ne doodh poora pee liya : ");
	}
}
class MyThread extends Thread{
	Display d;
	String name;
	
	MyThread(Display d, String name){
		this.d = d;
		this.name = name;
	}
	
	public void run(){
		d.wish(name);
	}
}

public class StaticSynchronizeDemo{
	
	public static void main(String[] args){
		/*case 1
		Display d = new Display();
		MyThread t1 = new MyThread(d, "Kavya");
		MyThread t2 = new MyThread(d, "Navya");
		MyThread t3 = new MyThread(d, "Kavya");
		MyThread t4 = new MyThread(d, "Navya");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		*/
		
		//case 2
		Display d1 = new Display();
		Display d2 = new Display();
		MyThread t1 = new MyThread(d1, "Kavya");
		MyThread t2 = new MyThread(d2, "Navya");
		
		
		t1.start();
		t2.start();
	}
}