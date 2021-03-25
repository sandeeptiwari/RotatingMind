/* 
 The selection sort improves on the bubble sort by making only one exchange for every pass through the list. In order to do this, a selection sort looks for the largest value as it makes 
 a pass and, after completing the pass, places it in the proper location. As with a bubble sort, after the first pass, the largest item is in the correct place. After the second pass, 
 the next largest is in place. This process continues and requires n−1n−1 passes to sort n items, since the final item must be in place after the (n−1)(n−1) st pass.
 Example :- {26, 54, 93, 17, 77, 31, 44, 55, 20}
 
 1- {17, 54, 93, 26, 77, 31, 44, 55, 20} minimum element is 17 so 17 replace by 26, 0 index
 2- {17, 20, 93, 26, 77, 31, 44, 55, 54} No 2nd minimum ele in array is 20 so 20 replace by 54
 3- {17, 20, 26, 93, 77, 31, 44, 55, 54}
 4- {17, 20, 26, 31, 77, 93, 44, 55, 54}
 5- {17, 20, 26, 31, 44, 93, 77, 55, 54}
 6- {17, 20, 26, 31, 44, 54, 77, 55, 93}
 7- {17, 20, 26, 31, 44, 54, 55, 77, 93}
*/

public class SelectionSort{
	
	public void toSort(int arr[]){
		int len = arr.length;
		
		int minVal = 0;
		for(int index = 0; index < len; index++){
			int i = index;
			for(int j = index + 1; j < len; j++){
				
				if(arr[j] < arr[i]){
					i = j;
				}
					minVal = arr[i];
					arr[i] = arr[index];
					arr[index] = minVal;
				
			}
		}
		
		for(int index = 0; index < len; index++){
			System.out.print(arr[index]+" ,");
		}
	}
	
	public static void main(String...args){
		int arr[] = {26, 54, 93, 17, 77, 31, 44, 55, 20};
		SelectionSort  selectionSort = new SelectionSort();
		selectionSort.toSort(arr);
	}
}