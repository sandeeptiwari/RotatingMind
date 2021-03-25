/*
 * Input an array and prints the second minimum in an array?
 * Example
 *	Input: 34,45,21,12,54,67,15
 *	Output:15
*/
public class SecondMinimum{

	public int getMinimumValue(int[] array){
		int len = array.length;
		int min = Integer.MAX_VALUE, max = 0, secMin = Integer.MAX_VALUE;
		for(int i = 0; i < len; i++){
			max = array[i];
			if(min > max){
				min = max;
				//System.out.println("min : "+min);
			}
			if(min != max && secMin > min && secMin > max){
				secMin = max;
				//System.out.println("sec min : "+secMin);
			}
			
		}
		return secMin;
	}
	
	public int getSecMinValue(int[] elements){
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		for (int i = 0; i < elements.length; i++) {
			if(elements[i]==smallest){
			  secondSmallest=smallest;
			} else if (elements[i] < smallest) {
				secondSmallest = smallest;
				smallest = elements[i];
			} else if (elements[i] < secondSmallest) {
				secondSmallest = elements[i];
			}
		}
		return secondSmallest;
	}
	
	public static void main(String...args){
		
		int []arr = new int[]{34,45,21,12,54,67,15};//{-5, -4, 0, 2, 10, 3, -3};//{0, -1, 4, 7, 9, 10},{34,45,21,12,54,67,15};
		SecondMinimum secondMinimum = new SecondMinimum();
		//System.out.print(secondMinimum.getMinimumValue(arr));
		System.out.print(secondMinimum.getSecMinValue(arr));
	}
}