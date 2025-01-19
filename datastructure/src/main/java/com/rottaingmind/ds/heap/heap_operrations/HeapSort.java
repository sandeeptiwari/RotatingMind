package com.rottaingmind.ds.heap.heap_operrations;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class HeapSort {


    /**
     * Explanation of Comparator (a, b) -> b - a:
     * This comparator is a lambda expression used to define how the PriorityQueue should compare two elements (a and b) to decide their order in the heap. Here's the detailed behavior:
     *
     * Comparator Signature:
     *
     * (a, b) are two elements being compared.
     * The result of b - a determines the relative priority:
     * If b - a > 0 → b is "larger" and should come before a in the heap.
     * If b - a < 0 → a is "larger" and should come before b in the heap.
     * If b - a == 0 → a and b are considered "equal" in priority.
     * How This Makes a Max-Heap:
     *
     * In a max-heap, the largest element is always at the root (highest priority).
     * The comparator b - a flips the natural ordering of integers, so larger numbers have higher priority.
     * For example:
     * Compare 9 and 4: b - a = 4 - 9 = -5. Since b - a < 0, 9 is prioritized over 4.
     * Compare 7 and 3: b - a = 3 - 7 = -4. Since b - a < 0, 7 is prioritized over 3.
     * Thus, using (a, b) -> b - a, the largest elements "bubble up" in the heap, and you get a max-heap.
     *
     * Input Array: {4, 1, 3, 9, 7}
     * Using the comparator (a, b) -> b - a, the priority queue behaves like a max-heap:
     *
     * Step 1: Insert 4 → Heap: [4]
     * Step 2: Insert 1 → Heap: [4, 1]
     * (No reordering needed because 4 is larger than 1.)
     * Step 3: Insert 3 → Heap: [4, 1, 3]
     * (No reordering needed because 4 is still the largest.)
     * Step 4: Insert 9 → Heap: [9, 4, 3, 1]
     * (9 "bubbles up" to the top since it is the largest.)
     * Step 5: Insert 7 → Heap: [9, 7, 3, 1, 4]
     * (7 is placed as the child of 9 but is larger than 4.)
     * The heap is now organized as a max-heap.
     *
     * 1. Building the Heap (addAll):
     * When inserting n elements into a priority queue, each insertion (add) takes O(log n) because the element may need to "bubble up" to maintain the heap property.
     * If there are n elements, the total cost is O(n log n).
     * 2. Polling the Elements:
     * Each poll() operation removes the root (largest element in the max-heap) and takes O(log n) time to restore the heap property by "bubbling down."
     * If you poll all n elements, the total cost is again O(n log n).
     * 3. Overall Complexity:
     * Heap Sort involves two steps:
     * Heapify the elements (O(n log n)): Insert all elements into the heap.
     * Poll elements in sorted order (O(n log n)): Remove elements one by one.
     * Combined complexity = O(n log n).
     *
     */
    public static void main(String[] args) {
        // Input array
        int[] arr = {4, 1, 3, 9, 7};

        // Convert array to collection (List)
        List<Integer> collection = Arrays.stream(arr).boxed().toList();

        // Create a max-heap using a custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(collection.size(), (a, b) -> b - a);

        // Add all elements from the collection to the PriorityQueue
        maxHeap.addAll(collection);

        // Print elements in max-heap order
        System.out.println("Max-Heap Elements (polling):");

        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
    }
}
