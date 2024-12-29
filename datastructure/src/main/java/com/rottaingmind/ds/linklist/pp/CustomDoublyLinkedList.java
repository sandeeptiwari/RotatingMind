package com.rottaingmind.ds.linklist.pp;


record Node<T>(T data, Node<T> next, Node<T> previous) {}


public class CustomDoublyLinkedList {
    Node<Integer> head = new Node<Integer>(1, null, null);


    public Node<Integer> insert(int data) {
        Node<Integer> current = head;
       Node<Integer> n = new Node<Integer>(data, null, null);
       Node<Integer> tmp = current.next();
       return head;
    }
}
