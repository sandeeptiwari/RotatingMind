/*  {1,2,-3,2,3,4,-6,1,2,3,4,5,-8,5,6}  */

public class LongestRunningPositiveOccurance{
	
	public int maxOccurancePositiveNumber(int arr[]){
		 int result[] = new int[2];
		 int len  = arr.length;
		 int max = 0, min = 0;
		 for(int index = 0; index < len; index++){
			 
			 int curr = arr[index];
			
			 if(curr > 0){
				 min++;
				 
			 }else if(curr < 0){
				 if(max < min){
					 max = min;
					 result[1] = (index - max);
				 }
				 result[0] = max;
				 min = 0;
			 }
			 
			 
		 }
			if(max < min){
					 max = min;
					 result[1] = (len - max);
				 }
			
				result[0] = max;
		 return max;
	}
	
	public static void main(String...args){
		int[] a = {1,-1,2,-1,-1,2,3,3};
		int arr[] = new int[]{1,2,-3,2,3,4,-6,1,2,3,4,5,-8,5,6};
		LongestRunningPositiveOccurance longestOcc = new LongestRunningPositiveOccurance();
		int result[] = longestOcc.maxOccurancePositiveNumber(a);
		System.out.println("Start Index : "+result[1]+", Max +ve Number occ : "+result[0]);
	}
}