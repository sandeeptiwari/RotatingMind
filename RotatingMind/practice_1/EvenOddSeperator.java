/* Separate even and odd numbers in Array
 * input : {1, 3, 5, 2, 7, 8, 6, 9, 10, 4, 11, 15, 14}
 * output: {2, 8, 6, 4, 14, 1, 3, 5, 7, 9, 11, 15}
*/
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Arrays;

public class EvenOddSeperator{
	
	public void seperateEvenOdd(int []arr){
		int left = 0;
		int right = arr.length - 1;
		
		while(left < right){
			
			if(arr[left] % 2 != 0){
				left++;
			}else if(arr[right] % 2 == 0){
				right--;
			}else {
				
				swap(arr, left, right);
				left++;
				right--;
			}
		}
	}
	
	public void swap(int arr[], int f, int l){
		int temp = arr[l];
		arr[l] = arr[f];
		arr[f] = temp;
	}
	
	public static void main(String ...args){
		
		EvenOddSeperator eos = new EvenOddSeperator();
		int []arr = new int[]{1, 3, 5, 2, 7, 8, 6, 9, 10, 4, 11, 15, 14};
		eos.seperateEvenOdd(arr);
		
		IntStream intStream = Arrays.stream(arr);
		
		intStream.forEach(x -> System.out.print(" "+x));
	}
}