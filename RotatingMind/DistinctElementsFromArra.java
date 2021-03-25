/*Print All Distinct Elements of a given integer array
Examples:
Input: arr[] = {12, 10, 9, 45, 2, 10, 10, 45}
Output: 12, 10, 9, 45, 2

Input: arr[] = {1, 2, 3, 4, 5}
Output: 1, 2, 3, 4, 5

Input: arr[] = {1, 1, 1, 1, 1}
Output: 1
*/

import java.util.*;

public class DistinctElementsFromArra{
	
	public void filter(int arr[]){
		int len = arr.length;
		String str = "";
		int j = 0;
		for(int i = 0; j > i; j =  len - 1){
			 
			if(j > i){
				if(arr[i] == arr[j]){
					arr[j] = -1;
				j--;
			}
		  }else{
			  j = len - 1;
			  i++;
		  }
		}
		for(int index = 0; index < len ; index++){
			if(arr[index] == -1)
				continue;
			System.out.print(arr[index]);
		}		
	}
	
	
    public void main() 
    {
        int[] numbers = {12, 10, 9, 45, 2, 10, 10, 45};//{ -5, -3, 6, 6, 8, 9, 69, 10, 10, 12, 12 };{1, 1, 2, 1, 3, 4, 5};
        int HASH[] = new int[100000];
        for(int i=0;i<numbers.length;i++)
        {
			System.out.print("Index "+i+" -- "+numbers[i]+" -- " +HASH[numbers[i]] +"\n");
			
            if(HASH[numbers[i]]==0)
            {
                System.out.print(numbers[i]+",");
                HASH[numbers[i]]=1;
            }
        }
    }
	
	public void removeDuplicasy(){
		Integer[] array =  {5,2,7,2,4,7,8,2,3,1,5};//{1, 1, 2, 1, 3, 4, 5};//{ -5, -3, 6, 6, 8, 9, 69, 10, 10, 12, 12 };
		Set<Integer> removedDuplicated = new HashSet<Integer>();
		removedDuplicated.addAll(Arrays.asList(array));
		for (Integer integer : removedDuplicated) {
			System.err.print(" "+integer);
		}
	}
	
	public static void main(String...args){
		int arr[] = {12, 10, 9, 45, 2, 10, 10, 45};
		DistinctElementsFromArra  distinctNumber = new DistinctElementsFromArra();
		//distinctNumber.filter(arr);
		//distinctNumber.main();
		distinctNumber.removeDuplicasy();
	}
}