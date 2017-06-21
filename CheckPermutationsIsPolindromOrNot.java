 /*
	* Write an efficient function that checks whether any permutation of an input string is a palindrome
	* Examples:
	*
	*	"civic" should return true
	*	"ivicc" should return true
	*	"civil" should return false
	*	"livci" should return false
	*
	* "But 'ivicc' isn't a palindrome!"
	*	If you had this thought, read the question again carefully. We're asking if any permutation of the string is a palindrome. 
	*	Spend some extra time ensuring you fully understand the question before starting. Jumping in with a flawed understanding of 
	*	the problem doesn't look good in an interview.
	*
	*What would be the time cost? For a string of length n, there are n! permutations (n choices for the first character, times n−1 choices for the second character, etc). 
	*Checking each length-n permutation to see if it's *a palindrome involves checking each character, taking O(n)O(n) time. That gives us O(n!n)O(n!n) time overall. We can do better!
	*http://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html
 */
public class CheckPermutationsIsPolindromOrNot{
	
	public static void main(String args[]) { 
		permutation("123"); 
	}
	/* * A method exposed to client to calculate permutation of String in Java. */ 
	public static void permutation(String input){ permutation("", input); } 
	/* * Recursive method which actually prints all permutations 
	* of given String, but since we are passing an empty String 
	* as current permutation to start with, 
	* I have made this method private and didn't exposed it to client. 
	*/ private static void permutation(String perm, String word) {
		if (word.isEmpty()) { 
		System.err.println(perm + word);
		} else { 
		 for (int i = 0; i < word.length(); i++) { 
			System.out.println("len "+word.length());
			String res = word.substring(i + 1, word.length());
			System.out.println("i "+i + " res "+res);
			System.out.println("word.substring(0, i) "+word.substring(0, i));
			permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length())); 
		  } 
		 } 
		}
	
}