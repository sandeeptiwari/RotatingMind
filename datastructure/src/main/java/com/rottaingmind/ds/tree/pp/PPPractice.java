package com.rottaingmind.ds.tree.pp;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PPPractice {

    /**
     * Given the root of a binary tree, return all root-to-leaf paths in any order.
     *
     * A leaf is a node with no children.
     *
     * Input: root = [1,2,3,null,5]
     * Output: ["1->2->5","1->3"]
     * Example 2:
     *
     * Input: root = [1]
     * Output: ["1"]
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> pathContainers = new ArrayList<>();
        List<Integer> rootPath = new ArrayList<>();
        paths(root,  pathContainers, rootPath);
        return pathContainers.stream()
                .map(path -> path.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("->")))
                .collect(Collectors.toList());
    }

    public void paths(TreeNode root, List<List<Integer>> path, List<Integer> rootPath) {
        if (root == null) {
            return;
        }
        rootPath.add(root.val);

        if (root.left == null && root.right == null) {
            path.add(new ArrayList<>(rootPath));
        } else {
            paths(root.left, path, rootPath);
            paths(root.right, path, rootPath);
        }
        rootPath.remove(rootPath.size() - 1);
    }

    public List<String> binaryTreePathsV1(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }

    /**
     * Time Compexity Analysis
     *
     * Case Study
     * First let's work on the balanced tree situation:
     *
     * It should be obvious to see now that each node will contribute to the total time cost an amount of length of the
     * path from the root to this node. The problem is to see how to sum up these paths' lengths for N nodes altogether.
     *
     * Denote the time complexity for N nodes as T(N).
     *
     * Suppose we do have that balanced tree now (and also N is 2^N-1 for simplicity of discussion). And we know that N/2 nodes lie
     * at the leaf/deepest level of the BST since it's balanced binary tree.
     *
     * We easily have this recurrence formula:
     * T(N) = T(N/2) + (N/2) * lgN
     *
     * Which means, we have N nodes, with half lying on the deepest (the lgNth) level. The sum of path lengths for N nodes
     * equals to sum of path lengths for all nodes except those on the lgN-th level plus the sum of path lengths for those nodes on the lgN-th level.
     *
     * T(N) = O(NlgN)
     */
    public List<String> binaryTreePathsV2(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
    }
    private void helper(List<String> res, TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, root.left, sb);
            helper(res, root.right, sb);
        }
        sb.setLength(len);
    }

    //1,2,3,null,5 : ["1->2->5","1->3"]
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r5 = new TreeNode(5);

        r1.left = r2;
        r1.right = r3;

        r2.right = r5;

        PPPractice pp = new PPPractice();
        List<String> paths = pp.binaryTreePaths(r1);

        paths.forEach(ele -> System.out.print(ele + ", "));

    }
}
