package com.rottaingmind.ds.stack.applications.verifybraces;

import com.rottaingmind.ds.stack.Stack;

public class VerificationOfBraces {

    public boolean isValid(String expression) {
        if (expression.length() == 1) {
            return false;
        }
        Stack<String> bracesStack = new Stack<>();
        char braces[] = expression.toCharArray();
        for (int i = 0; i < braces.length; i++) {
            char brace = braces[i];
            if (brace == '(' || brace == '{' || brace == '[') {
                bracesStack.push(String.valueOf(brace));
            } else if (brace == ')' ) {
                String openBrace = bracesStack.size() > 0 ? bracesStack.pop() : null;
                if (!String.valueOf('(').equals(openBrace)) {
                     return false;
                }
            } else if (brace == '}' && bracesStack.size() > 0) {
                String openBrace = bracesStack.pop();
                if (!String.valueOf('{').equals(openBrace)) {
                    return false;
                }
            } else if (brace == ']' && bracesStack.size() > 0) {
                String openBrace = bracesStack.pop();
                if (!String.valueOf('[').equals(openBrace)) {
                    return false;
                }
            }
        }

        return bracesStack.size() == 0;
    }

    public static void main(String[] args) {
        VerificationOfBraces verification = new VerificationOfBraces();
        System.out.println(verification.isValid(")(){}"));
    }
}
