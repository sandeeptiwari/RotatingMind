package com.rottaingmind.ds.tree.geeksforgeek.code;

public class Node<T>
{
    private Node leftChild;
    private Node rightChild;
    private T label;

    public Node(T label)
    {
        if (label == null)
        {
            throw new IllegalArgumentException("Label must not be null");
        }
        this.label = label;
    }

    public Node<T> getLeftChild()
    {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild)
    {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild()
    {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild)
    {
        this.rightChild = rightChild;
    }

    public T getLabel()
    {
        return label;
    }

    public void setLabel(T label)
    {
        this.label = label;
    }


    @Override
    public String toString()
    {
            return super.toString() + " " + label;
    }
}
