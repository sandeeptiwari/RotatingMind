package com.rottaingmind.ds.linklist.doubly;

public class Node<T extends Comparable<T>> {
    private T Data;
    private Node<T> previous;
    private Node<T> next;

    public Node(T data) {
        Data = data;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "{" + Data +"} => ";
    }
}
