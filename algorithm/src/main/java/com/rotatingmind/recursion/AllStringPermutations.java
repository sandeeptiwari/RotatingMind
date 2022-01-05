package com.rotatingmind.recursion;

public class AllStringPermutations {

    public static void main(String[] args) {
        printPermutations("ABC", "");
    }


    public static void printPermutations(String ques, String ansf) {
        int len = ques.length();

        if (ques.length() == 0) {
            System.out.print(ansf + " ");
            return;
        }

        for (int i = 0; i < len; i++) {
            char ch = ques.charAt(i);
            String quLeftPart = ques.substring(0, i);
            String quRightPart = ques.substring(i + 1);
            String restOfQuestion = quRightPart + quLeftPart;
            printPermutations(restOfQuestion, ansf + ch);
        }
    }
}
