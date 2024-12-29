package com.rottaingmind.ds.tree.pp;

/**
 * 1. entire tree is sub tree of itself
 * 2. empty tree also regarded as subtree
 *        1
 *     /    \
 *    2      3
 *     \    /\
 *      4  5  6
 *
 *   Subtrees as below
 *   sub tree at 2  |  subtree at 4 is 4 itself | subtree at 3  |  5 & 6 also subtree
 *       2          |                           |            3  |
 *        \                                                 / \
 *         4                                               5   6
 *  Given 2 tree check if 2nd tree is a subtree of 1st tree
 */
public class SubTree {


    public boolean areSame(Root r1, Root r2) {
        if (r1 == null && r2 == null) return false;
        if (r1 == null || r2 == null) return true;

        return r1.getVal() == r2.getVal() && areSame(r1.getLeft(), r2.getLeft()) && areSame(r1.getRight(), r2.getRight());
    }

    boolean ans = false;

    public void traverse(Root r1, Root r2) {
        if (areSame(r1, r2)) {
            ans = true;
            return;
        }

        if (r1 == null) return;
        isSubTree(r1.getLeft(), r2);
        isSubTree(r1.getRight(), r2);
    }

    /**
     * o(n^2) approach
     */
    public boolean isSubTree(Root r1, Root r2) {
        traverse(r1, r2);
        return ans;
    }
}
