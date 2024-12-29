package com.rottaingmind.ds.tree.pp;

import com.rottaingmind.ds.tree.TreeFactory;

import javax.swing.plaf.ButtonUI;
import java.util.*;

public class TreeTraversal {

    /**
     * 1- preorder
     * root -> left -> right
     * 2- postorder
     * right -> root -> left
     *
     * 3- Inorder
     *
     * left -> root -> right
     *
     */

    List<Integer> preorderTraversal(Root root) {
        List<Integer> v = new ArrayList<>();
        Stack<Root> st = new Stack<>();
        st.push(root);
        while(!st.empty()){
            Root node = st.pop();
             v.add(node.getVal());

            if(node.getRight() != null) st.push(node.getRight());
            if(node.getLeft() != null) st.push(node.getLeft());
        }
        return v;
    }

    record Pair(Root root, boolean isFirstOccur){}

    //we are touching any node constant number of time so TC = o(n)
    //SC = o(h)
    List<Integer> postOrderTraversal(Root root) {
        List<Integer> v = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, true));

        while(!st.empty()) {
            Pair p = st.pop();
            if (p.isFirstOccur) {
                st.push(new Pair(p.root, false));
                if(p.root.getRight() != null) st.push(new Pair(p.root.getRight(), true));
                if(p.root.getLeft() != null) st.push(new Pair(p.root.getLeft(), true));
            } else {
                v.add(p.root.getVal());
            }
        }
        return v;
    }


    //left -> root -> right
    List<Integer> inOrderTraversal(Root root) {
        List<Integer> v = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, true));

        while(!st.empty()) {
            Pair p = st.pop();
            if (p.isFirstOccur) {
                if(p.root.getRight() != null) st.push(new Pair(p.root.getRight(), true));
                st.push(new Pair(p.root, false));
                if(p.root.getLeft() != null) st.push(new Pair(p.root.getLeft(), true));
            } else {
                v.add(p.root.getVal());
            }
        }
        return v;
    }

    // last node of root->left->left->...-> null
    // here each node touched max 1 time so TC = o(n)
    //SC= o(h)
    List<Integer> inOrderTraversalWithFlag(Root root) {
        List<Integer> v = new ArrayList<>();
        Stack<Root> st = new Stack<>();
        st.push(root);
        Root temp = root;

        while (temp != null) {
            temp = temp.getLeft();
            st.push(temp);
        }

        while (!st.empty()) {
            Root node = st.pop();
            v.add(node.getVal());

            Root rr = node.getRight();
            while (rr != null) {
                st.push(rr);
                rr = rr.getLeft();
            }
        }

        return v;
    }

    /**
     * Level order traversal
     * TC = we are touching any node 2  push and then pop same node so its o(2*n) = o(n)
     * SC = o(width of the tree on specific level )
     */

    List<Integer> levelOrderTraversal(Root root) {
        Queue<Root> q = new ArrayDeque<>();
        List<Integer> v = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Root node = q.poll();
            v.add(node.getVal());
            if (node.getLeft() != null) q.add(node.getLeft());
            if (node.getRight() != null) q.add(node.getRight());
        }
        return v;
    }

    /**
     * Level order traversal
     * TC = we are touching any node 2  push and then pop same node so its o(2*n) = o(n)
     * SC = o(width of the tree on specific level )
     * print next level in next line
     */
    record Level(Root root, int level) {}
    List<Level> levelOrderTraversalPretty(Root root) {
        Queue<Level> q = new ArrayDeque<>();
        List<Level> v = new ArrayList<>();
        q.add(new Level(root, 1));
        while (!q.isEmpty()) {
            Level l = q.poll();
            v.add(l);
            if (l.root.getLeft() != null) q.add(new Level(l.root.getLeft(), l.level + 1));
            if (l.root.getRight() != null) q.add(new Level(l.root.getRight(), l.level + 1));
        }
        return v;
    }

    /**
     * Level order traversal
     * TC = we are touching any node 2  push and then pop same node so its o(2*n) = o(n)
     * SC = o(width of the tree on specific level )
     * print next level in next line, without any pair concept
     */
    void levelOrderTraversalPrettyWithoutLevel(Root root) {
        Queue<Root> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {

            int qSize = q.size();

            while (qSize > 0) {
                Root r = q.poll();
                if (r != null) {
                    System.out.print(r.getVal() + ", ");
                    if (r.getLeft() != null) q.add(r.getLeft());
                    if (r.getRight() != null) q.add(r.getRight());
                }
                qSize--;
            }
            System.out.print("\n");
        }
    }


    /**
     * ZigZag level order traversal
     * TC = o(n)
     * SC = o(width)
     */

    public void zigZagLevelOrderTraversal(Root root) {
        Queue<Root> q = new ArrayDeque<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {

            int qSize = q.size();
            Deque<Root> st = new ArrayDeque<>();
            while (qSize > 0) {
                Root r = q.poll();
                if (level % 2 == 0) {
                    System.out.print(r.getVal() + ", ");
                } else {
                    st.push(r);
                }
                if (r.getLeft() != null) q.add(r.getLeft());
                if (r.getRight() != null) q.add(r.getRight());

                qSize--;
            }
            while (!st.isEmpty()) {
                System.out.print(st.poll().getVal() + ", ");
            }
            level++;
            System.out.print("\n");
        }
    }

    /**
     * print left view of a BT
     */
    int level = 0;
    public void printLeftView(Root root) {
        Queue<Root> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            boolean isPrint = true;
            int qSize = q.size();

            while (qSize > 0) {
                Root r = q.poll();
                if (r != null) {
                    if (isPrint) {
                       System.out.print(r.getVal() + ", ");
                        isPrint = false;
                    }
                    if (r.getLeft() != null) q.add(r.getLeft());
                    if (r.getRight() != null) q.add(r.getRight());
                }
                qSize--;
            }
            System.out.print("\n");

        }
    }

    /**
     * print left view of a BT WithoutQ
     *
     * 1. 1st node of  ith level in preorder sequence, will be the left most node of ith level
     */
    int maxLevel = -1;
    public void leftViewWithoutQ(Root root, int level) {
        if (root == null) {
            return;
        }
        if (level > maxLevel) {
            maxLevel = level;
            System.out.println(root.getVal() + "");
        }
        leftViewWithoutQ(root.getLeft(), level + 1);
        leftViewWithoutQ(root.getRight(), level + 1);
    }

    // pre order
    int currLevel = -1;
    public void rightViewWithoutQ(Root root, int level) {
        if (root == null) {
            return;
        }
        if (level > currLevel) {
            currLevel = level;
            System.out.println(root.getVal() + "");
        }
        rightViewWithoutQ(root.getRight(), level + 1);
        rightViewWithoutQ(root.getLeft(), level + 1);
    }


    class PairVerticalTrvsl {
        private Root root;
        private int level;
        private int horizontalDistance;

        PairVerticalTrvsl(Root root, int level, int horizontalDistance) {
            this.root = root;
            this.level = level;
            this.horizontalDistance = horizontalDistance;
        }

        public Root getRoot() {
            return root;
        }

        public void setRoot(Root root) {
            this.root = root;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getHorizontalDistance() {
            return horizontalDistance;
        }

        public void setHorizontalDistance(int horizontalDistance) {
            this.horizontalDistance = horizontalDistance;
        }
    }

    /**
     * Given a Bin Tree need to perform vertical order traversal
     */
    public void verticalOrderTraversal(Root root) {
        List<PairVerticalTrvsl> l = new ArrayList<>();
        buildNodeCoordinates(new PairVerticalTrvsl(root, 0, 0), l);
        var sortedList = l.stream().sorted(Comparator.comparing(PairVerticalTrvsl::getHorizontalDistance)
                .thenComparing(PairVerticalTrvsl::getLevel))
                .toList();
        sortedList.forEach(ele -> System.out.print(ele.getRoot().getVal()));
    }

    //o(nlongn)
    void buildNodeCoordinates(PairVerticalTrvsl pair, List<PairVerticalTrvsl> list) {
        if (pair.root == null) {
            return;
        }
        list.add(pair);
        buildNodeCoordinates(new PairVerticalTrvsl(pair.root.getLeft(), pair.level + 1, pair.horizontalDistance - 1), list);
        buildNodeCoordinates(new PairVerticalTrvsl(pair.root.getRight(), pair.level + 1, pair.horizontalDistance + 1), list);
    }


    public void verticalOrderTraversalInLinear(Root root) {
        Map<Integer, StringBuilder> m = new TreeMap<>();
        buildNodeCoordinatesWithMap(new PairVerticalTrvsl(root, 0, 0), m);

        m.entrySet()
                .forEach(entry -> System.out.println(entry.getValue().toString()));
    }

    // ordering of node wont preserve
    void buildNodeCoordinatesWithMap(PairVerticalTrvsl pair, Map<Integer, StringBuilder> m) {
        if (pair.root == null) {
            return;
        }
        m.computeIfAbsent(pair.horizontalDistance, k -> new StringBuilder()).append(" ").append(pair.root.getVal());
        buildNodeCoordinatesWithMap(new PairVerticalTrvsl(pair.root.getLeft(), pair.level + 1, pair.horizontalDistance - 1), m);
        buildNodeCoordinatesWithMap(new PairVerticalTrvsl(pair.root.getRight(), pair.level + 1, pair.horizontalDistance + 1), m);
    }

    // ordering of node won't preserve to fix this we have to go level order traversing
    // TC = o(n)
    //SC =  o(n)
    void verticalOrderTraversalInLinearV1(Root root) {
        Map<Integer, StringBuilder> m = new HashMap<>();
       Deque<PairVerticalTrvsl> q = new ArrayDeque<>();
       q.add(new PairVerticalTrvsl(root, 0, 0));
       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;

       while (!q.isEmpty()) {

           int size = q.size();

           for (int i = 0; i < size; i++) {
               PairVerticalTrvsl p = q.poll();
               m.computeIfAbsent(p.horizontalDistance, k -> new StringBuilder()).append(" ").append(p.root.getVal());
               if (p.root.getLeft() != null) q.add(new PairVerticalTrvsl(p.root.getLeft(), p.level + 1, p.horizontalDistance - 1));
               if (p.root.getRight() != null) q.add(new PairVerticalTrvsl(p.root.getRight(), p.level + 1, p.horizontalDistance + 1));
               min = Math.min(min, p.horizontalDistance);
               max = Math.max(max, p.horizontalDistance);
           }
       }

        for (int i = min; i <= max; i++) {
            System.out.println(m.getOrDefault(i, new StringBuilder("")));
        }
    }

    /**
     * Given a BT print the top view
     */
    public void topView(Root root) {
        Map<Integer, Integer> m = new HashMap<>();
        Deque<PairVerticalTrvsl> q = new ArrayDeque<>();
        q.add(new PairVerticalTrvsl(root, 0, 0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                PairVerticalTrvsl p = q.poll();
                if(!m.containsKey(p.horizontalDistance)) {
                    m.put(p.horizontalDistance, p.root.getVal());
                }
                if (p.root.getLeft() != null) q.add(new PairVerticalTrvsl(p.root.getLeft(), p.level + 1, p.horizontalDistance - 1));
                if (p.root.getRight() != null) q.add(new PairVerticalTrvsl(p.root.getRight(), p.level + 1, p.horizontalDistance + 1));
                min = Math.min(min, p.horizontalDistance);
                max = Math.max(max, p.horizontalDistance);
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.println(m.getOrDefault(i, 0));
        }
    }

    public void bottomView(Root root) {
        Map<Integer, Integer> m = new HashMap<>();
        Deque<PairVerticalTrvsl> q = new ArrayDeque<>();
        q.add(new PairVerticalTrvsl(root, 0, 0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                PairVerticalTrvsl p = q.poll();
                m.put(p.horizontalDistance, p.root.getVal());
                if (p.root.getLeft() != null) q.add(new PairVerticalTrvsl(p.root.getLeft(), p.level + 1, p.horizontalDistance - 1));
                if (p.root.getRight() != null) q.add(new PairVerticalTrvsl(p.root.getRight(), p.level + 1, p.horizontalDistance + 1));
                min = Math.min(min, p.horizontalDistance);
                max = Math.max(max, p.horizontalDistance);
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.println(m.getOrDefault(i, 0));
        }
    }


    /**
     * Complete BT :: All levels are full except the last level can be full or can't be full, All the nodes appears as left as possible
     *
     *                      1
     *                    /   \
     *                  2      3  --> its complete BT
     *                 / \    /
     *                4    5 6
     *
     *  Given perfect BT (all the level is full) we have counts the nodes
     *  no. of nodes = 2^h - 1
     *
     *  Hight of perfect BT  = log of n base 2 where n is number of nodes
     */

    public int countTheNodesOfPerfectBT(Root root) {
        int h = 0;
        while(root != null) {
            root = root.getLeft();
            h++;
        }
        return (int)Math.pow(2, h) -1;
    }

    /**
     *                     1   -0
     *                    /  \
     *                  2     3  - 1
     *                /  \   / \
     *              4     5 6   7  3
     *             / \   /
     *           8   9  10
     *
     *   In above non perfect BT we can calculate node count till level 3, because Tree is perfect BT till this
     *   level, now we have to count node only in last level and add with above
     *
     *   How to calculate node at last level?
     *   # of node at any level  = ( 2 pow height of tree ) - 1 = in above tree case h = 4
     *                            = 2^3 - 1 = 8
     * So total nodes at level 4 is 8 now we have to find out how many non-null nodes in that level
     *
     * last level something like this => 8 9 10 N N N N N  -> data is monotonic
     * so here is ordering we can find  last non-null element using binary search
     *
     * range of data = 1, 2^(h-1) = [1, 8] now we have to check this node check image - "findNode" log n time
     *
     * TC = log ( gap between low and high) = log (2^h-1)
     *  every time isNull method will execute which TC = o(h)
     *  so total time complexity  = (h * log(2^(h-1))
     *                            = h^2 = o( log N square)
     */
    public int countTheNodesOfNonPerfectBT(Root root) {
        int h = 0;
        while(root != null) {
            root = root.getLeft();
            h++;
        }
        int maxLeaveCount = getMaxLeavesCount(2, h-1);
        int low = 1;
        int high = maxLeaveCount;

        int ans = 0;

        while (low <= high) {
            int mid = low + high / 2;
            boolean isNull = isNullNode(root, maxLeaveCount, mid);

            if (isNull) {
                high = mid - 1;
            } else {
                isNull = isNullNode(root, maxLeaveCount, mid + 1);
                if (isNull) {
                    ans = mid;
                    break;
                } else {
                    low = mid + 1;
                }
            }
        }
        return (maxLeaveCount -1) + ans;
    }

    private int getMaxLeavesCount(int base, int pow) {

        if (pow == 0) return 1;

        int ans = getMaxLeavesCount(base, pow / 2);
        if (pow % 2 == 0) {
            return ans * ans;
        }
        return ans * ans * base;
    }

    public boolean isNullNode(Root root, int maxLeavesNode, int mid) {
        if (mid > maxLeavesNode) {
            return true;
        }
        int l = 1, h = maxLeavesNode;

        while (h > l) {
            int m = l + h / 2;

            //LST
            if (m <= mid) {
                root = root.getLeft();
                h = m;
            } else { //RST
                root = root.getRight();
                l = m + 1;
            }
        }
        return root == null;
    }

    record PerfectPair(boolean isPerfect, int height){}
    /**
     *  # node = 1 + countOfNodeInNormaBT(root.left) + countOfNodeInNormaBT(root.right)
     *  SC = o(logn)
     *  TC = o(logn square)
     */
    private int countOfNodeInNormaBT(Root root) {
        if (root == null) {
            return 0;
        }
        int cnt = 1;

        PerfectPair pLeft = isPerfect(root.getLeft());
        PerfectPair pRight = isPerfect(root.getRight());

        if (pLeft.isPerfect) {
            cnt += ((int)Math.pow(2, pLeft.height) - 1);
        } else {
            cnt += countOfNodeInNormaBT(root.getLeft());
        }

        if (pRight.isPerfect) {
            cnt += ((int)Math.pow(2, pLeft.height) - 1);
        } else {
            cnt += countOfNodeInNormaBT(root.getRight());
        }
        return cnt;
    }

    public PerfectPair isPerfect(Root root) {
        Root tmp = root;
        int hLeft = 0, hRight = 0;

        while(tmp != null) {
            tmp = tmp.getLeft();
            hLeft++;
        }
        tmp = root;

        while(tmp != null) {
            tmp = tmp.getRight();
            hRight++;
        }

        return new PerfectPair(hLeft == hRight, Math.max(hLeft, hRight));
    }


    /**
     * Given pre order of BT traversal result in an array, Now we have to Generate the tree
     *
     * ** cant generate unique BT because sequence of BT trversal will print 1st root then left and right
     * So only root is fixed because 1st root must be root note rest some of left nodes and some of them could be right
     * subtree
     *
     * Preorder and inorder we can get to know that left root and right but this will not work in case of duplicate ele
     *
     * o(n^2)
     */

    List<Integer> preOrderList = new ArrayList<>();
    List<Integer> inOrderList = new ArrayList<>();

    private Root build(int i1, int j1, int i2, int j2) {
        if(i1 > j1) {
            return null;
        }

        Root r = new Root(preOrderList.get(i1), null, null);

        int i = 0;

        //o(n) can we replaced below loop with Map[preorder[i], index]
        for (i = i2; i <= j2; i++) {
            if(Objects.equals(inOrderList.get(i), preOrderList.get(i1))) {
                break;
            }
        }

        r.setLeft(build(i1 + 1, (i1 + i - i2), i2, i - 1)); // LST
        r.setRight(build((i1 + i - i2 + 1),j1 , i1 +1, j2)); // RST

        return r;
    }


    public void preOrderTraversal(Root root) {
        if(root == null) {
            preOrderList.add(null);
            return;
        }
        preOrderList.add(root.getVal());
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    int i = 0;

    public Root makeTree() {
        Integer currNodeVal = preOrderList.get(i);
        if (currNodeVal == null) {
            i++;
           return null;
        }

        Root n = new Root(preOrderList.get(i), null, null);
        i++;

        n.setLeft(makeTree());
        n.setRight(makeTree());

        return n;
    }

    public static void main(String[] args) {
        Root r0 = new Root(5);
        Root r4 = new Root(4);
        Root r1 = new Root(1);

        Root r7 = new Root(7);
        Root r3 = new Root(3);
        Root r6 = new Root(6);
        Root r9 = new Root(9);
        Root r2 = new Root(2);
        Root r4_1 = new Root(4);

        r0.setLeft(r4);
        r0.setRight(r1);

        r1.setLeft(r6);
        r1.setRight(r9);

        r9.setLeft(r2);
        r2.setRight(r4_1);

        r4.setRight(r7);
        r7.setRight(r3);

        TreeTraversal t = new TreeTraversal();

       /* List<Level> nodes = t.levelOrderTraversalPretty(r0);

        int n = nodes.size();
        int currLevel = nodes.get(0).level;
        System.out.print(nodes.get(0).root.getVal());

        for (int i = 1; i < n; i++) {
            if (currLevel == nodes.get(i).level) {
                System.out.print(nodes.get(i).root.getVal() + ", ");
            } else {
                System.out.print("\n");
                System.out.print(nodes.get(i).root.getVal() + ", ");
            }
            currLevel = nodes.get(i).level;
        }*/

        //t.levelOrderTraversalPrettyWithoutLevel(r0);
        //System.out.println("=========================================");
        /*t.printLeftView(r0);
        System.out.println("=========================================");
        t.leftViewWithoutQ(r0, 0);
        System.out.println("=========================================");*/
        //t.rightViewWithoutQ(r0, 0);

        Root r5_1 = new Root(5);
        Root r6_1 = new Root(6);
        Root r8 = new Root(8);

        Root r11 = new Root(11);
        Root r7_1 = new Root(7);
        Root r9_1 = new Root(9);
        Root r2_1 = new Root(2);
        Root r10 = new Root(10);

        r5_1.setLeft(r6_1);
        r5_1.setRight(r8);

        r6_1.setLeft(r11);
        r6_1.setRight(r7_1);

        r11.setRight(r2_1);

        r8.setRight(r9_1);
        r9_1.setLeft(r10);

        t.levelOrderTraversalPrettyWithoutLevel(r5_1);
        System.out.println("=========================================");

        //t.verticalOrderTraversal(r5_1);
        //t.verticalOrderTraversalInLinearV1(r5_1);
        t.bottomView(r5_1);


        Root r1_0 = new Root(1);
        Root r2_0 = new Root(2);
        Root r3_0 = new Root(3);

        Root r4_0 = new Root(4);
        Root r5_0 = new Root(5);
        Root r6_0 = new Root(6);
        Root r7_0 = new Root(7);
        Root r8_0 = new Root(8);
        Root r9_0 = new Root(9);
        Root r10_0 = new Root(10);
        Root r11_0 = new Root(11);
        Root r12_0 = new Root(12);
        Root r13_0 = new Root(13);
        Root r14_0 = new Root(14);
        Root r15_0 = new Root(15);

        r1_0.setLeft(r2_0);
        r1_0.setRight(r3_0);

        r2_0.setLeft(r4_0);
        r2_0.setRight(r5_0);

        r4_0.setLeft(r8_0);
        r4_0.setRight(r9_0);

        r5_0.setLeft(r10_0);
        r5_0.setRight(r11_0);

        r3_0.setLeft(r6_0);
        r3_0.setRight(r7_0);

        r6_0.setLeft(r12_0);
        r6_0.setRight(r13_0);

        r7_0.setLeft(r14_0);
        r7_0.setRight(r15_0);

        int count = t.countTheNodesOfPerfectBT(r1_0);
        System.out.println("Node count => " + count);
    }

}
