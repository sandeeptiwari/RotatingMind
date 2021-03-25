public class PossibleCombination{
		
		 public List<String> getCombination(String str){
			 List<String> list = new ArrayList<String>();
			 if(str.length() == 0)
				 return null;
			 else if(str.length() == 2){
				 lis.add(str);
				 str = str.charAt(1)+strcharAt(0);
				 str.add(str);
			 }
			 else{
				 List<String> combs = getCombination(str);
				 for(int i = 0; < combs.size(); i++){
					 String currStr = combs.get(i);
					 int len = currStr.length();
					 for(int j = 0; j < len; j++){
						 String newStr = currStr.subString(0, j)+
					 }
				 }
			 }
		 }
		
		public static void main(String...args){
			
		}
}