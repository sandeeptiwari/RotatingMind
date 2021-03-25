/* input : {1, 0, 0, 3, 3, 3, 4, 5, 6, 5, 7, 1, 6, 8, 9, 10}
 * output : 1	:2 times
 *			0	:2
 *			3	:3
 *			4	:1
 *			5	:2
 *			6	:2
 *			7	:1
 *			8	:1
 *			9	:1
 *			10	:1
 */
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Arrays;

public class OccuranceOfElementInArray{
	
	public void printOccurance(int []arr){
		int len = arr.length;
		int []occ = new int[len];
		
		
		for(int i = 0; i < len; i++){
			
			int ele = arr[i];
			int elementOccurence = occ[ele];
			occ[ele] = (elementOccurence + 1);
		}
		
		IntStream.range(0, occ.length).forEach(index -> System.out.println(index +" occurs "+occ[index]+" times"));
		
	}
	
	public static void main(String args[]){
		OccuranceOfElementInArray ocea = new OccuranceOfElementInArray();
		int arr[] = new int[]{1, 0, 0, 3, 3, 3, 4, 5, 6, 5, 7, 1, 6, 8, 9, 10};
		ocea.printOccurance(arr);
		
		
	}
}