package com.rottaingmind.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * You are given a string s and a robot that currently holds an empty string t. Apply one of the following operations until s and t are both empty:
 *
 * Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
 * Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
 * Return the lexicographically smallest string that can be written on the paper.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "zza"
 * Output: "azz"
 * Explanation: Let p denote the written string.
 * Initially p="", s="zza", t="".
 * Perform first operation three times p="", s="", t="zza".
 * Perform second operation three times p="azz", s="", t="".
 * Example 2:
 *
 * Input: s = "bac"
 * Output: "abc"
 * Explanation: Let p denote the written string.
 * Perform first operation twice p="", s="c", t="ba".
 * Perform second operation twice p="ab", s="c", t="".
 * Perform first operation p="ab", s="", t="c".
 * Perform second operation p="abc", s="", t="".
 * Example 3:
 *
 * Input: s = "bdda"
 * Output: "addb"
 * Explanation: Let p denote the written string.
 * Initially p="", s="bdda", t="".
 * Perform first operation four times p="", s="", t="bdda".
 * Perform second operation four times p="addb", s="", t="".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only English lowercase letters.
 */
public class UsingARobotToPrintTheLexicographicallySmallestString2434 {

    public String robotWithString(String s) {
        int n = s.length();
        char[] smallestInRightAt = new char[n];
        smallestInRightAt[n - 1] = s.charAt(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            smallestInRightAt[i] = (char)Math.min(smallestInRightAt[i + 1], s.charAt(i));
        }

        Deque<Character> op1 = new ArrayDeque<>();

        //op1.push(s.charAt(0));
        int i = 0;
        StringBuilder paper = new StringBuilder();
        while (i < n) {

            op1.push(s.charAt(i));

            char minChar = (i + 1) < n ? smallestInRightAt[i + 1] : s.charAt(i);

            while (!op1.isEmpty() && minChar >= op1.peek()) {
                paper.append(op1.pop());
            }

            i++;
        }

        while (!op1.isEmpty()) {
            paper.append(op1.pop());
        }

        return paper.toString();
    }


    public static void main(String[] args) {
        UsingARobotToPrintTheLexicographicallySmallestString2434 obj = new UsingARobotToPrintTheLexicographicallySmallestString2434();
        System.out.println(obj.robotWithString("zza"));
        System.out.println(obj.robotWithString("bac"));
    }
}
