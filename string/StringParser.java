/*
 *  A          B          Result
 * ----------------------------
 * "0001"     "1    "    true
 * "1450"     "1450 "    true
 * "0010001 " " 10001  " true
 * "0010000"  "  10 "   false
 * "101023"   "101024"   false
*/

public class StringParser{

 public boolean trailingZeroAndSpace(String input, String String output){
       input = input.replaceFirst("^0*", "").trim();
       return input.equals(output.trim());
 }

 public static void main(String...args){
	StringParser parser = new StringParser();
       //boolean result = parser.trailingZeroAndSpace("0001", "1    ");
       //boolean result = parser.trailingZeroAndSpace("1450", "1450   ");
       //boolean result = parser.trailingZeroAndSpace("0010001 ", "10001    ");
       boolean result = parser.trailingZeroAndSpace("101023", "101024    ");
       System.out.print("Result :: "+result);
 }

}
