/**
 * Finding if a Binary Tree is a Binary Search Tree.
**/

public class CheckBinarySearchTree{
	
	public static void main(String args[]){
		CheckBinarySearchTree bst = new CheckBinarySearchTree();
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.right.left = new Node(17);
		root.right.right = new Node(25);
		
		boolean isBst = bst.isBst(root);
		System.out.println("Tree is BST "+isBst);
	}
	
	public boolean isBst(Node root){
		return isValidBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean isValidBst(Node root, int min, int max){
		if(root == null)
			return true;
		if(root.data > min && root.data < max 
				&& isValidBst(root.left, min, root.data)
				&& isValidBst(root.right, root.data, max)){
			return true;	
		}
		return false;
	}
}

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
	}
}