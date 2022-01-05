package com.rottaingmind.ds.queue;

public class Queue<T extends Comparable<T>> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;

    public boolean isEmpty() {
        return this.firstNode == null;
    }

    public int size() {
        return count;
    }

    public void enQueue(T ele) {
        this.count++;
        Node<T> oldLastNode = lastNode;
        this.lastNode = new Node<>(ele);
        this.lastNode.setNextNode(null);
        if (isEmpty()) {
            this.firstNode = this.lastNode;
        } else {
            oldLastNode.setNextNode(lastNode);
        }
    }

    public T deque() {
        this.count--;
        T dequeData = this.firstNode.getData();
        this.firstNode = this.firstNode.getNextNode();

        if (isEmpty()) {
            this.lastNode = null;
        }
        return dequeData;
    }
 }
