package com.rottaingmind.ds.stack;

public class Stack<T> {
    private Node<T> head;
    private int count;

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void push(T data) {
        Node<T> newHead = new Node<>(data);
        if (head == null) {
            head = newHead;
        } else {
            Node<T> oldHead = head;
            newHead.setNext(oldHead);
            head = newHead;
        }
        count++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        count--;
        Node<T> poppedEle = head;
        head = head.getNext();
        return poppedEle.getData();
    }
}
