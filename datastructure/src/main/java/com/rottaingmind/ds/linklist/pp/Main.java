package com.rottaingmind.ds.linklist.pp;

import com.rottaingmind.ds.linklist.Node;

public class Main {


    /**
     *     *    5 -> 1 -> 2 -> 4 -> 11 -> 3
     *      *              |               |
     *      *              3 -> 4-> 5      9
     *      *                              |
     *      *                              8
     * @param args
     */
    public static void main(String[] args) {
        CustomLinkList list = new CustomLinkList();
       // palindromeTest(list);
        flattenToTheTest(list);
    }

    private static void flattenToTheTest(CustomLinkList list) {
        Node<Integer> n1 = new Node<>(5);
        Node<Integer> n2 = new Node<>(1);
        Node<Integer> n3 = new Node<>(2);

        n1.setNextNode(n2);
        n2.setNextNode(n3);

        Node<Integer> n4 = new Node<>(3);
        Node<Integer> n5 = new Node<>(4);
        Node<Integer> n6 = new Node<>(5);

        Node<Integer> n7 = new Node<>(6);

        n3.setDown(n4);
        n4.setNextNode(n5);
        n4.setDown(n7);
        n5.setNextNode(n6);

        list.traverse(n1);

        System.out.println("\n");

        Node<Integer> r = list.flattenList(n1);
        list.traverse(r);
    }


    private static void checkLoopTest(CustomLinkList list) {
        Node<Integer> head = list.insertAtTail(5);
        list.insertAtTail(1);
        list.insertAtTail(7);
        list.insertAtTail(0);
        list.insertAtTail(4);
        list.insertAtTail(6);
        list.insertAtTail(7);

        list.traverse(list.gethead());

        System.out.println(list.isCycleDependencyV1(list.gethead()));
    }

    private static void reverseTest(CustomLinkList list) {
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);

        list.traverse(list.gethead());


        list.reverseV1(list.gethead());

        System.out.println("\n");

        list.traverse(list.gethead());
    }


    private static void palindromeTest(CustomLinkList list) {
        list.insertAtTail(1);
        list.insertAtTail(0);
        list.insertAtTail(3);
        list.insertAtTail(3);
        list.insertAtTail(0);
        list.insertAtTail(1);

        list.traverse(list.gethead());

        System.out.println("\n");

        System.out.println(list.isPalindrome());
    }


}
