package com.rottaingmind.ds.stack.applications;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
 *
 * Implement the FreqStack class:
 *
 * FreqStack() constructs an empty frequency stack.
 * void push(int val) pushes an integer val onto the top of the stack.
 * int pop() removes and returns the most frequent element in the stack.
 * If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 *
 *
 * Example 1:
 *
 * Input
 * ["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
 * [[], [5], [7], [5], [7], [4], [5], [], [], [], []]
 * Output
 * [null, null, null, null, null, null, null, 5, 7, 5, 4]
 *
 * Explanation
 * FreqStack freqStack = new FreqStack();
 * freqStack.push(5); // The stack is [5]
 * freqStack.push(7); // The stack is [5,7]
 * freqStack.push(5); // The stack is [5,7,5]
 * freqStack.push(7); // The stack is [5,7,5,7]
 * freqStack.push(4); // The stack is [5,7,5,7,4]
 * freqStack.push(5); // The stack is [5,7,5,7,4,5]
 * freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
 * freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
 * freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
 * freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
 *
 *
 * Constraints:
 *
 * 0 <= val <= 109
 * At most 2 * 104 calls will be made to push and pop.
 * It is guaranteed that there will be at least one element in the stack before calling pop.
 */

class FreqStack {

    private Map<Integer, Integer> freqMap;
    private Map<Integer, Stack<Integer>> freqToStackMap;
    private int currMaxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        freqToStackMap = new HashMap<>();
        currMaxFreq = 0;
    }

    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);
        currMaxFreq = Math.max(currMaxFreq, freq);

        /**
         * if (map. get(key) == null) {
         *  V newValue = mappingFunction. apply(key);
         *
         *  if (newValue != null)
         *    map. put(key, newValue);
         * }
         */
        Stack<Integer> stk = freqToStackMap.computeIfAbsent(freq, k -> new Stack<>());
        stk.push(val);
    }

    public int pop() {
        Stack<Integer> stack = freqToStackMap.get(currMaxFreq);
        int closestElement = stack.pop();
        freqMap.put(closestElement, freqMap.get(closestElement) - 1);

        if (stack.isEmpty()) {
            currMaxFreq--;
        }

        return closestElement;
    }
}

public class MaximumFrequencyStack {
    public static void main(String[] args) {
        String[] ops = {"FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"};

        int[][] val = { {}, {5}, {7}, {5}, {7},{4},{5},{},{},{},{}};
        FreqStack freqStack = null;

        for (int i = 0; i < ops.length; i++) {
            String operation = ops[i];

            switch (operation) {
                case "FreqStack":
                    freqStack = new FreqStack();
                    System.out.print("null, ");
                    break;
                case "push" :
                    freqStack.push(val[i][0]);
                    System.out.print("null, ");
                    break;
                case "pop":
                    System.out.print(freqStack.pop() + ", ");
                    break;
            }
        }

    }

}
