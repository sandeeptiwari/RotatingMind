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
	
	public static void byUsingSet(String input) {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (int index = 0; index < input.length(); index++) {
            char ch = input.charAt(index);
            increment(characterMap, ch);
        }
        characterMap.entrySet().stream().filter(getPredicate()).forEach(v -> {
            System.out.print(v.getKey() + " occurs " + v.getValue() + ", ");
        });

    }

    private static Predicate<Map.Entry<Character, Integer>> getPredicate() {
        Predicate<Map.Entry<Character, Integer>> p1 = ele -> ele.getValue() > 1;
        Predicate<Map.Entry<Character, Integer>> p2 = ele -> ele.getKey() != ' ';

        return p1.and(p2);
    }

    public static <K> void increment(Map<K, Integer> map, K key) {
        map.merge(key, 1, Integer::sum);
    }
}
