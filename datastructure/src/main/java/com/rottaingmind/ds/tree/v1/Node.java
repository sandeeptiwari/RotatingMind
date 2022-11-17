package com.rottaingmind.ds.tree.v1;

public class Node<T>
{
    private Node leftChild;
    private Node rightChild;
    private String label;

    public Node(String label)
    {
        if (label == null)
        {
            throw new IllegalArgumentException("Label must not be null");
        }
        this.label = label;
    }

    public Node getLeftChild()
    {
        return leftChild;
    }

    public void setLeftChild(Node leftChild)
    {
        this.leftChild = leftChild;
    }

    public Node getRightChild()
    {
        return rightChild;
    }

    public void setRightChild(Node rightChild)
    {
        this.rightChild = rightChild;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }


    @Override
    public String toString()
    {
            return super.toString() + " " + label;
    }
}
