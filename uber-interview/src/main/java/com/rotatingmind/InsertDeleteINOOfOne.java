package com.rotatingmind;

import java.util.HashMap;
import java.util.Random;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * insert(val): Inserts an item val to the set if not already present. remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned. Example:
 * <p>
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * <p>
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * <p>
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * <p>
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * <p>
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * <p>
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * <p>
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * <p>
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class InsertDeleteINOOfOne {
    private HashMap<Integer, Integer> numToIndex;
    private HashMap<Integer, Integer> indexToNum;
    private int size;
    private Random r;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteINOOfOne() {
        numToIndex = new HashMap<Integer, Integer>();
        indexToNum = new HashMap<Integer, Integer>();
        size = 0;
        r = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!numToIndex.containsKey(val)) {
            indexToNum.put(size, val);
            numToIndex.put(val, size);
            size++;
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (numToIndex.containsKey(val)) {
            int index = numToIndex.get(val);
            int lastVal = indexToNum.get(size - 1);
            indexToNum.put(index, lastVal);
            indexToNum.remove(size - 1);
            numToIndex.put(lastVal, index);
            numToIndex.remove(val);
            size--;
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (size == 0) {
            return -1;
        }
        int index = r.nextInt(size);
        int val = indexToNum.get(index);
        return val;
    }
}
