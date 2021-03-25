/*
 * Input  : Muhammed
 *
 * output : 
 *	     m=3
 *       u=1
 *       h=1
 *       a=1
 *       d=1
 *
*/
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Arrays;

public class FrequencyOfCharInArray{
	
	public void printOccuranceOfChar(char[] arr){
		int len = arr.length;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i =0; i < len; i++){
			if(map.containsKey(arr[i])){
				int occurance = map.get(arr[i]);
				map.put(arr[i], (occurance+1));
			}else{
				map.put(arr[i], 1);
			}
		}
		
		map.forEach((k, v) -> System.out.println("Item : "+k+" Count : "+v));
	}
	
	
	public static void main(String...args){
		FrequencyOfCharInArray focia = new FrequencyOfCharInArray();
		String input = "Muhammed".toLowerCase();
		focia.printOccuranceOfChar(input.toCharArray());
	}
}