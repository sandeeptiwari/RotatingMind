package com.rottaingmind.ds.stack.applications;

import java.util.*;

/**
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.
 *
 * Implement the NestedIterator class:
 *
 * NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
 * int next() Returns the next integer in the nested list.
 * boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
 * Your code will be tested with the following pseudocode:
 *
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 *     append iterator.next() to the end of res
 * return res
 * If res matches the expected flattened list, then your code will be judged as correct.
 *
 *
 *
 * Example 1:
 *
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 *
 * Input: nestedList = [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 *
 *
 * Constraints:
 *
 * 1 <= nestedList.length <= 500
 * The values of the integers in the nested list is in the range [-106, 106].
 */

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
   // Return empty list if this NestedInteger holds a single integer
   List<NestedInteger> getList();
}

class NestedIntegerImpl implements NestedInteger {

    private final Object data;

    NestedIntegerImpl(List<Object> data) {
        this.data = data;
    }

    @Override
    public boolean isInteger() {
        boolean isInt = true;

        if (data instanceof List) {
            isInt = false;
        }

        return true;
    }

    @Override
    public Integer getInteger() {
        return (data instanceof List) ? null : (Integer) data;
    }

    @Override
    public List<NestedInteger> getList() {
        return (data instanceof List) ? new ArrayList<>((List)data) : Collections.emptyList();
    }
}
public class FlattenNestedListIterator implements Iterator<Integer> {
    private Deque<Integer> stack = new ArrayDeque<>();

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        pushAll(nestedList);
    }

    private void pushAll(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                stack.push(ni.getInteger());
            } else {
                pushAll(ni.getList());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Integer next() {
        return stack.pop();
    }


    public static void main(String[] args) {
        List<Object> nestedList = List.of(List.of(1,1),2,List.of(1,1));

    }
}
