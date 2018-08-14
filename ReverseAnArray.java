/**
 * Reverse an array 
 * Input : [30, 40 , 50 , 60 , 70]
 * Output : [70, 60, 50, 40, 30]
*/

public class ReverseAnArray{
  
  public int[] reverseTheArray(int[] arr) {
		 int temp = 0;
		
		for (int i = 0, j = arr.length - 1; i < j; i++,j--) {
			
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			
		}
		
		return arr;
	}
  
}
