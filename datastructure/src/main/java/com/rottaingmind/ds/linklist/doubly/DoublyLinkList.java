package com.rottaingmind.ds.linklist.doubly;

import com.rottaingmind.ds.linklist.List;

public class DoublyLinkList<T extends Comparable<T>> implements List<T> {

    private Node<T> head;
    private Node<T> tail;

    @Override
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    @Override
    public void remove(T data) {

    }

    @Override
    public void traverseBackward() {
        Node<T> actualNode = head;
        while (actualNode != null) {
            System.out.print(actualNode);
            actualNode = actualNode.getNext();
        }
    }

    @Override
    public void traverseForward() {
        Node<T> actualNode = tail;
        while (actualNode != null) {
            System.out.print(actualNode);
            actualNode = actualNode.getPrevious();
        }
    }

    @Override
    public void insertAtEnd(T data) {

    }

    @Override
    public int size() {
        return 0;
    }
}
