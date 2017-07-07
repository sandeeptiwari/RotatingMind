import java.util.*;
public class CalculateAllPossibleStringCombinations{
	
	public static void main(String[] args){
		CalculateAllPossibleStringCombinations clapc 
							= new CalculateAllPossibleStringCombinations();
		clapc.purmutations("abc");
		/* Set<String> combinations =  Iterator itr = combinations.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}*/
	}
	

	public void purmutations(String word){
		/*int i = 0;
		Set<String> combinations = new HashSet<String>();
		int len = word.length();
		
		while(i < len){
			char character = word.charAt(i);
			String rem = word.substring(i+1, word.length());
			
			String tempStr = word.replace(""+character, "");
			for(int index = 0; index < word.length() + 1; index++){
				
				String set1 = word.substring(0, index)+character+word.substring(index, word.length());
				System.out.println(" == "+set1);
				combinations.add(set1);
			}
			i = i+1;
		}
	  return combinations;*/
	  permutation("", word);
	}
	
	public  static void permutation(String prefix, String str) {
    int n = str.length();
    if (n == 0) System.out.println(prefix);
    else {
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
    }
}
}