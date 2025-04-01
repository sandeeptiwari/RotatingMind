package com.rottaingmind.ds.heap.heap_operrations;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfAStream {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) maxHeap.add(num);
        else minHeap.add(num);

        //either both the heap will have equal number of elements or max-heap will have one
        // more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if ( maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.peek() != null && maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek() ) / 2.0f;
        }

        return maxHeap.peek() != null ? maxHeap.peek() : -1;
    }


}
