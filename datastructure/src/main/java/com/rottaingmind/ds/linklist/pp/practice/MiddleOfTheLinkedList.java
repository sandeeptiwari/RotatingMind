package com.rottaingmind.ds.linklist.pp.practice;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 *
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 */

class ListNode<T> {
    private T val;
    private ListNode<T> next;

    ListNode() {
    }

    ListNode(T val) {
        this.val = val;
    }

    ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}

public class MiddleOfTheLinkedList {


    public ListNode<Integer> middleNode(ListNode<Integer> head) {
        if (head == null) {
            return null;
        }
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
}
