//Bubble Sort example {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 38}

public class BubbleSort{
	
	public void toSort(int input[]){
		
		int len = input.length;
		int temp = 0;
		for(int index = 0; index < len; index++){
			
			for(int jIndex = index + 1; jIndex < len; jIndex++){
				
				if(input[index] > input[jIndex]){
					temp = input[jIndex];
					input[jIndex] = input[index];
					input[index] = temp;
				}
			}
		}
		
		for(int index = 0; index < len; index++){
			int startEle = input[index];
			System.out.print(startEle+", ");
		}
	}
	
	public static void main(String...args){
		//{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 38};
		//{2, 4, 6, 9, 12, 23, 0, 1, 34};
		//{5, 90, 35, 45, 150, 3};
		int arr[] = new int[]{2, 4, 6, 9, 12, 23, 0, 1, 34};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.toSort(arr);
	}
}