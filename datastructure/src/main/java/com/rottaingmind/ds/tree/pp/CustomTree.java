package com.rottaingmind.ds.tree.pp;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomTree {

    // root + #LST + #RST = o(n) , space complexity = size of call stack
    //hight of tree = SP = O(height of tree)
    public int countTotalNodeOfGivenBinaryTree(Root root) {
        if (root == null) {
            return 0; // count of empty tree is zero
        }

        return 1 + countTotalNodeOfGivenBinaryTree(root.getLeft())
                + countTotalNodeOfGivenBinaryTree(root.getRight());
    }


    public int countLeavesNodeOfGivenBinaryTree(Root root) {
        if (root == null) return 0;

        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }

        return countLeavesNodeOfGivenBinaryTree(root.getRight()) +
                countLeavesNodeOfGivenBinaryTree(root.getLeft());
    }


    /**
     * Mirror perform something called lateral inversion which makes that left appears in right and right
     * appears in left
     */
    public Root mirrorImageOfGivenBT(Root root) {
        if (root == null) {
            return null;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return root;
        }

        Root tmp = mirrorImageOfGivenBT(root.getLeft());
        Root tmp1 = mirrorImageOfGivenBT(root.getRight());

        root.setLeft(tmp1);
        root.setRight(tmp);

        return root;
    }

    public void mirrorImageOfGivenBTV1(Root root) {
        if (root == null) {
            return;
        }

        Root tmp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tmp);

        mirrorImageOfGivenBTV1(root.getLeft());
        mirrorImageOfGivenBTV1(root.getRight());
    }


    /**
     * Given a BT, Check if it's symmetric OR not
     * Mirror image right subtree of left subtree
     */
    public boolean isSymmetricBTTree(Root root) {
        if (root == null) {
            return true;
        }
        Root mirror = mirrorImageOfGivenBT(root.getLeft());

        return isSymmetric(root.getRight(), mirror);
    }

    private boolean isSymmetric(Root root, Root mirror) {
        List<Integer> mirrorNodes = new ArrayList<>();
        List<Integer> rbstNodes = new ArrayList<>();

        traverse(mirror, mirrorNodes);
        traverse(root, rbstNodes);

        if (mirrorNodes.size() != rbstNodes.size()) {
            return false;
        }
        for (int i = 0; i < mirrorNodes.size(); i++) {
            if (mirrorNodes.get(i) != rbstNodes.get(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * r1.val == r2.val
     * TC = o(n)
     * SC = o(n)
     */
    public boolean isSymmetricBTTreeV1(Root r1) {
        if (r1 == null) {
            return true;
        }
        return areMirrorImage(r1.getLeft(), r1.getRight());
    }

    public boolean areMirrorImage(Root r1, Root r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }

        return r1.getVal() == r2.getVal() && isSymmetric(r1.getLeft(), r2.getRight())
                && isSymmetric(r1.getRight(), r2.getLeft());
    }

    public void traverse(Root root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root.getVal());
        traverse(root.getLeft(), nodes);
        traverse(root.getRight(), nodes);
    }

    public void traverse(Root root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getVal() + ", ");
        traverse(root.getLeft());
        traverse(root.getRight());
    }

    public static void main1(String[] args) {
        Root r1 = new Root(4);
        Root r2 = new Root(5);
        Root r3 = new Root(1);
        Root r4 = new Root(9);
        Root r5 = new Root(6);
        Root r6 = new Root(7);


        r1.setLeft(r2);
        r1.setRight(r3);

        r2.setLeft(r4);
        r2.setRight(r5);

        r3.setLeft(r6);

        CustomTree t = new CustomTree();
        //Root res = t.mirrorImageOfGivenBT(r1); //4, 1, 7, 5, 6, 9,
        t.mirrorImageOfGivenBTV1(r1);// 4, 1, 7, 5, 6, 9,

        t.traverse(r1);
    }

    /**
     * Given BT, We need to find out hight of that tree
     * hight = max len of root to leaf node (# of nodes)
     * <p>
     * SC = o(height)
     */

    public int getHeight(Root root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
    }

    public void getMaxHeight(Root root, int l, int ans) {
        if (root == null) {
            return;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            ans = Math.max(ans, l);
            return;
        }
        getMaxHeight(root.getLeft(), l + 1, ans);
        getMaxHeight(root.getRight(), l + 1, ans);
    }


    /**
     * Smallest to root to leaf path
     */
    public int findMinHeight(Root root) {
        if (root == null) {
            return 0;
        }
        return getMinHeight(root);
    }

    public int getMinHeight(Root root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }

        return 1 + Math.min(getMinHeight(root.getLeft()), getMinHeight(root.getRight()));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }


    /**
     * I am thinking this for a general binary tree where, where binary tree can be anything (like skewd. half filled, cuompletely filled, etc ).
     * <p>
     * N -> Number of Nodes in Binary Tree
     * <p>
     * H -> max height of the binary tree
     * <p>
     * n -> no of leaf nodes
     * <p>
     * Time Complexities : O(N + n*H) , as we are traversing through all nodes, and only on leaf nodes we are doing the extra work of printing which can print at most H elements.
     * <p>
     * Space Complexities : O(2H) ~ O(H) , as we are only storing element along a path, which can be at most H elements for any leaf node.
     *
     * @param root
     */
    public void printAllTheRootToLeafPaths(Root root) {
        if (root == null) {
            return;
        }
        List<Integer> l = new ArrayList<>();
        l.add(root.getVal());
        paths(root, l);
    }


    public void paths(Root root, List<Integer> l) {
        if (root == null) {
            return;
        }

        int v = root.getVal();
        l.add(v);//redo

        if (root.getLeft() == null && root.getRight() == null) {
            l.stream().forEach(ele -> System.out.println(ele + ", "));
        } else {
            paths(root.getLeft(), l);
            paths(root.getRight(), l);
        }
        l.remove(v); // undo
    }

    /**
     * Given a BT find the diameter
     * diameter of BT is longest path between any 2 node
     * <p>
     * diaqmeter = 1 + ht(LST) + ht(RST) is not correct diameter not necessary to pass root node every time
     * <p>
     * 2. Some path taking turn about a particular node
     * <p>
     * Diameter can pass with below 3 option:
     * 1. passes through root
     * OR
     * 2. entirly contains in left sub tree
     * OR
     * 3. entirly contains in right sub tree
     * <p>
     * dia = max (d1, d2, 1 + h1 + h2)
     * <p>
     * TC = o(n^2) if tree is skewed one
     * <p>
     * 4 - o(n-1) : getHight call for n nodes
     * /
     * 5 - o(n-2)
     * /
     * 3
     * <p>
     * can we do just one getHeight call, is this possible
     */

    public int findDiameter(Root root) {
        if (root == null) {
            return 0;
        }

        int h1 = getHeight(root.getLeft()); //o(n)
        int h2 = getHeight(root.getRight());//o(n)

        return Math.max(
                Math.max(
                        (1 + h1 + h2),
                        findDiameter(root.getLeft())
                ),
                findDiameter(root.getRight())
        );
    }


    public int getHeightWithHightOfEachNode(Root root, Map<Root, Integer> hightOfEachNode) {
        if (root == null) {
            return 0;
        }

        int hight = 1 + Math.max(getHeightWithHightOfEachNode(root.getLeft(), hightOfEachNode), getHeightWithHightOfEachNode(root.getRight(), hightOfEachNode));
        hightOfEachNode.put(root, hight);
        return hight;
    }


    /**
     * TC = o(n)
     * SC = o(n)
     * is really needed Map
     */
    public int getDiameter(Root root) {
        Map<Root, Integer> hightOfEachNode = new HashMap<>();
        int heightWithHightOfEachNode = getHeightWithHightOfEachNode(root, hightOfEachNode);
        return getDiameter(root, hightOfEachNode);
    }

    public int getDiameter(Root root, Map<Root, Integer> hightOfEachNode) {
        if (root == null) {
            return 0;
        }

        int h1 = hightOfEachNode.get(root.getLeft()); //o(1)
        int h2 = hightOfEachNode.get(root.getRight()); //o(1)

        return Math.max(
                Math.max(
                        (1 + h1 + h2),
                        findDiameter(root.getLeft())
                ),
                findDiameter(root.getRight())
        );
    }

    int answer = 0;

    public int getHeightWithInPlaceHightOfEachNode(Root root) {
        if (root == null) {
            return 0;
        }

        int lh = getHeightWithInPlaceHightOfEachNode(root.getLeft());
        int rh = getHeightWithInPlaceHightOfEachNode(root.getRight());

        answer = Math.max(answer, 1 + lh + rh);

        return 1 + Math.max(lh, rh);
    }

    public int getDiameterV1(Root root) {
        if (root == null) {
            return 0;
        }

        return Math.max(
                Math.max(
                        answer,
                        findDiameter(root.getLeft())
                ),
                findDiameter(root.getRight())
        );
    }

    record Pair(int h, int dia) {
    }


    /**
     * Most important
     *
     * @param root
     * @return
     */
    public Pair getDiameterAndHeight(Root root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair lst = getDiameterAndHeight(root.getLeft());
        Pair rst = getDiameterAndHeight(root.getRight());

        int h = 1 + Math.max(lst.h, rst.h); // height of sub tree
        int dia = Math.max(1 + lst.h + rst.h, Math.max(lst.dia, rst.dia));

        return new Pair(h, dia);
    }

    /**
     * Given a BT: check if it is height Balanced in which
     * Left & right subtree must not differ by more than 1 unit in height
     * <p>
     * | ht(LST) - ht(RST) | <= 1
     */
    boolean isHeightBalanced = true;

    public int isHeightBalanced(Root root) {
        if (root == null) {
            return 0;
        }

        int lh = isHeightBalanced(root.getLeft());
        int rh = isHeightBalanced(root.getLeft());

        int heightDiff = Math.abs(lh - rh);

        if (heightDiff > 1) {
            isHeightBalanced = false;
        }

        return 1 + Math.max(lh, rh);
    }

    record BalancedPair(boolean isBalanced, int height) {}
    /**
     *  Solve above problem by balanced height, sub tree return
     *  itself is balanced or not
     *
     *  -> empty tree is always height balanced
     */
    public BalancedPair getIsBalancedAndHeight(Root root) {
        if (root == null) {
            return new BalancedPair(true, 0);
        }

        BalancedPair lst = getIsBalancedAndHeight(root.getLeft());// call only once for every node = TC = o(n)
        BalancedPair rst = getIsBalancedAndHeight(root.getRight());

        int h = 1 + Math.max(lst.height, rst.height);
        boolean isBalanced = lst.isBalanced && rst.isBalanced && (Math.abs(lst.height - rst.height) <= 1);

        return new BalancedPair(isBalanced, h);

    }


    record SubTreeSumPair(int ans, int uniquePath) {}

    /**
     * Given a BT need to find out of max sum path & path must be not empty
     */

    public SubTreeSumPair getMaxSumOfPath(Root root) {

        if (root == null) {
            return new SubTreeSumPair(Integer.MIN_VALUE, 0);
        }

        SubTreeSumPair lst = getMaxSumOfPath(root.getLeft());
        SubTreeSumPair rst = getMaxSumOfPath(root.getLeft());

        // max sum path passes through this given root
        int lstUniquePath = Math.max(lst.uniquePath, 0);
        int rstUniquePath = Math.max(rst.uniquePath, 0);
        int maxSumPath = Math.max(root.getVal() + lstUniquePath + rstUniquePath,
                Math.max(lst.ans, rst.ans));

        int maxUniquePath = Math.max(0, root.getVal() + Math.max(lstUniquePath, rstUniquePath));

        return new SubTreeSumPair(maxSumPath, maxUniquePath);
    }


    /**Given a BT, convert it into a doubly ended LinkedList
     *  At a node:
     *      1- p1 = DLL(node.left)
     *      2- p1 = DLL(node.right)
     *      node.left = p1.tail
     *      node.right = p2.head
     *      p1.tail.right = node
     *      p2.head.left = node
     *
     *
     *      TC = o(n)
     *      SC = o(h)
     *
     * **/

    class DLPair {
        public Root head;
        public Root tail;

        DLPair(Root head, Root tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public DLPair convertIntoDoublyEndedQueue(Root root) {
        if (root == null) {
            return new DLPair(null, null);
        }

        DLPair p1 = convertIntoDoublyEndedQueue(root.getLeft());
        DLPair p2 = convertIntoDoublyEndedQueue(root.getRight());

        Root head = root;
        Root tail = root;

        root.setLeft(p1.tail);

        if (p1.tail != null) {
            p1.tail.setRight(root);
            head = p1.head;
        }

        root.setRight(p2.head);

        if (p2.head != null) {
            p2.head.setLeft(root);
            tail = p2.tail;
        }

        return new DLPair(head, tail);
    }

    /**
     *  Given integer N, Generate all the structuraly diff BT having N nodes
     */

    public List<Root> allPossibleBT(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<Root> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Root> lsts = allPossibleBT(i);
            List<Root> rsts = allPossibleBT(n-i-1);

            for (int j = 0; j < lsts.size(); j++) {
                for (int k = 0; k < rsts.size(); k++) {
                    Root r = new Root(0);
                    r.setLeft(lsts.get(j));
                    r.setLeft(rsts.get(k));
                    result.add(r);
                }
            }
        }
        return result;
    }

    public List<TreeNode> allPossibleFBT(int n) {

        if (n%2 == 0) return new ArrayList<>();

        HashMap<Integer, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> temp = new ArrayList<>();
        temp.add(new TreeNode(0));
        map.put(1, temp);

        for (int i = 3; i <= n; i= i + 2){
            temp = new ArrayList<>();
            for (int k = 1; k < i-1; k=k+2){
                List<TreeNode> lst = map.get(k);
                List<TreeNode> rst = map.get(i - 1 - k);

                for (TreeNode left : lst) {
                    for (TreeNode right : rst) {
                        temp.add(new TreeNode(0, left, right));
                    }
                }
            }

            map.put(i, temp);
        }

        return map.get(n);
    }



    public static void main(String[] args) {
        Root r1 = new Root(1);
        Root r2 = new Root(2);
        Root r3 = new Root(2);

        Root r4 = new Root(3);
        Root r5 = new Root(4);

        Root r6 = new Root(4);
        Root r7 = new Root(3);

        Root r8 = new Root(9);

        Root r9 = new Root(10);
        Root r10 = new Root(5);

        Root r11 = new Root(5);
        Root r12 = new Root(10);

        Root r13 = new Root(9);


        r1.setLeft(r2);
        r1.setRight(r3);

        r2.setLeft(r4);
        r2.setRight(r5);

        r3.setLeft(r6);
        r3.setRight(r7);

        r4.setLeft(r8);

        r5.setLeft(r9);
        r5.setRight(r10);

        r6.setLeft(r11);
        r6.setRight(r12);

        r7.setLeft(r13);

        CustomTree t = new CustomTree();
        //Root res = t.mirrorImageOfGivenBT(r1); //4, 1, 7, 5, 6, 9,
        boolean symmetricBTTree = t.isSymmetricBTTree(r1);// 4, 1, 7, 5, 6, 9,

        System.out.println(symmetricBTTree);
    }
}
