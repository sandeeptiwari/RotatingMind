package com.rotatingmind.stackoverflow;

public class Problem74343461 {

    public static <T> void reverse(Node<Integer> list){
        Node<Integer> root = new Node<>();
        Node<Integer> previous = root; //To keep track of the previous element, will be used in swapping links
        Node<Integer> current = root; //firstElement
        Node<Integer> next = null;

        //While Traversing the list, swap links
        while (current != null) {
            next = current;
            current = previous;
            previous = current;
            current = next;
        }
        //Linking Head Node with the new First Element
        list = previous;
    }
}

class Node<T> {
    private T data;
    private Node<T> head;
    private Node<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
