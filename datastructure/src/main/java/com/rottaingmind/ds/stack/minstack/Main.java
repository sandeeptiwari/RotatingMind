package com.rottaingmind.ds.stack.minstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

   /* public static void main(String[] args) {
        CustomStack stack = new CustomStack(10);
        stack.push(10);
        stack.push(6);
        stack.push(11);
        stack.push(7);
        stack.push(5);
        stack.push(9);
        stack.push(3);
        stack.push(12);
        stack.push(1);

        System.out.println("Min : " + stack.getMin());
        System.out.println("popped : " +stack.pop());
        System.out.println("Min : " + stack.getMin());
        System.out.println("popped : " + stack.pop());
        System.out.println("popped : " +stack.pop());
        System.out.println("Min : " + stack.getMin());
    }*/

    /**
     * Expected
     * [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,
     * 2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
     * @param args
     */
   public static void main(String[] args) {
       String[] ops = {"MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"};
       int[][] val = { {}, {2147483646}, {2147483646}, {2147483647}, {},{},{},{},{},{},{2147483647},{},{},{-2147483648},{},{},{},{}};
       MinStack minStack = null;

       for (int i = 0; i < ops.length; i++) {
           String operation = ops[i];

           switch (operation) {
               case "MinStack":
                   minStack = new MinStack();
                   System.out.print("null, ");
                   break;
               case "push" :
                   minStack.push(val[i][0]);
                   System.out.print("null, ");
                   break;
               case "pop":
                   minStack.pop();
                   System.out.print("null, ");
                   break;
               case "top":
                   System.out.print(minStack.top() + " ,");
                   break;
               case "getMin":
                   System.out.print(minStack.getMin() + " ,");
                   break;
           }
       }
   }
}

class MinStack {
    private Deque<Long> stack = new ArrayDeque<>();
    private long currentMin;

    public MinStack() {
        currentMin = Integer.MAX_VALUE;
    }

    public void push(int val) {

        if (stack.isEmpty()) {
            stack.push((long)val);
            currentMin = (long)val;
            return;
        }

        if (val <= currentMin) {
            stack.push((2l * val) - currentMin);
            currentMin = (long)val;
        } else {
            stack.push((long)val);
        }

    }

    public void pop() {
        if (!stack.isEmpty()) {

            if (stack.peek() < currentMin) {
                currentMin = 2 * currentMin - stack.peek();
            }

            stack.pop();
        }
    }

    public int top() {
        return (int)(stack.peek() < currentMin ? currentMin : stack.peek());
    }

    public int getMin() {
        return (int)currentMin;
    }
}
