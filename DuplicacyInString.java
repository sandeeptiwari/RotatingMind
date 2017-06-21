/* Write a program to find out duplicate or repeated characters in a string, and calculate the count of repeatation.*/
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
public class DuplicacyInString{
	
	public void getDuplicacy(String input){
		
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		
		int len = input.length();
		for(int i = 0; i < len; i++){
			char c = input.charAt(i);
			if(charMap.containsKey(c)){
				charMap.put(c, charMap.get(c) + 1);
			}else{
				charMap.put(c, 1);
			}
		}
		
		Set<Character> keys = charMap.keySet();
        for(Character ch:keys){
            if(charMap.get(ch) > 1){
                System.out.println(ch+"--->"+charMap.get(ch));
            }
        }
	}
	
	public static void main(String...args){
		
		DuplicacyInString duplicacyInString = new DuplicacyInString();
		duplicacyInString.getDuplicacy("sandeep kumar tiwari");
	}
}