package com.rottaingmind.recursion.tree;

import com.rottaingmind.ds.tree.Tree;
import com.rottaingmind.ds.tree.TreeFactory;
import com.rottaingmind.ds.tree.TreeNode;
import com.rottaingmind.ds.tree.v1.Node;

import static com.rottaingmind.ds.tree.v1.BinaryTreeFactory.constructTree;

public class TreeSearch {

    private static void dfs(Node root) {
        if (root != null) {
            System.out.println(root.getLabel());
            dfs(root.getLeftChild());
            dfs(root.getRightChild());
        }
    }

    private static int sumOfTree(TreeNode root) {
        int leftSum = 0, rightSum = 0;
        if (root == null) return 0;

        leftSum = sumOfTree(root.getLeftChild());

        rightSum = sumOfTree(root.getRightChild());

        return root.getData() + leftSum + rightSum;
    }

    public static void main(String[] args) {
        String[] labels = {"quick", "brown", "fox", "jumps" , "over", "the", "lazy", "dogs", "back" };
        Node root = constructTree(labels);
        //dfs(root);

        Integer[] arr = {4, 5, 9, 11, 2, 12, 6};

        TreeNode treeNode = TreeFactory.constructTree(arr);

        System.out.println(sumOfTree(treeNode));
    }


}
