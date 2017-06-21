/**
 * Finding if a Binary Tree is a Binary Search Tree.
**/

public class CheckBinarySearchTree{
	
	public static void main(String args[]){
		CheckBinarySearchTree bst = new CheckBinarySearchTree();
		Node root = new Node(30);
		root.left = 5;
		root.right = 40;
		root.right.left = 10;
		root.right.right = 50;
		
		boolean isBst = bst.isBst(root);
		System.out.println("Tree is BST "+isBst);
	}
	
	public boolean isBst(Node root){
		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean isValidBst(Node root, int min, int max){
		if(root == null)
			return true;
		if(root.left > min && root.right < max 
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