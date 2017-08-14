package com.test.teggig;

public class Test4 {

	private static int num;
	private static int num2;
	{
		num += 10;
		num2 += 10;
	}
	static {
		num += 10;
		num2 += 10;
	}

	public static void main(String[] args) {
		Test4 test = new Test4();
		System.out.println("num " + test.num);
		System.out.println("num2 - " + num2);
	}

}
