package com.rottaingmind.ds.tree.v1;

public class TreeSearcher
{
    public static void main(String[] args)
    {
        Node<String> tree = BinaryTreeFactory.constructTree("quick", "brown", "fox", "jumps", "over", "the", "lazy", "dogs", "back");
        Node<String> node = search(tree, "dogs");
        System.out.println(node.getLabel());
    }

    public static Node<String> search(Node<String> node, String label)
    {
        if(node == null)
        {
            return null;
        }
        if (node.getLabel().equals(label)) {
            return node;
        }
        if(label.compareTo(node.getLabel()) < 0 )
            return search(node.getLeftChild(), label);

        return search(node.getRightChild(), label);
    }

//                    quick < fox
//                   /     \
//               brown      the
//              /     \
//            back   fox
//                  /   \
//                dog   jumps
//                         \
//                          over
//                          /
//                        lazy
}
