package com.rottaingmind.ds.queue;

import java.util.Stack;
public class QueueWithStackOps {
    // use one stack for enqueue operation
    private Stack<Integer> enqueueStack;

    // use one stack for dequeue operation
    private Stack<Integer> dequeueStack;

    public QueueWithStackOps() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }

    public void enQueue(Integer data) {
        enqueueStack.push(data);
    }

    public Integer dequeue() {
        if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
            return -1;
        }

        /* If the second stack is not empty, popping and returning from it.
         Otherwise, we pop each and every element from the first stack and push into the second stack. */
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        return dequeueStack.pop();
    }


    public Node<Integer> implementingQueue(Node<Integer> op) {
        QueueWithStackOps stk1 = new QueueWithStackOps();
        QueueWithStackOps stk2 = new QueueWithStackOps();
        Node<Integer> root = null;
        Node<Integer> last = null;

        while (op != null) {

            if (op.getData() >= 0) {
                stk1.enQueue(op.getData());
            } else {
                last = makeAnswerList(root, last, dequeue());
                if (root == null) {
                    root = last;
                }
            }
            op = op.getNextNode();
        }
        return root;
    }

    public Node<Integer> makeAnswerList(Node<Integer> root, Node<Integer> last, int value) {
        if (root == null)
        {
            root = new Node<>(value);
            last = root;
        }else        {
            Node<Integer> node = new Node<>(value);
            last.setNextNode(node);
            last = last.getNextNode();
        }
        return last;
    }
}
