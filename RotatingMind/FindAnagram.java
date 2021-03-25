//Example : "TWELVE PLUS ONE" anagrams to "ELEVEN PLUS TWO"
import java.util.*;
public class FindAnagram{
	
	public boolean isAnagram(String str1, String str2){
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char word1[] = str1.toCharArray();
		char word2[] = str2.toCharArray();
		
		for(char c : word1){
			int count = 1;
			if(map.containsKey(c)){
				count = map.get(c) + 1;
			}
			map.put(c, count);
		}
		
		for(char c : word2){
			int count = -1;
			if(map.containsKey(c)){
				count = map.get(c) - 1;
			}
			map.put(c, count);
		}
		
		for (char c : map.keySet()) {
			if (map.get(c) != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String...args){
		FindAnagram findAnagram = new FindAnagram();
		//boolean isAnagram = findAnagram.isAnagram("TWELVE PLUS ONE", "ELEVEN PLUS TWO");
		boolean isAnagram = findAnagram.isAnagram("anagramm", "nagaramm");
		System.out.println("Strings is anagram : "+isAnagram);
	}
	
}