package com.rottaingmind.ds.tree.pp;

public class Root {
    private int val;
    private Root left;
    private Root right;

    public Root(int val) {
        this.val = val;
    }

    public Root(int val, Root left, Root right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Root getLeft() {
        return left;
    }

    public void setLeft(Root left) {
        this.left = left;
    }

    public Root getRight() {
        return right;
    }

    public void setRight(Root right) {
        this.right = right;
    }
}