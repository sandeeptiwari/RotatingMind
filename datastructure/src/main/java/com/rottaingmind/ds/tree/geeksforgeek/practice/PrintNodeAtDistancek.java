package com.rottaingmind.ds.tree.geeksforgeek.practice;

import com.rottaingmind.ds.tree.geeksforgeek.code.Node;

public class PrintNodeAtDistancek {


    public void printKthNode(Node root, int k) {
        if (root == null) return;

        if (k == 0) {
            System.out.println(root.getLabel());
        } else {
            printKthNode(root.getLeftChild(), k - 1);
            printKthNode(root.getRightChild(), k - 1);
        }
    }
}
