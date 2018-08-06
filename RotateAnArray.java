// rotate an arrat by k position
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Arrays;

public class RotateAnArray{
	
	public void roateByK(int []a, int start, int end){
	   int len = a.length;
	   for(int i = start, j = end; i < j ; i++, j--){
		   int temp = a[i];
		   
		   a[i] = a[j];
		   a[j] = temp;
		   
	   }
	}
	
	public static void main(String...args){
		int arr[] = new int[]{1,2,3,4,5,6,7,8,9,10};
		
		RotateAnArray obj = new RotateAnArray();
		
		obj.roateByK(arr, 0, 3);//1st roate first half k = 4
		obj.roateByK(arr, 4, arr.length -1);//2nd roate second half k = 4
		obj.roateByK(arr, 0, arr.length - 1);//3rd roate whole array k = 4
		
		//Stream.of(arr).forEach(System.out::println);
		//Arrays.asList(arr).stream().forEach(i -> System.out.println(i));
		//System.out.println(Arrays.asList(arr));
		
		//for(int i =0; i < arr.length; i++){
			//System.out.println(arr[i]);
		//}
		
		
		//1.
		//IntStream intStream1 = Arrays.stream(arr);
        //intStream1.forEach(x -> System.out.println(x));
		
		//2.
		Stream<int[]> temp = Stream.of(arr);
		//temp.forEach(System.out::print);
		// Cant print Stream<int[]> directly, convert / flat it to IntStream 
		
		IntStream intStream2 = temp.flatMapToInt(x -> Arrays.stream(x));
		intStream2.forEach(x -> System.out.print(x));
	}
}