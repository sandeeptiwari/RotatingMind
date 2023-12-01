package com.rottaingmind.ds.tree.v1;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreeFactory
{
    public static void main(String[] args)
    {
        String[] labels = {"quick", "brown", "fox", "jumps" , "over", "the", "lazy", "dogs", "back" };
        Node root = constructTree(labels);
        printTree(root);
    }

    public static Node constructTree(String... labels)
    {
        Node root = new Node(labels[0]);
        for(int i = 1; i < labels.length; i++)
        {
            insertNode(root, new Node(labels[i]));
        }
        return root;
    }

    private static void insertNode(Node rootNode, Node newNode)
    {
        String rootLabel = rootNode.getLabel();
        String label = newNode.getLabel();
        boolean less = label.compareTo(rootLabel) < 0;
        if(less)
        {
            Node leftChild = rootNode.getLeftChild();
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
            Node rightChild = rootNode.getRightChild();
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

    public static void printTree(Node root)
    {
        Deque<Node> nodes = new ArrayDeque<>();
        nodes.add(root);
        printTree(nodes);
    }

    private static void printTree(Deque<Node> nodes)
    {
        Node next = nodes.removeFirst();
        Node leftChild = next.getLeftChild();
        if (leftChild != null)
        {
            nodes.add(leftChild);
        }
        Node rightChild = next.getRightChild();
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
