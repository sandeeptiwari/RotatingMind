//-2, -3, 4, -1, -2, 1, 5, -3

public class MaxSumOfContiguosArray{
	
	public int maxSubArraySum(int arr[]){
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;
		int len = arr.length;
		
		for(int i = 0; i < len; i++){
			maxEndingHere = maxEndingHere + arr[i];
			
			if(maxEndingHere < 0){
				maxEndingHere = 0;
			}else if(maxSoFar < maxEndingHere){
				
				maxSoFar = maxEndingHere;
			}
			
		}
		
		return maxSoFar;
	}
	
	public static void main(String args[]){
		int arr[] = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
		MaxSumOfContiguosArray max = new MaxSumOfContiguosArray();
		System.out.print(max.maxSubArraySum(arr));
		
	}
	
	
}