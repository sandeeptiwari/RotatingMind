/* 
 The selection sort improves on the bubble sort by making only one exchange for every pass through the list. In order to do this, a selection sort looks for the largest value as it makes 
 a pass and, after completing the pass, places it in the proper location. As with a bubble sort, after the first pass, the largest item is in the correct place. After the second pass, 
 the next largest is in place. This process continues and requires n−1n−1 passes to sort n items, since the final item must be in place after the (n−1)(n−1) st pass.
 Example :- {26, 54, 93, 17, 77, 31, 44, 55, 20}
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