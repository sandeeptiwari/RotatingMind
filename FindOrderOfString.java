/*
 *Given a text string and a sample string. Find if the characters of the sample string is in the same order in the text string.. Give a simple algo..
 *Eg.. TextString: abcNjhgAhGjhfhAljhRkhgRbhjbevfhO
 *Sample string :NAGARRO
 *
*/

public class FindOrderOfString{

    public boolean isExistInputString(String txtString, String sampleString){
	   boolean isExist = false;
	   String currString = txtString;
	   String resultString = "";
	   int len = sampleString.length();
	   int indexArr[] = new int[len];
	   for(int index = 0; index < len; index++){
		   
		   char charAtCurrIndex = sampleString.charAt(index);
		   System.out.print(currString+"\n");
		   int charIndexInTxtString = currString.indexOf(charAtCurrIndex);
		   if(charIndexInTxtString == -1){
				return false;
		   }else {
			   resultString += charAtCurrIndex;
			   currString = currString.substring(charIndexInTxtString + 1, currString.length());
		   }
	   }
	   
	   if(sampleString.equalsIgnoreCase(resultString)){
		   isExist = true;
	   }else{
		   isExist = false;
	   }
	   
	  return isExist;
	}
	
	
	public  void findSubSequence(String s1 ,String s2) {
		
		int i = 0;
		int j = 0;
		
	    char stringArray1[] = s1.toCharArray();
	    char stringArray2[] = s2.toCharArray();
		
		
		while (i < s1.length() && j < s2.length() ) {
		
			
			if(stringArray1[i] == stringArray2[j]) {
				
				i++;
				j++;
			}else {
				
				j++;
			}
			
		}
		
		if(i == s1.length()) {
			
			System.out.println("SubSequence Found");
		}else {
			
			System.out.println("SubSequence Not Found");
		}
	}
	
	public static void main(String...args){
		FindOrderOfString orderString = new FindOrderOfString();
		//boolean isExist = orderString.isExistInputString("abcSjhgAhGjhfjklNndgrtDljhuuuiiEkhgEbhjbevfhP", "SANDEEP");
		//String result = isExist == true ? " All right, Sample String is Exist" : 
          //      "Sample is not exist in same order in txt string";
				
		//System.out.println(result);
		
		orderString.findSubSequence("SANDEEP", "abcSjhgAhGjhfjklNndgrtDljhuuuiiEkhgEbhjbevfhP");
	}
}