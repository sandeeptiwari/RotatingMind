package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversalDemo {

    //root-> left -> right
    private void preOrder(Node<Integer> root){
        System.out.println(root.getData());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    //left -> root -> right
    private void InOrder(Node<Integer> root){
        preOrder(root.getLeft());
        System.out.println(root.getData());
        preOrder(root.getRight());
    }

    //left -> right -> root
    private void postOrder(Node<Integer> root){
        preOrder(root.getLeft());
        preOrder(root.getRight());
        System.out.println(root.getData());
    }

    private void levelOrderTraversing(Node<Integer> root){
        Queue<Node<Integer>> queue = new LinkedList<>();
        Node<Integer> tempNode = root;

        while(tempNode != null){
            //print tempnode data
            System.out.println(tempNode.getData());
            //enqueue tempnode childs
            queue.add(tempNode.getLeft());
            queue.add(tempNode.getLeft());

            //dequeue and assign into tempnode
            tempNode = queue.poll();

        }
    }

    private void inOrderWithoutRecursion(Node<Integer> root){
        Deque<Node<Integer>> stack = new ArrayDeque<>();
        stack.push(root);
        Node<Integer> currentNode = root;

        while (currentNode != null && stack.isEmpty()){

            if(currentNode != null){
                currentNode = currentNode.getLeft();
                stack.push(currentNode);
            }else{
                Node<Integer> popedItem = stack.pop();
                System.out.println(popedItem.getData());
                currentNode = popedItem.getRight();
            }
        }
    }

}
