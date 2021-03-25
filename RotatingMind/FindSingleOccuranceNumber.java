
import java.util.*;
public class FindSingleOccuranceNumber{
	
	public void searchNumber(int []arr){
		int len = arr.length;
		int count = 1;
		Map<Integer, Integer> valMap = new HashMap<>();
		for(int index = 0; index < len; index++){
			int currVal = arr[index];
			if(valMap.containsKey(currVal)){
				valMap.remove(currVal);
			}else{
				valMap.put(currVal, count);
			}
		}
		for (Map.Entry<Integer, Integer> entry : valMap.entrySet()){
			  System.out.print(entry.getKey()+" ");
		}
		//return Integer.parseInt(str.trim());
	}
	public static void main(String...args){
		int arr[] = {0, 1, 0, -3, 10, -3, -20, -20, 10};//{10, -20, 8, -3, 10, -3, -20};//{2, 1, 3, 12, 4 , 2, 4, 3, 12, 8, 8};//{2, 1, 3, 2, 4 , 5, 4, 3, 5};//{2, 1, 3, 12, 4 , 2, 4, 3, 12, 3};
		FindSingleOccuranceNumber searchNumber = new FindSingleOccuranceNumber();
		searchNumber.searchNumber(arr);
		//System.out.println("Unique Number : "+result);
	}
	
	private static int findSingleOcc(int[] arr) {
        int singleOccu = Integer.MIN_VALUE;

        for (int i = 0, j = arr.length - 1; i < j; ) {
            if (arr[i] != arr[j]) {
                singleOccu = arr[i];
                j--;
            } else {
                singleOccu = Integer.MIN_VALUE;
                j = arr.length - 1;
                i++;
            }


        }
        return singleOccu;
    }
}
