/*
 *{()[()]}
*/
import java.util.Stack;

public class BalanceParenthesis{
	
 public boolean isParanthesisBalance(String pStr){
   char [] cArr = pStr.toCharArray();
   int len = cArr.length;
   Stack<Character> stack = new Stack<Character>();
   for(int index = 0; index < len; index++){
	    char ch = cArr[index];
	   if( (ch == '{') || (ch == '(') || (ch == '[') ){
		   stack.push(ch);
	   }else{
		   switch(ch){
		   case '}':
		     if(stack.peek() == '{')
				stack.pop();
		    break;
			
		   case ']':
		   if(stack.peek() == '[')
				stack.pop();
		    break;
			
		   case ')':
			if(stack.peek() == '(')
				stack.pop();
		    break;
	    }
	   }
   }
   return stack.empty();
 }

 public static void main(String...args){
	BalanceParenthesis bps = new BalanceParenthesis();
	System.out.print(bps.isParanthesisBalance("{)[)]}"));
 }
}