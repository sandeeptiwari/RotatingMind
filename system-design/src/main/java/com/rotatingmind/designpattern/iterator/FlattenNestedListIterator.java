package com.rotatingmind.designpattern.iterator;

import java.util.*;

/**
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may
 * also be integers or other lists. Implement an iterator to flatten it.
 * <p>
 * Implement the NestedIterator class:
 * <p>
 * NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
 * int next() Returns the next integer in the nested list.
 * boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
 * Your code will be tested with the following pseudocode:
 * <p>
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 * append iterator.next() to the end of res
 * return res
 * <p>
 * If res matches the expected flattened list, then your code will be judged as correct.
 * <p>
 * Example 1:
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * <p>
 * Input: nestedList = [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 * <p>
 * Constraints:
 * <p>
 * 1 <= nestedList.length <= 500
 * The values of the integers in the nested list is in the range [-106, 106].
 */

interface NestedInteger {

    /**
     * @return true if this NestedInteger holds a single integer, rather than a nested list.
     */
    boolean isInteger();

    /**
     * @return the single integer that this NestedInteger holds, if it holds a single integer
     * Return null if this NestedInteger holds a nested list
     */
    Integer getInteger();

    /**
     * @return the nested list that this NestedInteger holds, if it holds a nested list
     * Return empty list if this NestedInteger holds a single integer
     */
    List<NestedInteger> getList();
}

class NestedInt implements NestedInteger {

    private final Integer value;

    public NestedInt(Integer value) {
        this.value = value;
    }

    @Override
    public boolean isInteger() {
        return true;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return null;
    }
}

class NestedList implements NestedInteger {
    private final List<NestedInteger> list;

    public NestedList(List<NestedInteger> list) {
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}

class NestedIterator implements Iterator<Integer> {
    private Stack<Iterator<NestedInteger>> stack; // Stack of iterators
    private Integer nextInteger; // Cache for the next integer


    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize the stack with the iterator of the outermost list
        this.stack = new Stack<>();
        this.stack.push(nestedList.iterator());
        this.nextInteger = null; // Initially, no integer is cached
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> currentIterator = stack.peek();

            if (!currentIterator.hasNext()) {
                // If the current iterator is exhausted, pop it
                stack.pop();
                continue;
            }

            NestedInteger current = currentIterator.next();

            if (current.isInteger()) {
                // Cache the next integer and return true
                nextInteger = current.getInteger();
                return true;
            } else {
                // Push the iterator of the nested list onto the stack
                stack.push(current.getList().iterator());
            }
        }
        return false; // No more integers
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer result = nextInteger;
        nextInteger = null; // Reset after consuming
        return result;
    }
}

public class FlattenNestedListIterator {

    public static void main(String[] args) {
        // Example input: [[1,1],2,[1,1]]
        List<NestedInteger> nestedList = Arrays.asList(
                new NestedList(Arrays.asList(new NestedInt(1), new NestedInt(1))),
                new NestedInt(2),
                new NestedList(Arrays.asList(new NestedInt(1), new NestedInt(1)))
        );

        NestedIterator iterator = new NestedIterator(nestedList);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " "); // Output: 1 1 2 1 1
        }
    }
}
