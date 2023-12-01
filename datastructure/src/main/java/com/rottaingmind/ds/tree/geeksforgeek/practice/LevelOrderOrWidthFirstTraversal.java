package com.rottaingmind.ds.tree.geeksforgeek.practice;

import com.rottaingmind.ds.tree.geeksforgeek.code.BinaryTreeFactory;
import com.rottaingmind.ds.tree.geeksforgeek.code.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderOrWidthFirstTraversal {

    /**
     * TC = o(n)
     * space o(1)
     * @param root
     */
    public void printLevel(Node<Integer> root) {
        if (root == null) return;

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node<Integer> curr = queue.poll();

            System.out.println(curr.getLabel());

            if (curr.getLeftChild() != null) {
                queue.add(curr.getLeftChild());
            }

            if (curr.getRightChild() != null) {
                queue.add(curr.getRightChild());
            }

        }
    }

    /**
     *         10
     *         /\
     *        /  \
     *       20  30
     *      /
     *     /
     *    40
     * @param root
     */
    public static void printLevelLineByLine(Node<Integer> root) {

        if (root == null) return;

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node<Integer> curr = queue.poll();

            if (queue.isEmpty()) break;

            if (curr == null) {
                System.out.println();
                queue.add(null);
                continue;
            }
            System.out.print(curr.getLabel() + ", "  );

            if (curr.getLeftChild() != null) queue.add(curr.getLeftChild());

            if (curr.getRightChild() != null) queue.add(curr.getRightChild());
        }

    }


    private static int sizeOfTree(Node<Integer> root) {
        if (root == null) return -1;
        int size = 1;
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<Integer> curr = queue.poll();

            if (curr.getLeftChild() != null) {
                queue.add(curr.getLeftChild());
                size++;
            }

            if (curr.getRightChild() != null) {
                queue.add(curr.getRightChild());
                size++;
            }
        }
      return size;
    }


    private static int getSize(Node<Integer> root) {
        if (root == null) return 0;

        return getSize(root.getLeftChild()) + getSize(root.getRightChild()) + 1;
    }

    private static int gteMax(Node<Integer> root) {
        if (root == null) return Integer.MIN_VALUE;
        else
        return Math.max(root.getLabel(), Math.max(gteMax(root.getLeftChild()), gteMax(root.getRightChild())));
    }

    public static void main(String[] args) {

        //Node<Integer> treeNode = BinaryTreeFactory.constructTree(10, 20, 30, 40);
        Node<Integer> root = new Node<>(10);
        root.setLeftChild(new Node<>(20));
        root.setRightChild(new Node<>(30));
        root.getLeftChild().setLeftChild(new Node<>(40));
        int size = gteMax(root);
        System.out.println("Size " + size);
    }

}
