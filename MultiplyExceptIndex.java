/* 
You have a list of integers, and for each index you want to find the product of every integer except the integer at that index.
Write a function get_products_of_all_ints_except_at_index() that takes a list of integers and returns a list of the products.

For example, given:

  [1, 7, 3, 4]

your function would return:

  [84, 12, 28, 21]

by calculating:

  [7*3*4, 1*3*4, 1*7*4, 1*7*3]

Do not use division in your solution.

ref:-https://www.interviewcake.com/question/python/product-of-other-numbers
*/

public class MultiplyExceptIndex{
	
	public void getMultiplication(int arr[]){
		int i = 0, product = 1;
		int len = arr.length;
		i = len - 1;
		int resultAfter[]  = new int[len];
		int resultBefore[] = new int[len];
		
		while(i >= 0){
		   resultAfter[i] = product;
		   product = arr[i] * product;
           i -= 1;		
		}
		i = 0;
		product = 1;
		while(i < len){
			resultBefore[i] = product;
			product = product*arr[i];
			i++;
			
		}
		
		for(int j = 0; j < len; j++){
			int res = resultAfter[j]
			System.out.print(" "+res);
		}
		
		
	}
	
	public static void main(String...args){
			MultiplyExceptIndex multiplication = new MultiplyExceptIndex();
			int arr[] = new int[]{2, 4, 10};
			multiplication.getMultiplication(arr);
	}
}