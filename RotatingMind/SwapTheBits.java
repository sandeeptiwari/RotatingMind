/*
 *Q1. swap the even bits and odd bits in the number.
 *I/P: 01010101 O/P:10101010
*/

public class SwapTheBits{
	
	public int[] swapTheNo(int arr[]){
		
		int len = arr.length;
		for(int i = 0, j = 1; (i < j && j < len) ; i += 2, j +=2){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			//System.out.println(j);
		}
		return arr;
	}
	
	public static void main(String...args){
		SwapTheBits swap = new SwapTheBits();
		int arr[] = new int[]{0,1,0,1,0,1,0,1,0};
		arr = swap.swapTheNo(arr);
		int len = arr.length;
		for(int i = 0; i < len; i++){
			System.out.print(arr[i]);
		}
	}
}