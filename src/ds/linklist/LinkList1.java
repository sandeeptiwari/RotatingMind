package linklist;

import java.util.HashSet;
import java.util.Set;

public class LinkList1 {

    /*private Node head = null;
    private Node last = null;
    private  int length;

    public void insertAtFront(Node data) {
        if (head == null) {
            head = data;
            last = data;
            length++;
            return;
        }

        Node temp = head;
        head = data;
        head.setNext(temp);
        length ++;
    }

    public  void insertAtEnd(Node data) {
        if (head == null) {
           head = data;
           last = data;
        }

        last.setNext(data);
    }


    public void reverse(Node curr) {

        if (curr == null) {
            return;
        }

        if (curr.getNext() == null) {
            this.head = curr;
            return;
        }

        reverse(curr.getNext());
        curr.getNext().setNext(curr);
        curr.setNext(null);
    }

    public void reverseLink() {
         Node cur = null;
         Node prev = null;
         Node next = head;
        while ( next != null) {
            cur = next;
            next = cur.getNext();
            cur.setNext(prev);
            prev = cur;
        }
        head = cur;
    }

    public Node getFirst() {
        return head;
    }


    public Node interSectionOfTwoLinkList(Node first, Node second) {
        Set<Node> firstLinkList = new HashSet<>();

        Node a = first;
        while (a != null) {
            firstLinkList.add(a);
            a = a.getNext();
        }

        Node b = second;
        while (b != null) {

            if(firstLinkList.contains(b)) {
                return b;
            }
            b = b.getNext();
        }
      return null;
    }

    @Override
    public String toString() {
        return head != null ? head.toString() : "";
    }

    public void remove(Node node) {

        if(head == null)
            return;
        Node curr = head;
        while (curr != null) {
              if(curr.getNext().equals(node)) {
                  Node toBeDelete = curr.getNext();
                  curr.setNext(toBeDelete.getNext());
                  toBeDelete.setNext(null);
                  length--;
                  break;
              }
              curr = curr.getNext();
        }
    }

    *//*
     * Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it?
     *//*

    public Node deleteByNode(Node node) {
        node.setData(node.getNext().getData());
        Node temp = node.getNext();
        node.setNext(temp.getNext());
        temp.setNext(null);
        length--;
        return temp;
    }


    public Node findSatrtNodeOfLoop() {

        Node slow = null, fast = null;
        Node startNode = null;
        boolean hasLoop = false;

        if(head == null || head.getNext() == null) {
            hasLoop =  false;
        }

        while (slow != null && fast != null) {
            slow = slow.getNext();
            fast = fast.getNext();

            if (slow == fast) {
                hasLoop = true;
            }
        }

        slow = head;

        while (slow == fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }



        return startNode;
    }

    public void insertAtPos(Node n, int position) {


        if(position < 0)
            position = 0;
        if(position > length)
            position = length;

        if(head == null){
            head = n;
        }else if(position == 0){
            n.setNext(head);
            head = n;
        }
        // else find the correct position and insert
        else {
            Node temp = head;
            for(int i = 1; i < position; i++){
                temp = temp.getNext();
            }
            Node tNext = temp.getNext();
            n.setNext(tNext);
            temp.setNext(n);
        }
        length++;
    }


    public Node reArrangeTheNode(Node root) {
        if(head == null || head.getNext() == null)
            return root;

        Node currItem = head;
        int k = 0;
        while(currItem != null) {

            if(currItem.getNext().getData() % 2 == 0) {
                Node temp = currItem.getNext();
                currItem.setNext(temp.getNext());
                temp.setNext(null);
                insertAtPos(temp, k++);
            } else {
                Node temp = currItem.getNext();
                currItem.setNext(temp.getNext());
                temp.setNext(null);
                insertAtEnd(temp);
            }
        }

        return root;
    }

    public int size() {
        return length;
    }*/
}
