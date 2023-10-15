package com.rottaingmind.application.linklist;

import com.rottaingmind.ds.linklist.LinkList;
import com.rottaingmind.ds.linklist.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLinkList {

    @Test
    public void testFindMiddleNode() {
        LinkList<Integer> linkList = new LinkList<>();
        linkList.insertAtEnd(10);
        linkList.insertAtEnd(20);
        linkList.insertAtEnd(30);
        linkList.insertAtEnd(40);
        Node<Integer> actualNode = linkList.getMiddleNode();
        Assertions.assertEquals(30, actualNode.getData());
    }

    @Test
    public void testFindOddMiddleNode() {
        LinkList<Integer> linkList = new LinkList<>();
        linkList.insertAtEnd(10);
        linkList.insertAtEnd(20);
        linkList.insertAtEnd(30);
        linkList.insertAtEnd(40);
        linkList.insertAtEnd(50);
        Node<Integer> actualNode = linkList.getMiddleNode();
        Assertions.assertEquals(40, actualNode.getData());
    }
}
