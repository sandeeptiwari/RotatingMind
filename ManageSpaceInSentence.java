/*
Strings:You have given a sentence.You have to check the length of each word.If length of word is greater then 4 and is even then put the space in the middle of the word else print the word as it is.
for ex INPUT: Nagarro is my Favourite Company because of career growth.
Output : Nagarro is my Favourite Company because of car eer gro wth
*/

public class ManageSpaceInSentence{
	
	public void showSentence(String input){
		int len = input.length();
		//System.out.println("len "+len);
		StringBuilder builder = new StringBuilder();
		String str = "";
		for(int i = 0; i < len; i++){
			char currChar = input.charAt(i);
			//System.out.print("char "+currChar);
			str = str+currChar;
			
			if(currChar == ' '){
				
				processString(str, builder);
				str = "";
			}
			
		}
		processString(str, builder);
		str = "";
		
		System.out.print(builder.toString());
	}
	
	public void processString(String str, StringBuilder builder){
		int strLen = str.trim().length();
				
		if(strLen >= 4 && strLen % 2 == 0){
			builder.append(putSpace(str));
		 }else if(strLen > 0){
			builder.append(str);
		}
	}
	
	public String putSpace(String input){
		
		StringBuilder result = new StringBuilder();
		int len = input.length();
		
		for (int i = 0; i < len; i++) {
			
		   if (i == len/2) {
			  result.append(" ");
			}

		   result.append(input.charAt(i));
		}
		return result.toString()+" ";
  }
	
	public static void main(String...args){
		
		ManageSpaceInSentence spaceInSentence = new ManageSpaceInSentence();
		spaceInSentence.showSentence("Nagarro is my Favourite Company because of career growth");
	}
}