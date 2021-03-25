package com.sandi.ocp;

public class Outer {
	
	private int x = 24;
	
	public int getX() {
		String message = " x is ";
		class Inner{
			private int x = 10;//Outer.this.x - 24;
			
			public void printX() {
				System.out.println(message + x);
			}
		}
		
		
	 Inner in =  new Inner();
	 in.printX();
	 
	 return in.x;
	 
	}

	public static void main(String[] args) {
		new Outer().getX();
	}

}
