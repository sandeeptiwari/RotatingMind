package com.basic;

import java.util.Objects;

import com.module.hello.HelloWorld;

public class StringPractice {

	public static void main(String[] args) {
		
		System.out.println("Hello world");
		
		String str = "ABCDEFG";
		
		String extractedStr = str.substring(0, str.length() );
		
		System.out.println(extractedStr);
		
		String a1 = "hello";
		String a2 = "hello";
		
		a1 = a2;
		
		
		System.out.println(a1==a2);
		
		HelloWorld hello = new HelloWorld();
		
		System.out.println("Sum of given number => "+hello.sum(4, 10));
	}
	
	
	public void stringComparision() {
		// These two have the same value
		new String("test").equals("test"); // --> true 

		// ... but they are not the same object
		String str1 = new String("test");
		if(str1 == "test") // --> false 

		// ... neither are these
		if(new String("test") == new String("test")) // --> false 

		// ... but these are because literals are interned by 
		// the compiler and thus refer to the same object
		if("test" == "test") // --> true 

		// ... string literals are concatenated by the compiler
		// and the results are interned.
		if("test" == "te" + "st") // --> true

		// ... but you should really just call Objects.equals()
		Objects.equals("test", new String("test"));// --> true
		Objects.equals(null, "test") ;// --> false
	}

}
