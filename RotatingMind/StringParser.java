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

 public boolean trailingZeroAndSpace(String a, String String b){
 
 }

 public static void main(String...args){
	StringParser parser = new StringParser();
	System.out.println(parser.trailingZeroAndSpace("0010000", "  10 "));
 }

}