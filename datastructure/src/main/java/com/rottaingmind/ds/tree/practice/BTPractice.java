package com.rottaingmind.ds.tree.practice;


import com.rottaingmind.ds.tree.pp.Root;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class TreeNodePair {
    TreeNode node;
    int value;

    TreeNodePair(TreeNode node, int value) {
        this.node = node;
        this.value = value;
    }
}


public class BTPractice {

    //root = [1,3,2,5,3,null,9]

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<TreeNodePair> queue = new LinkedList<>();
        queue.offer(new TreeNodePair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = queue.peek().value; // Start index of the level
            int end = queue.peek().value; // End index of the level (initially same as start)

            for (int i = 0; i < size; i++) {
                TreeNodePair current = queue.poll();
                TreeNode node = current.node;
                int index = current.value;

                // Update the end index of this level
                end = index;

                if (node.left != null) {
                    queue.offer(new TreeNodePair(node.left, 2 * index));
                }
                if (node.right != null) {
                    queue.offer(new TreeNodePair(node.right, 2 * index + 1));
                }
            }

            maxWidth = Math.max(maxWidth, end - start + 1);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(9))
        );

        System.out.println(widthOfBinaryTree(root));
    }

}
