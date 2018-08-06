/*
 * Input:   str = "a,b$c"
 * Output:  str = "c,b$a"
 * Note that $ and , are not moved anywhere.  
 * Only subsequence "abc" is reversed

 * Input:   str = "Ab,c,de!$"
 * Output:  str = "ed,c,bA!$"

 * Input: Ab,c,de!$$$

 * Output: ed,c,bA!$$$

 * Input: !!!!abcd?#

 * Output: !!!!dcba?#

 * Input: ab%%xyz

 * Output: zy%%xba

 * Input : ZYXcba

 * Output: abcXYZ

 * Input: ##@@!!&

 * Output: No reversal possible 
*/

import java.util.Scanner;

public class RotateStringWithoutAffectingSpecialCharacter{
	
	
	public static void main(String args[] ){
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();		
		char arr[] = str.toCharArray();
		int len = arr.length;
		int startPoint = 0, endPos = 0;
		/*for(int i = 0; i < len; i++){
			char c = arr[i];
			if(!isAlphabet(c)){
				reverse(arr, startPoint, endPos);
				startPoint = i+1;
			}else{
				endPos = i;
			}
		}
		reverse(arr, startPoint, endPos);
		*/
		reverse2(arr, startPoint, len - 1);
		
    	String result = "";
    	for(int i =0; i< len; i++){
    	 System.out.print(result+arr[i]);
    	}
		
	} 
	
	public  static boolean isAlphabet(char x)
    {
        return ( (x >= 'A' &&  x <= 'Z') ||
                 (x >= 'a' &&  x <= 'z') ) || x == ',';
    }
	
	
	public static void reverse1(char[] arr, int start, int end){
		
		int len = arr.length;
		if(len == 1)
			return;
		
		for(int i = start, j = end; i < j; i++, j--){
			
			char t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			
		}
		
	}
	
	//Ab,c,de!$$$
	// i= 0, j = 10
	//i= 0, j = 9
	//i= 0, j = 8
	//i= 0, j = 7
	//i= 1, j = 7
	// i = 2, j =6
	public static void reverse2(char[] arr, int start, int end){
		
		int len = arr.length;
		if(len == 1)
			return;
		
		for(int i = start, j = end; i < j;){
			
			if(!isAlphabet(arr[i])){
				i++;
			}else if(!isAlphabet(arr[j])){
				j--;
			}else{
				char t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				j--;
				i++;
			}
			
			
		}
		
	}
}