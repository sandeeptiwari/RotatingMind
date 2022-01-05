package com.rottaingmind.ds.stack.dijkstra;

import com.rottaingmind.ds.stack.Stack;

public class Algorithm {

    private Stack<String> operationStack;
    private Stack<Double>  valueStack;

    public Algorithm() {
        this.operationStack = new Stack<>();
        this.valueStack = new Stack<>();
    }

    public void interpretExpression(String expression) {
        expression = expression.replaceAll("\\s+","");
        char expressionArray[] = expression.toCharArray();

        for (char c: expressionArray) {
            if(c == '(') {
                continue;
            } else if(c == '+') {
                operationStack.push(String.valueOf(c));
            }else if(c == '*') {
                operationStack.push(String.valueOf(c));
            }else if(c == ')') {
                String operation = operationStack.pop();
                if (operation.equals("+")) {
                    valueStack.push(valueStack.pop() + valueStack.pop());
                } else if (operation.equals("*")) {
                    valueStack.push(valueStack.pop() * valueStack.pop());
                }
            } else {
                valueStack.push(Double.valueOf(String.valueOf(c)));
            }
        }
    }

    public void result() {
        System.out.println(valueStack.pop());
    }
}
