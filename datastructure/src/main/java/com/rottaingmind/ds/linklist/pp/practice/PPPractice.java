package com.rottaingmind.ds.linklist.pp.practice;

import com.rottaingmind.ds.linklist.List;

public class PPPractice {

    /**
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     */
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseListRec(ListNode head) {
        if (head == null || head.getNext() == null)
            return head;

        ListNode secondNode = head.getNext();
        ListNode newHead = reverseListRec(secondNode);
        secondNode.setNext(head);
        head.setNext(null);

        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.getNext() == null)
            return true;
        ListNode curr = head;
        ListNode midNode = getMid(curr);
        ListNode newHead = reverseListRec(midNode);

        if (newHead.getNext() == null) {
            if (newHead.getVal() == curr.getVal()) {
                return true;
            }
            return false;
        }

        while (newHead != null) {
            if (curr.getVal() != newHead.getVal()) {
                return false;
            }
            curr = curr.getNext();
            newHead = newHead.getNext();

        }
        return true;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }


    /**
     * You are given the head of a singly linked-list. The list can be represented as:
     * <p>
     * L0 → L1 → … → Ln - 1 → Ln
     * Reorder the list to be on the following form:
     * <p>
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
     * <p>
     * Input: head = [1,2,3,4]
     * Output: [1,4,2,3]
     * <p>
     * Input: head = [1,2,3,4,5]
     * Output: [1,5,2,4,3]
     */
    public void reorderList(ListNode head) {
        if (head == null || head.getNext() == null)
            return;

        ListNode curr = head;
        ListNode midNode = getMid(curr);
        ListNode newHead = reverseListRec(midNode);

        curr = reorderListRec(curr, newHead);

        while (curr != null) {
            System.out.print(curr.getVal() + ", ");
            curr = curr.getNext();
        }
    }

    public ListNode reorderListRec(ListNode part1, ListNode part2) {
        if (part1 == null || part2 == null) {
            return null;
        }

        if (part1 == part2) {
            return part1;
        }

        ListNode l1 = part1.getNext();
        part1.setNext(null);

        ListNode l2 = part2.getNext();
        part2.setNext(null);

        ListNode h = reorderListRec(l1, l2);
        part2.setNext(h);
        part1.setNext(part2);

        return part1;
    }


    /**
     * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
     * <p>
     * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is
     * not a multiple of k then left-out nodes, in the end, should remain as it is.
     * <p>
     * You may not alter the values in the list's nodes, only nodes themselves may be changed.
     * <p>
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [2,1,4,3,5]
     * <p>
     * Input: head = [1,2,3,4,5], k = 3
     * Output: [3,2,1,4,5]
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int count = 1;
        ListNode curr = head;
        ListNode h1 = head;
        while (curr.getNext() != null && count < k) {
            count++;
            curr = curr.getNext();
        }

        if (count % k != 0) {
            return h1;
        }

        ListNode newHead = curr.getNext();
        curr.setNext(null);
        ListNode reverseHead = reverseListRec(h1);
        ListNode node = reverseKGroup(newHead, k);
        h1.setNext(node);

        return reverseHead;
    }

    /**
     * Given the head of a singly linked list and two integers left and right where left <= right,
     * reverse the nodes of the list from position left to position right, and return the reversed list.
     * <p>
     * Input: head = [1,2,3,4,5], left = 2, right = 4
     * Output: [1,4,3,2,5]
     * <p>
     * Input: head = [5], left = 1, right = 1
     * Output: [5]
     */
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.setNext(head);
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for (int i = 0; i < m - 1; i++) pre = pre.getNext();

        ListNode start = pre.getNext(); // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.getNext(); // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for (int i = 0; i < n - m; i++) {
            start.setNext(then.getNext());
            then.setNext(pre.getNext());
            pre.setNext(then);
            then = start.getNext();
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.getNext();

    }

    public ListNode reverseBetweenV1(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.setNext(head);
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.getNext();
            System.out.println(prev.getVal());
        }
        ListNode curr = prev.getNext();
        ListNode next = null;
        ListNode reversePrev = null;

        for (int i = left; i <= right; i++) {
            next = curr.getNext();
            curr.setNext(reversePrev);
            reversePrev = curr;
            curr = next;
        }


        prev.getNext().setNext(curr);
        prev.setNext(reversePrev);

        return dummy.getNext();
    }

    /**
     * Given the head of a linked list, rotate the list to the right by k places
     * <p>
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [4,5,1,2,3]
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        ListNode curr = head;
        ListNode curr1 = curr;
        ListNode temp;
        int n = 1;


        while (curr != null && curr.getNext() != null) {
            n++;
            curr = curr.getNext();

        }
        k = k % n;
        curr = head;
        for (int i = 0; i < n - k - 1; i++) {
            curr = curr.getNext();
        }

        ListNode r2 = null;
        if (curr != null) {
            temp = curr.getNext();
            curr.setNext(null);
            r2 = reverseListRec(temp);
        }

        ListNode r1 = reverseListRec(curr1);
        curr1.setNext(r2);

        head = reverseListRec(r1);

        return head;
    }


    /**
     * Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
     *
     * The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.
     *
     * The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.
     *
     * Return an array of the k parts.
     *
     *
     * The "Split Linked List in Parts" problem on LeetCode asks you to split a given linked list into a specified number of consecutive parts. The list should be split as evenly as possible, meaning some parts may have one more node than others if the nodes don't divide evenly.
     *
     * Steps to Solve the Problem
     * Determine the Length of the Linked List:
     *
     * Traverse the linked list to count the total number of nodes.
     * Calculate the Size of Each Part:
     *
     * Determine the base size of each part by dividing the total number of nodes by the number of parts (k).
     * Determine the number of parts that need to have one extra node. This is done by calculating the remainder when dividing the total number of nodes by k.
     * Split the List:
     *
     * Traverse the list again to split it into parts, ensuring the first few parts have one more node than the base size if needed.
     * Use a loop to handle the splitting, carefully managing the pointers to break the list into parts.
     * Return the Parts:
     *
     * Return an array where each element is the head of one of the linked list parts.
     * Example Walkthrough
     * Let's go through an example step by step.
     *
     * Example 1:
     * Input: root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
     * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
     * Step 1: Determine the Length of the Linked List
     *
     * Traverse the linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
     * Length (n) = 10
     * Step 2: Calculate the Size of Each Part
     *
     * Base size of each part (partSize) = 10 / 3 = 3 (each part should have at least 3 nodes)
     * Number of parts with one extra node (extra) = 10 % 3 = 1 (the first part should have 4 nodes)
     * Step 3: Split the List
     *
     * Start splitting:
     * First part: 4 nodes (1 -> 2 -> 3 -> 4)
     * Second part: 3 nodes (5 -> 6 -> 7)
     * Third part: 3 nodes (8 -> 9 -> 10)
     * Step 4: Return the Parts
     *
     * The resulting array of parts would be: [ [1 -> 2 -> 3 -> 4], [5 -> 6 -> 7], [8 -> 9 -> 10] ]
     * Example 2:
     * Input: root = [1, 2, 3], k = 5
     * Output: [[1], [2], [3], [], []]
     * Step 1: Determine the Length of the Linked List
     *
     * Traverse the linked list: 1 -> 2 -> 3
     * Length (n) = 3
     * Step 2: Calculate the Size of Each Part
     *
     * Base size of each part (partSize) = 3 / 5 = 0 (each part should have at least 0 nodes)
     * Number of parts with one extra node (extra) = 3 % 5 = 3 (the first three parts should have 1 node each)
     * Step 3: Split the List
     *
     * Start splitting:
     * First part: 1 node (1)
     * Second part: 1 node (2)
     * Third part: 1 node (3)
     * Fourth part: 0 nodes ([])
     * Fifth part: 0 nodes ([])
     * Step 4: Return the Parts
     *
     * The resulting array of parts would be: [ [1], [2], [3], [], [] ]
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int length = 0;
        ListNode current = head;

        // Step 1: Calculate the length of the linked list
        while (current != null) {
            length++;
            current = current.getNext();
        }

        int partSize = length / k;    // Base size of each part
        int extra = length % k;       // Number of parts with an extra node

        current = head;
        for (int i = 0; i < k; i++) {
            ListNode root = current;
            int currentPartSize = partSize + (i < extra ? 1 : 0); // Add an extra node if needed

            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) {
                    current = current.getNext();
                }
            }

            if (current != null) {
                ListNode next = current.getNext();
                current.setNext(null);  // Split the list
                current = next;
            }

            result[i] = root; // Store the part in the result array
        }

        return result;
    }

    /**
     * Problem Explanation
     * The "Swap Nodes in Pairs" problem on LeetCode asks you to swap every two adjacent nodes in a linked list. If there is an odd number of nodes, the last node remains unchanged. The goal is to return the modified linked list after performing the swaps.
     *
     * Steps to Solve the Problem
     * Let's break down the solution step by step.
     *
     * Example 1
     * Input: head = [1, 2, 3, 4]
     * Output: [2, 1, 4, 3]
     * Step 1: Initialize Pointers
     *
     * Create a dummy node to simplify edge cases (e.g., when the list has fewer than 2 nodes).
     * Set the prev pointer to the dummy node, and the current pointer to the head of the list.
     * Step 2: Traverse the List
     *
     * While traversing, check if there are at least two nodes to swap (current and current.next).
     * Step 3: Perform the Swap
     *
     * Identify the first and second nodes to swap.
     * Adjust pointers to swap these two nodes.
     * Move the prev pointer forward by two nodes and continue the process.
     * Step 4: Return the New List
     *
     * After all possible swaps, return the new head of the list (i.e., dummy.next).
     * Example Walkthrough
     * Let's go through an example step by step.
     *
     * Example 1:
     * Input: head = [1, 2, 3, 4]
     * Output: [2, 1, 4, 3]
     * Step 1: Initial Setup
     *
     * Create a dummy node: dummy -> 1 -> 2 -> 3 -> 4
     * Set prev to dummy and current to 1.
     * Step 2: First Swap
     *
     * Nodes to swap: 1 and 2.
     * Adjust pointers:
     * prev.next = 2
     * 1.next = 3
     * 2.next = 1
     * After swap: dummy -> 2 -> 1 -> 3 -> 4
     * Move prev to 1 and current to 3.
     * Step 3: Second Swap
     *
     * Nodes to swap: 3 and 4.
     * Adjust pointers:
     * prev.next = 4
     * 3.next = null
     * 4.next = 3
     * After swap: dummy -> 2 -> 1 -> 4 -> 3
     * current is now null, so the loop ends.
     * Step 4: Return the New List
     *
     * The new head is dummy.next, which points to the start of the modified list: [2, 1, 4, 3].
     * Example 2:
     * Input: head = [1, 2, 3]
     * Output: [2, 1, 3]
     * Step 1: Initial Setup
     *
     * Create a dummy node: dummy -> 1 -> 2 -> 3
     * Set prev to dummy and current to 1.
     * Step 2: First Swap
     *
     * Nodes to swap: 1 and 2.
     * Adjust pointers:
     * prev.next = 2
     * 1.next = 3
     * 2.next = 1
     * After swap: dummy -> 2 -> 1 -> 3
     * Move prev to 1 and current to 3.
     * Step 3: No More Pairs
     *
     * Since current.next is null, there are no more pairs to swap.
     * The list remains as [2, 1, 3].
     * Step 4: Return the New List
     *
     * The new head is dummy.next, which points to [2, 1, 3].
     * Java Implementation
     * Here is the Java code implementation for this problem:
     */
    public ListNode swapPairs(ListNode head) {
        // Step 1: Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.setNext(head);

        // Step 2: Initialize pointers
        ListNode prev = dummy;
        ListNode current = head;

        // Step 3: Traverse and swap nodes
        while (current != null && current.getNext() != null) {
            ListNode first = current;
            ListNode second = current.getNext();

            // Swap nodes
            prev.setNext(second);
            first.setNext(second.getNext());
            second.setNext(first);

            // Move pointers forward
            prev = first;
            current = first.getNext();
        }

        // Step 4: Return the new head
        return dummy.getNext();
    }

    //142. Linked List Cycle II
    public ListNode<Integer> detectCycle(ListNode<Integer> head) {

        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        boolean hasCycle = false;

        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            ListNode<Integer> p = head;
            ListNode<Integer> temp = slow;

            while(true) {

                while(temp != p) {
                    temp = temp.getNext();

                    if (temp == slow) {
                        break;
                    }
                }

                if(temp == p) return temp;

                p = p.getNext();

            }
        }
        return null;
    }


    public static void main(String[] args) {
        PPPractice obj = new PPPractice();

        ListNode n1 = new ListNode();
        ListNode n2 = new ListNode();
        ListNode n3 = new ListNode();
        ListNode n4 = new ListNode();
        ListNode n5 = new ListNode();

        n1.setVal(1);
        n1.setNext(n2);

        n2.setVal(2);
        n2.setNext(n3);

        n3.setVal(3);
        n3.setNext(n4);

        n4.setVal(4);
        n4.setNext(n5);

        n5.setVal(5);
        n5.setNext(null);

        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();

        node1.setVal(1);
        node1.setNext(node2);

        node2.setVal(2);
        node2.setNext(null);


        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        l1.setVal(3);
        l1.setNext(l2);
        l2.setVal(5);
        l2.setNext(null);

        ListNode listNode = obj.rotateRight(n1, 2);

        while (listNode != null) {
            System.out.print(listNode.getVal() + ", ");
            listNode = listNode.getNext();
        }

        //System.out.println();
    }
}
