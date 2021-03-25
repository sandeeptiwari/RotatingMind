/*
 * Find the min element in Stack in O(1) time, without affecting Push and Pop operation
*/

import java.util.Stack;

public class FindMinStackElement{
	
	public static void main(String...args){
		AdVancedStack minStack = new AdVancedStack();
		minStack.push(2);
		minStack.push(6);
		minStack.push(4);
		minStack.push(1);
		minStack.push(5);
		int min = minStack.getMinimum();
		System.out.print(min);
	}
}

class AdVancedStack{
	
	private Stack<Integer> eleStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int data){
		eleStack.push(data);
		if(minStack.empty() || minStack.peek() >= data){
			minStack.push(data);
		}else{
			minStack.push(minStack.peek());
		}
	}
	
	public int getMinimum(){
		return minStack.peek();
	}
	
}