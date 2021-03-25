/*
 *  Q1. Input an array and then print the repeating characters?? Example: Input:1,3,23,11,44,3,23,2,3. Output:3,23
*/

public class RepeatingChar{

  public void getRepeatedItems(int[] array){
	  int len = array.length;
	  int i = 0, j = 1;
	  while(i < len){
		  
		  int item = array[i];
		  int curr = array[j];
		  
		  if(i != j && item !=  Integer.MAX_VALUE && item == curr){
			 System.out.print(array[j]+",");
			 array[j] = Integer.MAX_VALUE;
			 j = i+1;
			 i++;
		  }else if(j < len){
			  j++;
		  }
		  if(j >= len){
			  j = i+1;
			  i++;
		  } 
	  }
  }
  
  public static void main(String...args){
	  int []arr = new int[]{1,3,23,11,44,3,23,2,3};
	  RepeatingChar repeatingItems = new RepeatingChar();
	  repeatingItems.getRepeatedItems(arr);
  }
}