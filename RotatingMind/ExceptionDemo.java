package com.test.teggig;

 public class ExceptionDemo {
	
	static void test() {
		try {
			String x = null;
			System.out.print(x.toString() + " ");
		}/*catch(NullPointerException n){
			System.out.println("1");
		}*/
		finally { System.out.print("finally "); }
	}
	
	
	public static void main(String[] args) {
		/*try { test(); }
		catch (Exception ex) { System.out.print("exception "); }*/
		
		CC c = new CC2();
	}

}

 
 class SubException extends ArithmeticException{
	 
 }
 
class SubSubException extends SubException{
	 
 }

class CC {
	void doStuff() throws SubException{
		
	}
}

class CC2 extends CC{
	void doStuff()throws SubException{
		
	}
}

class CC3 extends CC{
	void doStuff() throws ArithmeticException{
		
	}
}

class CC4 extends CC{
	void doStuff(int x) throws Exception{
		
	}
}

class CC5 extends CC{
	void doStuff(){
		
	}
}