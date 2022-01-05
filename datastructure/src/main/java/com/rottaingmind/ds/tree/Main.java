package com.rottaingmind.ds.tree;

public class Main {

    /**
     *
     * @param args
     *              25
     *             /  \
     *            /    \
     *           20    27
     *          /\     /\
     *         /  \   /  \
     *        15  22 26   30
     *                    /\
     *                   /  \
     *                  29  32
     */
    public static void main(String[] args) {
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);

        Tree intTree1 = new Tree();
        intTree1.insert(7);
        intTree1.insert(6);
        intTree1.insert(5);
        intTree1.insert(4);
        intTree1.insert(3);
        intTree1.insert(2);
        intTree1.insert(1);


        Tree intTree2 = new Tree();
        intTree2.insert(10);
        intTree2.insert(5);
        intTree2.insert(14);
        intTree2.insert(7);
        intTree2.insert(8);
        intTree2.insert(15);
        intTree2.insert(13);
        intTree2.insert(16);
        intTree2.insert(12);
        intTree2.insert(4);
        intTree2.insert(7);
        intTree2.insert(3);
        intTree2.insert(8);
        intTree2.insert(2);
        intTree2.insert(9);

        System.out.println(intTree.maxDepth());

       /* System.out.println(intTree.get(15));

        System.out.println(intTree.min());

        System.out.println(intTree.max());*/

        // intTree.traverseLevelOrder();

        System.out.println("Done");
    }
}
