/*
  9 >> 2 = 0000 1001 >> 2 =   0000100
  0010 001000
*/

public class CheckBinaryNumberIsPolindrom{

  public boolean getBinaryNumberIsPolindrom(int decimal){
	  String binaryNumber = "";
	  int rem = 0;
	  while(decimal > 0){
		  rem = decimal % 2;
		  decimal = decimal / 2;
		  binaryNumber = rem + binaryNumber;
	  }
	  return isPalindrome(binaryNumber);
  }  
  
  public boolean isPalindrome(String s){
        int end = s.length()-1;
        for(int i=0; i<s.length()/2; i++){
            /*if(s.charAt(i)!=s.charAt(end)){
                return false;
            }
            end--;*/
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
			return false;
          }
        }
        return true;
    }
	
	public void printBinaryform(int number) {
        int remainder;

        if (number <= 1) {
            System.out.print(number);
            return;   // KICK OUT OF THE RECURSION
        }

        remainder = number %2; 
        printBinaryform(number >> 1);
        System.out.print(remainder);
    }


  public static void main(String...args){
	  CheckBinaryNumberIsPolindrom checkNumber = new CheckBinaryNumberIsPolindrom();
	  checkNumber.printBinaryform(9);
	  //System.out.println(result);
	  //System.out.println(checkNumber.getBinaryNumberIsPolindrom(16) ? "Polindrom" : "Not a ploindrom");
  }
}