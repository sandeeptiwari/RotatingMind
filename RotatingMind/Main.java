package com.test.teggig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public String str = "<img alt=a^2 + b^2 = c^2 title=a^2 + b^2 = c^2 class=latex-image src=\"http://d2l7hi7d3iesvu.cloudfront.net/5cac3bcb0a2a06aaa6deef3835745dfc1451501572/2e1ddb2d1ea834ff5e69795e2a0830e2.png/>";
	
	public static void main(String... args){
		Main main = new Main();
		/*int a[] = new int[]{18, 2, 2, 6, 10, 8};
		int a1[] = new int[]{1, 3, 12, 4};
		int a2[] = new int[]{12, 12, 4, 8, 4, 9};
		String result = main.triplet_sum(a, 6, 22);
		System.out.println(result);*/
		//main.getImgUrl();
		/*List<Integer> list = new ArrayList<Integer>();
		list.add(8);
		list.add(14);
		list.add(1);
		list.add(3);
		list.add(25);
		list.add(13);
		list.add(10);
		list.add(9);
		System.out.println(main.getMinItemFromList(list));*/
		//int arr[] = new int[]{2,30,15,10,8,25,80};
		//System.out.println(main.findMaxPositiveFrequency(arr));
		//"0 - 22 1985--324" "00-44  48 5555 8361"
		System.out.println(Main.solution("0 - 22 1985--324"));
	}
	
	
	public static String solution(String S) {
        if(S == null )
           return "000";
           
        int len = S.length();
        if(len == 0)
            return "000";
        
        List<Character> list = new ArrayList<Character>();
        
        for(int i = 0; i < len; i++){
            char s = S.charAt(i);
            
              if(s == '-'){
                  if(list.size() > 1){
                      if(S.charAt(i - 1) == '-')
                    	  list.add(s);
                      }  
                    }else if(s != ' '){
                     list.add(s);
            }
        }//for loop end
        
       int size = list.size();
       StringBuilder b = new StringBuilder();
       int counter = 0;
       
       for(int i = 0; i < size; i++){
          char s1 = list.get(i);
          int strLen = b.length();
          
          if( counter != 0 && counter % 3 == 0){

        	  if(s1 != '-'){
        	      b.append("-");
        	      counter = 0;
        	      b.append(s1);
        		  counter++;
        	  }
          }else if(s1 == '-'){
        	    counter++;
      	  }else{
        	  b.append(s1);
        	  counter++;
          }
           
        }
        
       return b.toString();
    }
	
	 public  String triplet_sum(int[] input1,int input2,int input3)
	    {
		// Fix the first element as input1[index]
		    for (int index = 0; index < input2-2; index++)
		    {
		       // Fix the second element as input1[jIndex]
		       for (int jIndex = index+1; jIndex < input2-1; jIndex++)
		       {
		           // Now look for the third number
		           for (int kIndex = jIndex+1; kIndex < input2; kIndex++)
		           {
		               if (input1[index] + input1[jIndex] + input1[kIndex] == input3)
		               {
		                 return "True";
		               }
		           }
		       }
		    }
			return "False";
	    }
	 
	 public void getImgUrl(int... a){
		 String patternStr = "src=\"([^\"]+)\"";
		 Pattern pattern = Pattern.compile(patternStr);
		 Matcher matcher = pattern.matcher(str);
		 if (matcher.find())
		 {
		     System.out.println(matcher.group(0));
		 }
	 }
	 
	 public int getMinItemFromList(List<Integer> list){
		  Collections.sort(list);
		  return list.get(0);
	   }
	 
	 //{2,30,15,10,8,25,80}
	 
	 public int findMaxPositiveFrequency (int [] input1, int input2){
			int [] left = new int [input2] ;
			int max = 0 , min_so_far = input1[0] ;
			for (int i = 1 ; i < input1.length ; ++i) {
				if (input1[i] < min_so_far) {
					left[i] = max ;
					min_so_far = input1[i] ;
				} else {
					max = Math.max(max, input1[i] - min_so_far) ;
					left[i] = max ;
				}
			}
			int [] right = new int [input1.length] ;
			max = 0 ;
			int max_so_far = input1[input1.length - 1] ;
			for (int i = input1.length -2 ; i >= 0 ; --i) {
				  if (input1[i] > max_so_far) {
					  right[i] = max ;
					  max_so_far = input1[i] ; 
				  } else {
					  max = Math.max(max, max_so_far - input1[i]) ;
					  right[i] = max ;
				  }
			}
			max = 0 ;
			for (int i = 0 ; i < input1.length ; ++i) {
				max = Math.max(max, left[i] + right[i]) ;
			}
			
			return max ;
		}

}
