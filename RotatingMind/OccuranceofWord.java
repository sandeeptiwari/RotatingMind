/*
 *
*/

public class OccuranceOfWord{
	
	public int findOccurance(String str, String baseString){
		int counter = 0;
		String temp = "";
		int i = 0, j = 0;
		int len = baseString.length();
		int oLen = str.length();
		while(i < len){
			
			char bChar = baseString.charAt(i);
			if(j < oLen){
				char oChar = str.charAt(j);
				if(bChar == oChar){
					i++;
					j++;
				}else if(j != 1){
					i++;
					j = 0;
				}else if(str.charAt(j - 1) != bChar){
					i++;
					j = 0;
				}else{
					i++;
				}
			}else if(j == oLen){
				j=0;
				counter++;
			}
			
			
		}
		return counter;
	}
	
	
	public static void main(String...args){
		
		OccuranceOfWord occurance = new OccuranceOfWord();
		System.out.println(occurance.findOccurance("GCT", "AGCATGCTGCAGTCATGCTTAGGCTA"));
	}
}