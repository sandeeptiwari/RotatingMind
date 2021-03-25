package ds.heap;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Heap {
    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int getParent(int position) {
        return (position - 1) / 2;
    }

    /*
     * -> Always new new items will insert to the end of the array
     * -> Then we have to fixed the ds.heap (heapify)
     * -> We compare the new  item against it parent
     * -> If the item is greater than its parent, we swap it with its parent
     * -> We  then rinse and repeat
     */
    public void insert(int value) {
        if(isFull()) {
            throw new IndexOutOfBoundsException("Heap is full, couldn't add new item");
        }

        heap[size] = value;

        fixHeapAbove(size);
        size++;
    }

    public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        int parent = getParent(index);
        int deletedValue = heap[index];
        heap[index] = heap[size - 1];

        if(index == 0 || heap[index] < parent) {
            fixHeapBelow(index, size -1);
        } else {
            fixHeapAbove(index);
        }
        size--;
        return deletedValue;
    }

    private void fixHeapAbove(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex) {
        
        while(index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            int childToSwap;
            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
                }

                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    break;
                }
                index = childToSwap;
            } else {
                break;
            }
        }
    }

    public void sort() {
        int lastHeapIndex = size - 1;
        for (int i = 0; i < lastHeapIndex; i++) {
            int temp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - 1] = temp;

            fixHeapBelow(0, lastHeapIndex - i - 1);
        }
    }

    public void printHeap() {
        var heapValueStr = Arrays.stream(heap).mapToObj(ele -> String.valueOf(ele))
                .collect(Collectors.joining(", "));
        System.out.println("Value " + heapValueStr);
    }

    public int getChild(int index, boolean isLeft) {
        return 2 * index + (isLeft ? 1 : 2);
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
