package com.sandi.app;

import java.util.Arrays;

public class MaxOccurenceEleInArray {
	
	//{1, 3, 4, 5, 6, 3, 4, 3, 9, 3}
	public int findMaxRepeatingArrayEle(int[] arr) {
		int max = 0, curr = 0, maxCount = 0, currCount = 0;
		Arrays.sort(arr);
		int len = arr.length;
		
		for (int i = 1; i < len; i++) {
			int j = arr[i];
			
			if(arr[i -1] == arr[i]) {
				currCount++;
			}
			else {
				currCount = 1;
				curr = arr[i];
			}
				
			if(maxCount < currCount) {
				maxCount = currCount;
				max = curr;
			}
			
		}
		
		return max;
	}
	
	//{1, 3, 3, 5, 3, 3, 4, 3, 9, 3}
	//By Moor's voting Algorithm
	public int getMajorityEleInArray(int arr[]) {
		int majIndex = 0, count = 1;
		int ele = 0;
		
		for (int i = 1; i < arr.length; i++) {
			
			if(arr[majIndex] == arr[i]) {
				count++;
			}else {
				count--;
			}
			
			if(count == 0) {
				count = 1;
				majIndex = i;
			}
		}
		
		ele = arr[majIndex];
		count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == ele)
				count++;
		}
		
		if(count > arr.length / 2)
		   return ele;
		
		return Integer.MIN_VALUE;
	}
	
	
	//How to find the only number in an array that doesn't occur twice
	//{3, 4, 5, 3, 4}
	public int getOccursOne(int arr[]) {
		int ele = 0;
		for (int i = 0; i < arr.length; i++) {
			ele = ele^arr[i];
		}
		
		return ele;
	}


}
