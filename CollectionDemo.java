package com.test.teggig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CollectionDemo {


	public static void main(String...args){
		/*HashSet<Object> hs = new HashSet<Object>();
		WrappedString ws1 = new WrappedString("aardvark");
		WrappedString ws2 = new WrappedString("aardvark");
		String s1 = new String("aardvark");
		String s2 = new String("aardvark");
		System.out.println("Print "+s1.hashCode());
		System.out.println(" 11=> "+s2.hashCode());
		System.out.println("1- "+s1.equals(s2));
		System.out.println(" == "+s1==s2);
		hs.add(ws1); hs.add(ws2); hs.add(s1); hs.add(s2);
		System.out.println(hs.size());*/
		
		/*List list = new ArrayList();
		list.add("1"); list.add("2"); list.add("3");
		Iterator it=reverse(list);
		for (Object obj: reverse(list))
			System.out.print(obj + ", ");*/
		//String s = "123456789";
		//s = (s-"123").replace(1,3,"24") - "89"; - not be used
		
		
	}


	public static Iterator reverse(List list) {
		Collections.reverse(list);
		return list.iterator();
	}
	

}

class WrappedString {
	private String s;
	public WrappedString(String s) { this.s = s; }

}

class MinMax<N extends Number> {
	private N min, max;
	public N getMin() { return min; }
	public N getMax() { return max; }
	public void add(N added) {
		if (min == null || added.doubleValue() < min.doubleValue())
			min = added;
		if (max == null || added.doubleValue() > max.doubleValue())
			max = added;
	}

	public void takeList(List<? extends String> list) {
		list = new ArrayList<String>();
	}
}




