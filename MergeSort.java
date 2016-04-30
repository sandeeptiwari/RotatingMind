
//{19, 12, 5, 7}
// 12, 19, 5, 2
//12, 5, 19, 2

public class MergeSort{
	
	public int[] toSort(int arr[]){
		
		int len = arr.length;
		if(len <= 1)
			return arr;
		
		int mid = len/2;
		int left[] = new int[mid];
		int right[] = new int[len - mid];
		
		for(int i = 0; i < mid; i++)
			left[i] = arr[i];
		
		for(int j = mid; j < len; j++)
			right[j - mid] = arr[j];
		
		
		toSort(left);
		toSort(right);
		merge(left, right, arr);
		return arr;
	}
	
	public void merge(int left[], int right[], int arr[]){
		int nL = left.length;
		int nR = right.length;
		int i = 0, j = 0, k = 0;
		while(i < nL && j < nR){
			if(left[i] <= right[j]){
				arr[k] = left[i];
				i = i + 1;
				k = k + 1;
			}else if(left[i] >= right[j]){
				arr[k] = right[j];
				j = j + 1;
				k = k + 1;
			}
		}
		while(i < nL){
			arr[k] = left[i];
				i = i + 1;
				k = k + 1;
		}
		while(j < nR){
			arr[k] = right[j];
				j = j + 1;
				k = k + 1;
		}
	}
	
	public static void main(String...args){
		int arr[] = {12, 3, 1, 5, 8};//{31, 41, 59,26, 41, 58};//{19, 12, 5, 7};
		MergeSort mergeSort = new MergeSort();
		mergeSort.toSort(arr);
		
		for(int i = 0; i < arr.length; i++){
			
			System.out.print(arr[i]+" ");
		}
	}
}