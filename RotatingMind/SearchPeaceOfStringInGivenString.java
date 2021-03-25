/*
 * Let's say we have an array of string. Write a function that takes a string as in argument and returns true if the input string can be subdivided  into the string contained in the array.
 *	Example: 
 *	strings = [‘end’, ‘and’, ‘the’, ‘back’, ‘front’, ‘ory’, ‘po’, ‘lar’]
 *
 *	---------------
 *	string
 *  frontend -> true
 *	backend ->true
 *	endfrontend -> true
 *	fronted -> false
 *	----------------
 *
 *
*/
import java.util.Scanner;

public class SearchPeaceOfStringInGivenString{
	
	public boolean isStringExist(String input){
		 String arr[] = new String[]{"end", "and", "the", "back", "front", "ory", "po", "lar"};
		 int len = arr.length;
		 for(int index = 0; index < len; index++){
			  String currStr = arr[index];
			  if(input.contains(currStr)){
				  
				  input = input.replace(currStr, "");
				  
			  }else if(input == null || input.length() == 0){
				  return true;
			  }
		 }
		 return false;
	}
	
	public static void main(String...args){
		
		Scanner sc = new Scanner(System.in);
		SearchPeaceOfStringInGivenString searchString  = new SearchPeaceOfStringInGivenString();
		int testCase = sc.nextInt();
		while(testCase > 1){
			 String input = sc.next();
			 boolean result = searchString.isStringExist(input);
			 System.out.print(input+" -> "+result);
			 testCase--;
		}
	}
}