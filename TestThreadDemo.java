package com.test.teggig;

public class TestThreadDemo extends Thread {

	private int x = 2;
	
	public TestThreadDemo(){
		x = 5;
		start();
	}
	public void makeItSo()throws Exception{
		join();
		x = x - 1;
		System.out.println(x);//9
	}

	public void run(){
		x*=2;
	}	
	
	public static void main(String[] args)throws Exception {
		//new TestThreadDemo().makeItSo();
		//System.out.println(String.class.getClassLoader());//null
		//System.out.println(TestThreadDemo.class.getClassLoader());
		TestThreadDemo s = new TestThreadDemo();
		//s = null;
		//System.gc();
		//System.out.println("main method");
		String sa[] = {"Hi", "world"};
		s.go(10, "hi");
		s.go(10, "hi", "world");
	}
	
	/*
	 *go(String...y, int x) compilation failed, var-arg must be last parameter 
	 */
	public void go(int x, String...y){
		System.out.print(y[y.length - 1]+" ");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("called");
		super.finalize();
	}

	
}

class TestGeneric<X extends Object>{
	
	private X x;
	
	public TestGeneric(X x){
		this.x = x;
		//System.out.println(x.getDoubl());
	}
	
}
