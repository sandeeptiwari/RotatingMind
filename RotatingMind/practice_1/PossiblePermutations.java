import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class PossiblePermutations{

	public static String[] getPossibleCombinations(String arr[], String input){
		char firstChar = input.charAt(0);
		String remainStr = input.replaceFirst(""+firstChar, "");
		//if(remainStr.length() > 2)
			//return getPossibleCombinations(remainStr);
		int i = 0;
		i = addChar(arr, remainStr, firstChar, i);
		StringBuilder  b = new StringBuilder(remainStr);
		StringBuilder str = b.reverse();
		addChar(arr,str.toString(), firstChar, i);
		
		return arr;
	}	
	
	public static int addChar(String arr[], String base, char move, int i){
		    
		//if(int i = 0; i < base.length(); i++){
			StringBuilder  b1 = new StringBuilder(move);
			arr[i] = (b1.append(base)).toString();
			b1 = new StringBuilder(base.charAt(0));
			i++;
			arr[i] = (b1.append(move).append(base.charAt(1))).toString();
			b1 = new StringBuilder(base);
			i++;
			arr[i] = (b1.append(move)).toString();
			
			return i;
		//}
	
	}

	public static void main(String...args){
		String arra[] = new String[10];
		List<String> alphabets = new ArrayList<>(Arrays.asList(getPossibleCombinations(arra, "ABC"))); // looping over all elements using Iterable.forEach() method 
		alphabets.forEach(s -> System.out.println(s));


	}
}