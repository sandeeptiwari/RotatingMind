package com.rottaingmind.ds.linklist;

import java.util.Objects;

public class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> nextNode;
    private Node<T> random;
    private Node<T> down;

    public Node() {

    }
    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<T> getRandom() {
        return random;
    }

    public Node<T> getDown() {
        return down;
    }

    public void setDown(Node<T> down) {
        this.down = down;
    }

    public void setRandom(Node<T> random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "{ "
                   + data +
                " } -> ";
    }
}
