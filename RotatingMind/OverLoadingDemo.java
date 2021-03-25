package com.test.teggig;

public class OverLoadingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}


	

}

class A1 {
	// String #name = "Jane Doe";// compilation fail
	int $age = 24;
	Double _height = 123.5;
	// double ~temp = 37.5; not allowed compilation failed

	private int counter = 0;

	public void doit() {

	}
	public String doit(long l) {
		return "a";
	}
	public double doit(int x) {
		return 1.0;
	}

	/*public static int getInstance(){
		return counter;
	}*/
}