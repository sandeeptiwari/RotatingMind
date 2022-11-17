package com.rottaingmind.ds.tree;


public class TreeFactory {

    public static TreeNode constructTree(Integer... labels)
    {
        TreeNode root = new TreeNode(labels[0]);
        for(int i = 1; i < labels.length; i++)
        {
            insertTreeNode(root, new TreeNode(labels[i]));
        }
        return root;
    }

    private static void insertTreeNode(TreeNode rootTreeNode, TreeNode newTreeNode)
    {
        Integer rootLabel = rootTreeNode.getData();
        Integer data = newTreeNode.getData();
        boolean less = data.compareTo(rootLabel) < 0;
        if(less)
        {
            TreeNode leftChild = rootTreeNode.getLeftChild();
            if(leftChild == null)
            {
                rootTreeNode.setLeftChild(newTreeNode);
            }
            else
            {
                insertTreeNode(leftChild, newTreeNode);
            }
        }
        else
        {
            TreeNode rightChild = rootTreeNode.getRightChild();
            if(rightChild == null)
            {
                rootTreeNode.setRightChild(newTreeNode);
            }
            else
            {
                insertTreeNode(rightChild, newTreeNode);
            }
        }
    }
}
