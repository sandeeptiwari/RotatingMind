package com.rottaingmind.ds.trie;

public class Node {

    private int numOfSubTree;
    private final Node[] childrens;
    private boolean isEnd;

    public Node() {
        this.childrens = new Node[26];
    }

    public void setNumOfSubTree(int numOfSubTree) {
        this.numOfSubTree = numOfSubTree;
    }

    public int getNumOfSubTree() {
        return numOfSubTree;
    }

    public Node[] getChildrens() {
        return childrens;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
