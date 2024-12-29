package com.rottaingmind.ds.stack.applications;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * Given a string s, determine if it is valid.
 *
 * A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:
 *
 * Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
 * Return true if s is a valid string, otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aabcbc"
 * Output: true
 * Explanation:
 * "" -> "abc" -> "aabcbc"
 * Thus, "aabcbc" is valid.
 * Example 2:
 *
 * Input: s = "abcabcababcc"
 * Output: true
 * Explanation:
 * "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
 * Thus, "abcabcababcc" is valid.
 * Example 3:
 *
 * Input: s = "abccba"
 * Output: false
 * Explanation: It is impossible to get "abccba" using the operation.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 104
 * s consists of letters 'a', 'b', and 'c'
 */
public class CheckIfWordIsValidAfterSubstitutions {


    public static void main(String[] args) {
        //System.out.println(removeIdenticalPair("abacabaabacabaa"));
        //System.out.println(removeIdenticalPair("reallazy"));
        //System.out.println(removeIdenticalPair("hhoowaaaareyyoouu"));
        //System.out.println(isValid("aabcbc"));
        //System.out.println(isValid("aaababccbcbc"));
        System.out.println(isValid("abccba"));
    }

    public static boolean isValid(String s) {

        int i = s.indexOf("abc");
        StringBuilder builder = new StringBuilder();
        while (i >= 0) {
            builder.append(s.substring(0, i));
            if (s.length() > i + 3) {
                builder.append(s.substring(i + 3));
            }
            s = builder.toString();
            i = s.indexOf("abc");
            builder.setLength(0);
        }


        if (builder.isEmpty()) return true; else return false;
    }

    public boolean isValid1(String str) {

        StringBuilder s = new StringBuilder(str);

        while(s.length()!=0){
            int a = s.indexOf("abc");
            if(a==-1) return false;
            else{
                s.delete(a,a+3);
            }
        }

        if(s.length()==0) return true;
        else return false;
    }

    public boolean isValid2(String s) {
        Deque<Character> st = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'c') {
                if (st.isEmpty()) {
                    return false;
                }
                if (st.peek() != 'b') {
                    return false;
                }

                st.pop();

                if (st.isEmpty()) {
                    return false;
                }
                if (st.peek() != 'a') {
                    return false;
                }

                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        return st.isEmpty();
    }
}
