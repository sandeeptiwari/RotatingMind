package com.rottaingmind.ds.tree.geeksforgeek.code;

public class TestTree {

    /**
     * (width-first)
     *  Inorder: root-left-right

     * Depth First:
     *     Inorder: left-root-right
     *     PreOrder: root-left-right
     *     PostOrder: left-right-root
     *
     *                  10
     *                  /\
     *                 /  \
     *                20  30
     *                /\   \
     *               /  \   \
     *              40  50   60
     *                  /\
     *                 /  \
     *                70  80
     *
     *     Example:
     *      InOrder: 40 20 70 50 80 10 30 60 -> o(n)
     *
     *      PreOrder: 10 20 40 50 70 80 30 60
     *
     *      PostOrder: 40 70 80 50 20 60 30 10
     *
     *    Height of a binary Tree:
     *
     *    Longest path of max no of edges
     *
     */


  public static int height(Node root) {
      if (root == null) {
          return 0;
      } else {
          int leftHeight = height(root.getLeftChild()) + 1;
          int rightHeight = height(root.getRightChild()) + 1;
          return Math.max(leftHeight, rightHeight);
      }
  }


   /* public static void main(String[] args) {
        Node root = new Node.Builder(10)
                    .build();
        root.setLeft(new Node(20));
        root.setRight(new Node(30));
        root.getLeft().setLeft(new Node(40));

        System.out.println(height(root));
    }*/
}
