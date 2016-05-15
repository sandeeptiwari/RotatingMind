
public class AllPossibleCombition{
	
	public int[] getAllpossibleCombination(String input){
		
		int possibleComb = fact(input);
		int comb[] = new int[possibleComb];
		for(int index = 0; index < possibleComb; index++){
			
			
		}
		
	}
	
	public int fact(int fact){
		
		if(fact == 0 || fact == 1)
			return 1;
		
		return fact * (fact - 1);
		
	}
	
	public static void main(String...args){
		
		
		
		AllPossibleCombition allPossibleCombination = new AllPossibleCombition();
	}
}