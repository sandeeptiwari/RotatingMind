package com.rottaingmind.ds.linklist;

public class LinkList<T extends Comparable<T>> implements List<T> {
    private Node<T> root;
    private int numberOfItems;

    @Override
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            insertAtBeginning(data);
        }
        numberOfItems++;
    }

    private void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        root = newNode;
    }

    private void insertAtEnd(T data, Node<T> node) {
        if (node.getNextNode() != null) {
            insertAtEnd(data, node.getNextNode());
        } else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }
    }

    @Override
    public void remove(T data) {
        if (root == null) {
            return;
        }

        if (root.getData().compareTo(data) == 0) {
            root = root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }
    }

    private void remove(T data, Node<T> previousNode, Node<T> actualNode) {

        while (actualNode != null) {

            if (data.compareTo(actualNode.getData()) == 0) {
                numberOfItems--;
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }
            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverse() {
        Node<T> actualNode = root;

        while (actualNode != null) {
            System.out.print(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public Node<T> getMiddleNode() {
        Node<T> fastNode = root;
        Node<T> slowNode = root;

        while (fastNode.getNextNode() != null && fastNode.getNextNode().getNextNode() != null) {
            fastNode = fastNode.getNextNode().getNextNode();
            slowNode = slowNode.getNextNode();
        }
        return slowNode;
    }
   // 1 -> 2 -> 3 -> 4
    // 4 -> 3 -> 2-> 1
    @Override
    public void reverse() {
        Node<T> current = root;
        Node<T> previous = null;
        Node<T> next = null;

        while (current != null) {
            next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;
        }
        root = previous;
        //root = reverseByRecursion(root);
    }

    @Override
    public Node<T> reverseByRecursion(Node<T> root) {
        if(root == null)
            return null;

        if(root.getNextNode() == null){
            return null;
        }

        Node<T> secElement = root.getNextNode();

        root.setNextNode(null);

        Node<T> reverseNode  = reverseByRecursion(secElement);

        secElement.setNextNode(root);

        return reverseNode;
    }

    @Override
    public int size() {
        return numberOfItems;
    }

    @Override
    public Node<T> getHead() {
        return root;
    };
}
