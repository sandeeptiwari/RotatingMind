package com.rottaingmind.application.tree;

import com.rottaingmind.ds.tree.Tree;
import com.rottaingmind.ds.tree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTree {

    //Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1]
    @Test
    public void testHasPath() {
        Tree intTree = new Tree();
        intTree.insert(5);
        intTree.getRoot().setLeftChild(new TreeNode(4));
        intTree.getRoot().setRightChild(new TreeNode(8));

        intTree.getRoot().getLeftChild().setLeftChild(new TreeNode(11));
        intTree.getRoot().getLeftChild().getLeftChild().setLeftChild(new TreeNode(7));
        intTree.getRoot().getLeftChild().getLeftChild().setRightChild(new TreeNode(2));

        intTree.getRoot().getRightChild().setRightChild(new TreeNode(4));
        intTree.getRoot().getRightChild().setLeftChild(new TreeNode(13));
        intTree.getRoot().getRightChild().getRightChild().setRightChild(new TreeNode(1));

        boolean b = intTree.hasPathSum(intTree.getRoot(), 22);
        assertTrue(b == true);

    }
}
