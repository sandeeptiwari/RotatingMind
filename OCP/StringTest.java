package com.sandi.ocp;

public class StringTest {

	public static void main(String[] args) {
		
		String s1 = "Canada";
		String s2 = new String(s1);
		
		//if(s1 == s2) System.out.println("s1==s2");
		//if(s1.equals(s2)) System.out.println("s1.equals(s2)");
		
		String a = "Sandeep Tiwari";
		String b = "Sandeep Tiwari1";
		
		System.out.println(a.equals(b)+" Hashcode "+(a.hashCode() == b.hashCode()));
	}

}
