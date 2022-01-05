package com.rottaingmind.ds.linklist;
//3 -> 2 -> 1
// 3 -> 2 -> 1
//
public class LinkListPractice1 {

    public static void main(String[] args) {
        LinkList<Integer> ll1 = new LinkList();
        LinkList<Integer> ll2 = new LinkList();
        ll1.insert(1);
        ll1.insert(2);
        ll1.insert(3);

        ll2.insert(1);
        ll2.insert(2);
        ll2.insert(3);
        int num1 = 0;
        int num2 = 0;
        int result = 0;
        int i = 0;
        Node<Integer> head1 = ll1.size() >= ll2.size() ? ll1.getHead() : ll2.getHead();
        Node<Integer> head2 = ll1.size() >= ll2.size() ? ll2.getHead() : ll1.getHead();
        int size = Math.max(ll1.size(), ll2.size());
        while(head1 != null) {
            num1 = head1.getData() != null ? head1.getData() : 0;
            num2 = head2.getData() != null ? head2.getData() : 0;
            result += (num2 + num1) * (int)Math.pow(10, (size - 1) - i);
            i++;
            head1 = head1.getNextNode();
            head2 = head2.getNextNode();
        }

        System.out.println("result -> " + reverseTheNumber(result));
    }
   //642
    private static int reverseTheNumber(int num) {
        int rem = 0;
        int sum = 0;
        while (num != 0) {
            rem = num % 10;
            sum = sum * 10 + rem;
            num = num / 10;
        }
        return sum;
    }
}
