package com.rottaingmind.ds.tree.geeksforgeek.code;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreeFactory
{
    public static void main(String[] args)
    {
        String[] labels = {"quick", "brown", "fox", "jumps" , "over", "the", "lazy", "dogs", "back" };
        Node<String> root = constructTree(labels);
        printTree(root);
    }

    public static Node<String> constructTree(String... labels)
    {
        Node<String> root = new Node<>(labels[0]);
        for(int i = 1; i < labels.length; i++)
        {
            insertNode(root, new Node<>(labels[i]));
        }
        return root;
    }

    public static Node<Integer> constructTree(Integer... labels)
    {
        Node<Integer> root = new Node<>(labels[0]);
        for(int i = 1; i < labels.length; i++)
        {
            insertNode(root, new Node<>(labels[i]));
        }
        return root;
    }

    private static <T extends Comparable<T> > void insertNode(Node<T> rootNode, Node<T> newNode)
    {
        T rootLabel = rootNode.getLabel();
        T label = newNode.getLabel();

        boolean less = label.compareTo(rootLabel) < 0;

        if(less)
        {
            Node<T> leftChild = rootNode.getLeftChild();

            if(leftChild == null)
            {
                rootNode.setLeftChild(newNode);
            }
            else
            {
                insertNode(leftChild, newNode);
            }
        }
        else
        {
            Node<T> rightChild = rootNode.getRightChild();

            if(rightChild == null)
            {
                rootNode.setRightChild(newNode);
            }
            else
            {
                insertNode(rightChild, newNode);
            }
        }
    }


    public static <T extends Comparable<T>> void printTree(Node<T> root)
    {
        Deque<Node<T>> nodes = new ArrayDeque<>();
        nodes.add(root);
        printTree(nodes);
    }

    private static <T extends Comparable<T>> void printTree(Deque<Node<T>> nodes)
    {
        Node<T> next = nodes.removeFirst();
        Node<T> leftChild = next.getLeftChild();
        if (leftChild != null)
        {
            nodes.add(leftChild);
        }
        Node<T> rightChild = next.getRightChild();
        if (rightChild != null)
        {
            nodes.add(rightChild);
        }
        System.out.println(next);
        if(!nodes.isEmpty())
        {
            printTree(nodes);
        }
    }
}
