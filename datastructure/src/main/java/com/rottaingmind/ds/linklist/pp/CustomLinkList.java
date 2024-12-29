package com.rottaingmind.ds.linklist.pp;

import com.rottaingmind.ds.linklist.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CustomLinkList {
    private Node<Integer> head;
    private Node<Integer> tail;

    public CustomLinkList() {
        head = null;
        tail = null;
    }

    public Node<Integer> insertAtHead(int data) {
        Node<Integer> newNode = new Node<>(data);
        if (head == null) {
            tail = newNode;
            return newNode;
        }
        newNode.setNextNode(head);
        head = newNode;
        return head;
    }

    public Node<Integer> insertAtTail(int data) {
        Node<Integer> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return newNode;
        }
        Node<Integer> current = head;
        while (current.getNextNode() != null) {
            current = current.getNextNode();
        }
        current.setNextNode(newNode);
        tail = newNode;
        return tail;
    }

    public void insertAtIndex(int index, int data) {
        Node<Integer> newNode = new Node<>(data);
        if (index == 1) {
            newNode.setNextNode(head);
            head = newNode;
            return;
        }

        Node<Integer> current = head;
        for (int i = 0; i < index - 2; i++) {
            current = current.getNextNode();
        }

        newNode.setNextNode(current.getNextNode());
    }


    public void traverse(Node<Integer> root) {
        Node<Integer> currentNode = root; // never traverse using head
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNextNode();
        }
    }

    public void delete(int data) {
        Node<Integer> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData() == data) {
                if (currentNode.getNextNode() != null) {
                    currentNode.getNextNode().setNextNode(currentNode.getNextNode().getNextNode());
                } else {
                    currentNode.setNextNode(null);
                }
            }

            currentNode = currentNode.getNextNode().getNextNode();
        }
    }

    public void deleteAtIndex(int index) {
        Node<Integer> currentNode = head;

        if (index == 1) {
            Node<Integer> newNode = currentNode.getNextNode();
            currentNode.setNextNode(null);
            head = newNode;
        }

        for (int i = 0; i < index - 2; i++) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(currentNode.getNextNode().getNextNode());
    }


    /**
     *  n = 3 means 3rd node from the end
     *
     *  to delete nth node from end we have to take 2 pointer
     *  1st will start from head and second will start from nth node from start
     *  e.g.
     *  5->1->2->1->3->9
     *  n = 4
     * 5->1->2->1->3->9  i = 0
     * p1       p2
     *   p1       p2     i = 1
     *      p1       p2  i = 2
     *
     * where p2 reached end p1 will reach n hops away from end which is the node, we have to delete
     *
     */
    public Node<Integer> deleteNthNodeFromEnd(int n) {
       Node<Integer> p1 = head;
        Node<Integer> p2 = head;
       for (int i = 0; i < n; i++) {
          p2 = p2.getNextNode();
       }

        if (p2 == null) {
            Node<Integer> tmp = head.getNextNode();
            head = tmp;
            return head;
        }

       while (p2.getNextNode() != null) {
           p1 = p1.getNextNode();
           p2 = p2.getNextNode();
       }


       Node<Integer> newNode = p1.getNextNode();
       p1.setNextNode(p1.getNextNode().getNextNode());
       newNode = null;
       return head;
    }



    public Node<Integer> search(int key) {
        Node<Integer> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData() == key) {
                return currentNode;
            }
        }
        return null;
    }


    /**
     * middle node
     * for even number of node we would have 2 middle node whereas  for odd single middle node
     *
     * if entire len n then n/2 hops needed
     *
     * But 2 pass algorithm
     *
     *
      */

    public Node<Integer> findMiddleNode() {
        int cnt = 0;
        Node<Integer> currentNode = head;

        while (currentNode != null) {
            cnt++;
            currentNode = currentNode.getNextNode();
        }

        currentNode = head;
        int cnt2 = 0;
        while (cnt2 < cnt / 2) {
            currentNode = currentNode.getNextNode();
            cnt2++;
        }
        return currentNode;
    }

    public Node<Integer> findMiddleNodeV1() {
        Node<Integer> slow = head;
        Node<Integer> fast = head.getNextNode();

        while (fast != null && fast.getNextNode() != null) {
            fast = fast.getNextNode().getNextNode();
            slow = slow.getNextNode();
        }

        return slow;
    }


    public void reverse() {
        Node<Integer> current = head;
        Node<Integer> previous = null;
        Node<Integer> next = null;

        while (current != null) {
            next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    private Node<Integer> h = null;
    public Node<Integer> reverseV1(Node<Integer> root) {
        if(root == null)
            return h;

        if (root.getNextNode() == null) {
            h = root;
            return h;
        }

        Node<Integer> secondNode = root.getNextNode();
        root.setNextNode(null);
        reverseV1(secondNode);
        secondNode.setNextNode(root);
        return h;
    }

    public Node<Integer> gethead() {
        return head;
    }


    /**
     *  Given a linked list every Node contains value between [0...9], check if its a palindrome or not
     *  Note: we can use stack as well to check palindrome
     *   1- we pushed all linkedlist node into stack and again travers stack and match with one by one linked list node
     *
     *   TC = o(n)
     *   space c = o(1)
     */

    public boolean isPalindrome() {
        Node<Integer> mid = findMiddleNode();
        Node<Integer> t = reverseV1(mid);
        Node<Integer> h = head;
        while (h != null && t != null) {
            if (!Objects.equals(h.getData(), t.getData())) {
                return false;
            }
            h = h.getNextNode();
            t = t.getNextNode();
        }
        return true;
    }

    /**
     * K -reverse linked list mean k chunk reverse and maintain linking as well
     */

    public Node<Integer> kReverse(Node<Integer> root, int k) {
        int cnt = 0;
        Node<Integer> current = root;
        while (current != null && cnt < k) {
            cnt++;
            current = current.getNextNode();
        }
        if (cnt < k) {
            return root;
        }


        current = root;
        Node<Integer> next = null;
        Node<Integer> previous = null;
        cnt = 0;
        while (current != null && cnt < k) {
            next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;
            cnt++;
        }
        root.setNextNode(kReverse(current, k));
        return previous;
    }

    /**
     * Find cycle in linkedlist
     *
     * build a Map key would Memory address and if key will duplicate means duplicate exist
     *
     * space c = o(n)
     * TC = o(n)
     */

    public boolean isCycleDependency(Node<Integer> root) {
        Map<Integer, Integer> map = new HashMap<>();
        while (root != null) {
            System.out.println("data " + root.getData() + " hash " + root.hashCode());
            if (map.getOrDefault(root.hashCode(), 0) > 0) {
                return true;
            }
            map.put(root.hashCode(), map.getOrDefault(root.hashCode(), 0) + 1);
            root = root.getNextNode();
        }
        return false;
    }

    public boolean isCycleDependencyV1(Node<Integer> root) {
        Node<Integer> fast = root;
        Node<Integer> slow = root;

        while (fast != null && fast.getNextNode() != null) {
           slow = slow.getNextNode();
           fast = fast.getNextNode().getNextNode();
           if (slow == fast) {
               return true;
           }
        }
        return false;
    }

    public Node<Integer> firstNodeInLoop(Node<Integer> root) {
        Node<Integer> current = root;
        Node<Integer> fast = root;
        Node<Integer> slow = root;
        boolean hasLoop = false;


        while (slow != null && fast != null && fast.getNextNode() != null) {
            slow = slow.getNextNode();
            fast = fast.getNextNode().getNextNode();
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }

        if (!hasLoop) {
            return null;
        }

        while (true) {
            Node<Integer> start = slow;
            while (start != current) {
                start = start.getNextNode();
                if (start == slow) {
                    break;
                }
            }
            if (start == current) {
                return current;
            }
            current = current.getNextNode();
        }

    }

    public Node<Integer> firstNodeInLoopV1(Node<Integer> root) {
        return null;
        /**
         * int intersectPoint(Node* head1, Node* head2)
         *
         * {
         *
         *     Node * a=head1;
         *
         *     Node *b= head2;
         *
         *     int z1=0,z2=0;
         *
         *     // Your Code Here
         *
         *     while(a!=b){
         *
         *         if(z1>2 && z2>2)
         *
         *         return 0;
         *
         * a=a->next;
         *
         * b=b->next;
         *
         * if(!a){
         *
         * a=head1;
         *
         * z1++;}
         *
         * if(!b){
         *
         *      b=head2;
         *
         *      z2++;}
         *
         *     }
         *
         *     return a->data;
         *
         * }
         */
    }


    public Node<Integer> merge2SortedLinkedList(Node<Integer> h1, Node<Integer> h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        Node<Integer> p1 = h1;
        Node<Integer> p2 = h2;
        Node<Integer> h, t;
        if (h1.getData() < h2.getData()) {
            h = h1; t = h1;
            p1 = p1.getNextNode();
        } else {
            h = h2; t = h2;
            p2 = p2.getNextNode();
        }

        while (p1 != null && p2 != null) {

            if (p1.getData() < p2.getData()) {
                t.setNextNode(p1);
                p1 = p1.getNextNode();
            } else {
                t.setNextNode(p2);
                p2 = p2.getNextNode();
            }

            t = t.getNextNode();
        }

        if (p1 != null) {
            t.setNextNode(p1);
        } else  {
            t.setNextNode(p2);
        }

       return h;
    }

    public Node<Integer> merge2SortedLinkedListRecursively(Node<Integer> h1, Node<Integer> h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }

        Node<Integer> t = null;

        if (h1.getData() <= h2.getData()) {
            h = h1;
            t = h1.getNextNode();//optional
            h1.setNextNode(null);//optional
            var curHead = merge2SortedLinkedListRecursively(t, h2);
            h.setNextNode(curHead);

        } else {
            h = h2;
            t = h2.getNextNode();//optional
            h2.setNextNode(null);//optional
            var curHead = merge2SortedLinkedListRecursively(h1, t);
            h.setNextNode(curHead);
        }

      return h;

    }

    public Node<Integer> mergeKSortedLinkedList(Node<Integer> ... h) {
        // loop h and sort 2 at a time o(n * k^2)
        /**
         *     vector<int> merge(vector<int>& v1, vector<int>& v2){
         *         int n=v1.size();
         *         vector<int> tmp;
         *         int i=0,j=0;
         *         while(i<n and j<n){
         *             if(v1[i]<v2[j]) tmp.push_back(v1[i++]);
         *             else tmp.push_back(v2[j++]);
         *         }
         *         while(i<n) tmp.push_back(v1[i++]);
         *         while(j<n) tmp.push_back(v2[j++]);
         *         return tmp;
         *     }
         *
         *
         *     vector<int> f(vector<vector<int>> &ma, int l ,int h){
         *         if(l==h) return ma[l];
         *         int m=(l+h)/2;
         *         vector<int> v1=f(ma,l,m);
         *         vector<int> v2=f(ma,m+1,h);
         *         return merge(v1,v2);
         *     }
         *
         *     public:
         *     vector<int> mergeKArrays(vector<vector<int>> ma, int n){
         *         return f(ma,0,n-1);
         *     }
         */

        return null;
    }

    /**
     * Given a linked list special Node, which has a random pointer together to next node
     * We have to clone that linkedList
     */
    public Node<Integer> cloneLinkedList(Node<Integer>  h) {
        Map<Node<Integer>, Node<Integer>> cloneAddressByAddress = new HashMap<>();
        Node<Integer> cloneHead = null;
        Node<Integer> prev = null;
        Node<Integer> tmp = null;
        Node<Integer> current = h;

        //part 1
        while (current != null) {
            tmp = new Node<>(current.getData());
            cloneAddressByAddress.put(current, tmp);

            if (prev == null) {
                cloneHead = tmp;
                prev = tmp;
            } else {
                prev.setNextNode(tmp);
                prev = tmp;
            }
            current = current.getNextNode();
        }

        //part 2
        Node<Integer> curr1 = h;
        Node<Integer> curr2 = cloneHead;

        while (curr2 != null) {

            if (curr1.getRandom() != null) {
                curr2.setRandom(cloneAddressByAddress.get(curr1.getRandom()));
            } else {
                curr2.setRandom(null);
            }
            curr1 = curr1.getNextNode();
            curr2 = curr2.getNextNode();
        }

        return cloneHead;
    }

    public Node<Integer> cloneLinkedListV1(Node<Integer>  h) {
        Node<Integer> cloneHead = null;
        Node<Integer> tmp = null;
        Node<Integer> current = h;

        //part -1 :: join real node and clone node together
        while (current != null) {
            tmp = new Node<>(current.getData());
            if (current == h) {
                cloneHead = tmp;
            }
            Node<Integer> t = current.getNextNode();
            current.setNextNode(tmp);
            tmp.setNextNode(t);
            current = t;
        }

        //part -2 :: join as real random node in clone node random node

        Node<Integer> curr = h;

        while (curr != null) {
            if (curr.getRandom() != null) {
                curr.getNextNode().setRandom(curr.getRandom().getNextNode());
            } else {
                curr.getNextNode().setRandom(null);
            }
            curr = curr.getNextNode().getNextNode();
        }

        //part -3 :: dis-join as original & clone
        curr = cloneHead;
        Node<Integer> curr1 = h;

        while (curr != null && curr.getNextNode() != null) {
            Node<Integer> t = curr.getNextNode();
            curr.setNextNode(curr.getNextNode().getNextNode());
            curr = curr.getNextNode();
            curr1.setNextNode(t);
            curr1 = curr1.getNextNode();
        }
        if (curr != null) {
            curr.setNextNode(null);
        }

        return cloneHead;
    }

    /**
     * flatten linked list
     *  class Node {
     *      Node next;
     *      Node down;//can point head of any other linkedlist and also it can be null
     *  }
     *
     *    5 -> 1 -> 2 -> 4 -> 11 -> 3
     *              |               |
     *              3 -> 4-> 5      9
     *                              |
     *                              8
     */

    public Node<Integer> flattenList(Node<Integer> h) {
        Node<Integer> temp = null;
        Node<Integer> downHead = null;
        Node<Integer> current = h;
        while (current != null) {
            if (current.getDown() != null) {
                temp = current.getNextNode();
                current.setNextNode(current.getDown());
                downHead = current.getDown();

                while (downHead.getNextNode() != null) {
                    downHead = downHead.getNextNode();
                }
                downHead.setNextNode(temp);
                current.setDown(null);
            }
            current = current.getNextNode();
        }

        return  h;
    }


    /**
     * Doubly linkedlist
     */

}
