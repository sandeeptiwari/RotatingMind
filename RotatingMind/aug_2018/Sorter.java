package com.test.sample;

import java.util.Comparator;
import java.util.TreeSet;

public class Sorter implements Comparable<Sorter>, Comparator<Sorter> {
	
	private int num;
	private String text;

	public Sorter(int num, String text) {
		this.num = num;
		this.text = text;
	}

	@Override
	public int compare(Sorter s1, Sorter s2) {
		System.out.println("Comperator");
		return s1.num - s2.num;
	}

	@Override
	public int compareTo(Sorter o) {
		System.out.println("Comperable");
		return text.compareTo(o.text);
	}
	
	@Override
	public String toString() {
		return ""+num;
	}
	
	public static void main(String[] args) {
		Sorter s1 = new Sorter(88, "a");
		Sorter s2 = new Sorter(55, "b");
		
		TreeSet<Sorter> t1 = new TreeSet<>();
		t1.add(s1);
		t1.add(s2);
		
		/*TreeSet<Sorter> t2 = new TreeSet<>(s1);
		t2.add(s1);
		t2.add(s2);*/
		
		System.out.println(t1+" ");
	}

}