package com.rottaingmind.ds.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of N elements. The task is to build a Binary Heap from the given array. The heap can be either
 *
 * Input: arr[] = {4, 10, 3, 5, 1}
 * Output: Corresponding Max-Heap:
 *
 *
 *        10
 *      /   \
 *    5     3
 *   /  \
 * 4    1
 *
 *
 * Input: arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17}
 * Output: Corresponding Max-Heap:
 *
 *
 *                  17
 *               /      \
 *           15         13
 *          /    \      /  \
 *        9      6    5   10
 *      / \    /  \
 *    4   8  3    1
 *
 * Note::
 *
 * Root is at index 0 in array.
 * Left child of i-th node is at (2*i + 1)th index.
 * Right child of i-th node is at (2*i + 2)th index.
 * Parent of i-th node is at (i-1)/2 index.
 *
 *          9 (index 0)
 *        /   \
 *       6     8
 *      / \   / \
 *     3   5 2   1
 * [9, 6, 8, 3, 5, 2, 1]
 *
 */
public class BuildHeapDemo {
    private List<Integer> heap;

    // Constructor to initialize the heap
    public BuildHeapDemo() {
        heap = new ArrayList<>();
    }

    // Method to insert a value into the heap
    public void insert(int value) {
        // Add the value to the end of the heap
        heap.add(value);
        // Restore the max-heap property by bubbling up
        bubbleUp(heap.size() - 1);
    }

    // Method to bubble up the newly inserted value
    public void bubbleUp(int index) {
        int parentIndex = (index - 1) / 2;
        // While the index is not the root and the value is greater than its parent
        while (index > 0 && heap.get(index) > heap.get(parentIndex)) {
            // Swap the value with its parent
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }

    }

    // Utility method to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Method to return the heap as a list
    public List<Integer> getHeap() {
        return heap;
    }

    /**
     * 1. Naive Approach:  To solve the problem follow the below idea:
     * To build a Max-Heap from the above-given array elements, It can be clearly seen that the above complete binary tree
     * formed does not follow the Heap property. So, the idea is to heapify the complete binary tree formed from the array
     * in reverse level order following a top-down approach. That is first heapify,
     * the last node in level order traversal of the tree, then heapify the second last node and so on.
     *
     * Time Complexity Analysis: Heapify a single node takes O(log N) time complexity where N is the total number of Nodes. Therefore,
     * building the entire Heap will take N heapify operations and the total time complexity will be O(N*logN).
     */
    public void buildHeap(int[] arr) {
        // Insert elements into the heap (O(n log n))
        for (int num : arr) {
            insert(num);
        }

    }

    // Main method to test the implementation
    public static void main(String[] args) {
        BuildHeapDemo maxHeap = new BuildHeapDemo();

        // Input array
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};

        // Insert elements into the heap (O(n log n))
        maxHeap.buildHeap(arr);

        // Print the constructed Max-Heap
        System.out.println("Max-Heap: " + maxHeap.getHeap());
    }

}
