public class BinarySearch{

 public int findByItr(int arr[], int low, int high, int value){
	 return 0;
 }
 
 
 public static int findByRec(int arr[], int low, int high, int value){
 
    int mid = ( high + low ) / 2;
	
	while(low < high){
		mid = ( high + low ) / 2;
		
		if(arr[mid] == value)
			return mid;
		else if(value > arr[mid]){
			low = mid + 1;
		}
		else if(value < arr[mid]){
			
			high = mid -1;
		}
	
	}
	
  return - 1;
 
 }


 public static void main(String args[]){
	 int a[] = new int[]{3, 5, 7, 8, 9, 10, 15, 18, 22};
	 System.out.print(findByRec(a, 0, a.length, 9));
 }
}