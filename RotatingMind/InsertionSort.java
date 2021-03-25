//{19, 12, 5, 7}
// 12, 19, 5, 2
//12, 5, 19, 2

public class InsertionSort{
	
	public void toSort(int arr[]){
		
		int len = arr.length;
		int key = 0;
		
		for(int i = 1; i < len; i++){
			 key = arr[i];
			for(int j = i - 1 ; j >= 0; j--){
				
				if(key < arr[j]){
					arr[j + 1] = arr[j];
					arr[j] = key;
				}
				
			}
		}
		
		for(int i = 0; i < len; i++){
			
			System.out.print(arr[i]+" ");
		}
		
	}
	
	public static void main(String...args){
		int arr[] = {31, 41, 59,26, 41, 58};//{12, 3, 1, 5, 8};//{19, 12, 5, 7};
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.toSort(arr);
	}
}