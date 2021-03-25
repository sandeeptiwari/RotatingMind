package com.test.teggig;

import java.util.StringTokenizer;

public class CandidateCode {

	public  int get_height(String[] input1){
		int i,n=0,count=0;
		int input1Len = input1.length;
		int arrLen = 2*input1Len;
		int arr[] = new int[arrLen];//syntax error
		for (int index = 0; index < input1Len; index++) {
			
			StringTokenizer stk2 = new StringTokenizer(input1[index], "#");
			while (stk2.hasMoreElements()) {
				arr[n] = Integer.parseInt(stk2.nextElement().toString());
				n++;
				
			}
		}
		
		for (int jIndex = 0; jIndex < arr.length-1; jIndex+=2) {
			if(arr[jIndex] > 7 || arr[jIndex] < 4 || arr[jIndex+1]<0 ||arr[jIndex+1]>11){
				return -1;
			}
		}
		
		for (i = 0; i < arr.length - 1; i+=2) {
			for (int j = i+2; j < arr.length-1; j+=2) {
				if(arr[i]>arr[j]){
					count++;
				}else if(arr[i] == arr[j]){
					if(arr[i+1]>arr[j+1]){
						count++;
					}
					
				}
				
			}
		}
		
		return count;
	}
	
	public static void main(String arr[]){
		CandidateCode candi = new CandidateCode();
		String arr1[] = new String[]{"5#8","5#7","6#0","5#7"};
		System.out.println(candi.get_height(arr1));
	}
}
