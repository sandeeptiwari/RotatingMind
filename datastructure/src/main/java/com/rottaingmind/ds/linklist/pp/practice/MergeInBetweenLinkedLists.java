package com.rottaingmind.ds.linklist.pp.practice;

/**
 * You are given two linked lists: list1 and list2 of sizes n and m respectively.
 *
 * Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
 *
 * The blue edges and nodes in the following figure indicate the result:
 */
public class MergeInBetweenLinkedLists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        if (list2 == null) return list1;

        ListNode p1 = list1;
        ListNode p2 = list1;
        ListNode p3 = list2;

        for (int i = 1; i < a; i++) {
            p1 = p1.getNext();
        }

        for (int i = 0; i < b; i++) {
            p2 = p2.getNext();
        }

        while (p3.getNext() != null) {
            p3 = p3.getNext();
        }

        p1.setNext(list2);
        p3.setNext(p2.getNext());
        Math.ceil(1d);

        return list1;
    }
}
