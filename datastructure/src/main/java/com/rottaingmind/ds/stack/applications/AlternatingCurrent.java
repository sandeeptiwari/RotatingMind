package com.rottaingmind.ds.stack.applications;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem Statement in screenshot alternatingcurrent.png
 */
public class AlternatingCurrent {

    public static boolean canUntangled(String wires) {
        Deque<Character> wireStack = new ArrayDeque<>();

        for (int i = 0; i < wires.length(); i++) {
            char c = wires.charAt(i);
            if (!wireStack.isEmpty() && wireStack.peek() == c) {
                wireStack.pop();
            } else {
                wireStack.push(c);
            }
        }

        return wireStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(canUntangled("-++-"));
        System.out.println(canUntangled("+-"));
        System.out.println(canUntangled("-"));
        System.out.println(canUntangled("++"));
    }
}
