package com.rottaingmind.ds.heap;

public class HeapTest {

    /*
     *             22
     *            /  \
     *          19   18
     *          / \   / \
     *         15  3  14 4
     *        /
     *       12
     * |22|19|18|15|3|14|4|12|
     *
     * For the node  at the array[i]
     * left child = 2i + 1;
     * right child = 2i + 2
     * parent = floor( (i -1) / 2)
     */
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(22);
        heap.insert(19);
        heap.insert(18);
        heap.insert(15);
        heap.insert(3);
        heap.insert(14);
        heap.insert(4);
        heap.insert(12);
        heap.printHeap();

        heap.delete(4);

        heap.printHeap();
    }


}
