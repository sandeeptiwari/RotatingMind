package com.test.sample;

interface Interf{
	default void show() {
		System.out.println("Inside Interf");
	}
	
}
public class DefaaltDemo implements Interf{
	
	public void show() {
		System.out.println("Inside DefaaltDemo");
	}

	public static void main(String[] args) {
		Interf i = new DefaaltDemo();
		i.show();

	}

}
