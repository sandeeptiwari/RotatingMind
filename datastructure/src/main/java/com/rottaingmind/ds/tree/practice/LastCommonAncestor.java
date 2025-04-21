package com.rottaingmind.ds.tree.practice;

import java.util.ArrayList;
import java.util.List;

/**
 *         3
 *       /   \
 *      5     1
 *     / \   / \
 *    6   2 0   8
 *       / \
 *      7   4
 */
public class LastCommonAncestor {

    public boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
        if (root == target) return true;

        if (findPath(root.left, target, path) || findPath(root.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        findPath(root, p, path1);
        findPath(root, q, path2);

        TreeNode lca = null;
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i) == path2.get(i)) {
                lca = path1.get(i);
            } else break;
        }

        return lca;
    }
}
