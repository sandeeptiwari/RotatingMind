package com.sandi.app;

import java.util.HashMap;

public class FindPair {

	public int[] findPair(int[] x, int[] y, int value){
		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		 int pair[] = new int[2];
		 
		 for (int index = 0; index < y.length; index++) {
			  map.put(index, y[0]);
		}
		 
		 for (int i = 0; i < x.length; i++) {
			
			  int xi = x[i];
			  
			  int yi = value - xi;
			  
			  if(map.containsValue(yi)) {
				  pair[0] = i;
				  pair[1] = findPos(y, yi);
				return  pair; 
			  }
			
		}
		
		return null;

	}
	
	public int findPos(int []a, int val) {
		
		for (int i = 0; i < a.length; i++) {
			if(a[i] == val)
				return i;
		}
		
		return -1;
		
	}

	public static void main(String[] args) {

	}

}

