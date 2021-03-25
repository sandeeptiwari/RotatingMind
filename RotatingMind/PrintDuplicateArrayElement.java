/*
 *  Q1. Input an array and then print the repeating characters?? Example: Input:1,3,23,11,44,3,23,2,3. Output:3,23
*/

public class PrintDuplicateArrayElement{
	
	public int[] getDuplicateElement(int arr[]){
	  int len = array.length;
	  int i = 0, j = 1;
	  while(i < len){
		  int item = array[i];
		  int curr = array[j];
		  
		  if(i != j && item !=  Integer.MAX_VALUE && item == curr){
			  System.out.print(arr[j]+", ");
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
	public static void main(String args[]){
		PrintDuplicateArrayElement dupl = new PrintDuplicateArrayElement();
		int arr[] = new int[]{1,3,23,11,44,3,23,2,3};
		int[] filters = dupl.getDuplicateElement(arr);
		for(int i = 0; i < filters.length; i++){
			System.out.print(filters[i]);
		}
	}
}