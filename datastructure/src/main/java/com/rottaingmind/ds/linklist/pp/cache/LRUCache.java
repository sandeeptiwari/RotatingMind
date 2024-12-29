package com.rottaingmind.ds.linklist.pp.cache;

import java.util.Map;


class Node<T> {
    private T key;
    private T value;
    private Node<T> next;
    private Node<T> previous;
    Node(T key, T value ) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}

public class LRUCache {
    private final int capacity;
    private int currentSize;
    private int maxSize;
    private Node<Integer> head;
    private Node<Integer> tail;
    private Map<Integer, Node<Integer>> keyToAddress;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        maxSize = capacity;
        currentSize = 0;
        head = null;
        tail = null;
    }


    public Node<Integer> addToTail(Integer key, Integer value) {
        Node<Integer> n = new Node<>(key, value);
        if (tail == null) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            n.setPrevious(tail);
            tail = n;
        }
        currentSize++;
        return n;
    }

    public void moveToTail(Node<Integer> node, Integer val) {
        node.setValue(val);

        if (node == tail) {
            return;
        }
        if (node == head) {
            head = head.getNext();
            head.setPrevious(null);
        } else {
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
        }

        node.setPrevious(tail);
        node.setNext(null);
        tail.setNext(node);
        tail = node;
    }

    public void deleteHead() {
        head = head.getNext();
        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = head;
        }
        currentSize--;
    }

    public Integer get(int key) {
        int ans = -1;

        if (!keyToAddress.containsKey(key)) {
            return -1;
        } else {
            Node<Integer> node = keyToAddress.get(key);
            ans = node.getValue();
            moveToTail(node, ans);
        }
        return ans;
    }

    public void put(int key, int value) {
        //update case
        if (keyToAddress.containsKey(key)) {
            moveToTail(keyToAddress.get(key), value);
            return;
        }
        if (currentSize < maxSize) {
            keyToAddress.put(key, addToTail(key, value));
        } else {
            Node<Integer> node = keyToAddress.remove(head.getKey());
            deleteHead();
            keyToAddress.put(key, addToTail(key, value));
        }
    }
}
