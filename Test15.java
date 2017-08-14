package com.test.teggig;

import java.util.HashSet;
import java.util.Set;

public class Test15 {
	
	private int id;
	 private String value;

	 public Test15(int id, String value) {
	  this.id = id;
	  this.value = value;
	 }

	 public int getId() {
	  return this.id;
	 }

	 public String getValue() {
	  return this.value;
	 }

	 @Override
	 public int hashCode() {
	  final int prime = 31;
	  int result = 1;
	  result = prime * result + id;
	  result = prime * result + ((value == null) ? 0 : value.hashCode());
	  return result;
	 }
	 
	 @Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this.id == ((Test15)obj).id  && this.value.equals(((Test15)obj).value))
			return true;
		
		return false;
	}

	 public static void main(String[] args) {
	  Set<Test15> set = new HashSet<Test15>();
	  Test15 test = new Test15(1, "one");
	  Test15 tes2 = new Test15(1, "one");
	  set.add(test);
	  set.add(tes2);
	  System.out.println("Size of set is - " +set.size());
	  System.out.println("Size of set is - " +set);

	 }

}
