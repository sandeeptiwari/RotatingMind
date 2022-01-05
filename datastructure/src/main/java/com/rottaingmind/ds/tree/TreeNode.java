package com.rottaingmind.ds.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeNode<T> {
    private Integer data;
    private TreeNode leftChild;
    private TreeNode rightChild;
    public TreeNode left, right;

    public TreeNode(Integer data) {
        this.data = data;
    }

    public TreeNode(int headValue, Object o, Object o1) {

    }

    public void insert(Integer value) {
        if (data == value) {
            return;
        } else if (value < data) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                leftChild.insert(value);
            }

        } else {
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    public TreeNode get(int value) {
        if (value == data) {
            return this;
        }

        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }

        return null;
    }

    public int min() {
        if (leftChild == null) {
            return data;
        } else {
            return leftChild.min();
        }
    }

    public int max() {
        if (rightChild == null) {
            return data;
        } else {
            return rightChild.max();
        }
    }

    public void traverseInorder() {
        if (leftChild != null) {
            leftChild.traverseInorder();
        }
        System.out.print(data + ", ");
        if (rightChild != null) {
            rightChild.traverseInorder();
        }
    }

    public void iterativeInorderTraversal() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = this;
        boolean isEmpty = false;
        while (current != null || !isEmpty) {
            if (current != null) {
                stack.push(current);
                current = current.getLeftChild();
            }

            if (current == null && !stack.empty()) {
                TreeNode popedItem = stack.pop();
                System.out.print(popedItem.getData() + ", ");
                current = popedItem.getRightChild();
            }
            isEmpty = stack.isEmpty();
        }
    }

    public void preOderTraversal() {
        System.out.print(data + ", ");
        if (leftChild != null) {
            leftChild.traverseInorder();
        }
        if (rightChild != null) {
            rightChild.traverseInorder();
        }
    }

    public void postOderTraversal() {
        if (leftChild != null) {
            leftChild.traverseInorder();
        }
        if (rightChild != null) {
            rightChild.traverseInorder();
        }
        System.out.print(data + ",  ");
    }

    public void levelOrderTraversal() {
        Queue<TreeNode> dataQueues = new ArrayDeque<>();
        TreeNode currentTreeNode = this;
        boolean isEmpty = false;
        while (!isEmpty) {
            System.out.print(currentTreeNode.getData() + ", ");
            if (currentTreeNode.getLeftChild() != null) {
                dataQueues.add(currentTreeNode.getLeftChild());
            }
            if (currentTreeNode.getRightChild() != null) {
                dataQueues.add(currentTreeNode.getRightChild());
            }
            isEmpty = currentTreeNode.getRightChild() == null
                    && currentTreeNode.getLeftChild() == null
                    && dataQueues.isEmpty();
            currentTreeNode = dataQueues.poll();
        }
    }

    public void printRightViewOfTree() {
        Queue<TreeNode> dataQueues = new ArrayDeque<>();
        dataQueues.add(this);
        while (!dataQueues.isEmpty()) {
            int len = dataQueues.size();

            for (int i = 0; i < len; i++) {
                var treeNode = dataQueues.poll();
                if (i == len - 1) {
                    System.out.print(treeNode.getData() + " ");
                }
                if (treeNode.getLeftChild() != null) {
                    dataQueues.add(treeNode.getLeftChild());
                }
                if (treeNode.getRightChild() != null) {
                    dataQueues.add(treeNode.getRightChild());
                }
            }
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = maxDepth(root.getLeftChild());
        int rDepth = maxDepth(root.getRightChild());

        if (lDepth > rDepth) {
            return lDepth + 1;
        } else {
            return rDepth + 1;
        }
    }

    public boolean hasPathSum(TreeNode<Integer> root, int targetSum) {
        Stack<TreeNode<Integer>> stackNode = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        stackNode.push(root);
        sumStack.push(targetSum - root.getData());

        while (!stackNode.isEmpty()) {
            TreeNode<Integer> currentNode = stackNode.pop();
            int currentSum = sumStack.pop();

            if (currentNode.leftChild == null && currentNode.rightChild == null && currentSum == 0) {
                return true;
            }

            if (currentNode.leftChild != null) {
                stackNode.push(currentNode.leftChild);
                sumStack.push(currentSum - currentNode.leftChild.getData());
            }

            if (currentNode.rightChild != null) {
                stackNode.push(currentNode.rightChild);
                sumStack.push(currentSum - currentNode.rightChild.getData());
            }
        }
        return false;
    }

    public Integer getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
