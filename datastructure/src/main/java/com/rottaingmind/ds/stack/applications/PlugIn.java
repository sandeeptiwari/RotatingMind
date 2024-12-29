package com.rottaingmind.ds.stack.applications;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A. Plug-in
 * time limit per test1 second
 * memory limit per test256 megabytes
 * inputstandard input
 * outputstandard output
 * Polycarp thinks about the meaning of life very often. He does this constantly, even when typing in the editor. Every time he starts brooding he can no longer fully concentrate and repeatedly presses the keys that need to be pressed only once. For example, instead of the phrase "how are you" he can type "hhoow aaaare yyoouu".
 *
 * Polycarp decided to automate the process of correcting such errors. He decided to write a plug-in to the text editor that will remove pairs of identical consecutive letters (if there are any in the text). Of course, this is not exactly what Polycarp needs, but he's got to start from something!
 *
 * Help Polycarp and write the main plug-in module. Your program should remove from a string all pairs of identical letters, which are consecutive. If after the removal there appear new pairs, the program should remove them as well. Technically, its work should be equivalent to the following: while the string contains a pair of consecutive identical letters, the pair should be deleted. Note that deleting of the consecutive identical letters can be done in any order, as any order leads to the same result.
 *
 * Input
 * The input data consists of a single line to be processed. The length of the line is from 1 to 2·105 characters inclusive. The string contains only lowercase Latin letters.
 *
 * Output
 * Print the given string after it is processed. It is guaranteed that the result will contain at least one character.
 * input:
 * hhoowaaaareyyoouu
 * output:
 * wre
 *
 * input:
 * reallazy
 * output:
 * rezy
 * input:
 * abacabaabacabaa
 * output:
 * a
 */
public class PlugIn {

    /**
     * abacabaabacabaa
     * 1-  a
     */
    public static String removeIdenticalPair(String input) {
        Deque<Character> main = new ArrayDeque<>();

        int n = input.length();

        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if (main.isEmpty() || main.peek() != c) {
                main.push(c);
            } else {
                if (main.peek() == c) {
                    main.pop();
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!main.isEmpty()) {
                builder.append(main.pop());
            }
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        //System.out.println(removeIdenticalPair("abacabaabacabaa"));
        //System.out.println(removeIdenticalPair("reallazy"));
        System.out.println(removeIdenticalPair("hhoowaaaareyyoouu"));
    }
}
