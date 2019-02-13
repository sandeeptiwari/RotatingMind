import java.util.Stack;

/*
 * The order of inorder traversal is LEFT ROOT RIGHT The order of preorder traversal is ROOT LEFT RIGHT The order of postorder 
 * traversal is LEFT RIGHT ROOT In all three traversals, LEFT is traversed before RIGHT
*/
public class BSTTraversing{
	
	
	public TreeNode createTreeNode(){
		TreeNode root 	= new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);
		
		root.left = node20;
		root.right = node60;
		node20.left = node10;
		node20.right = node30;
		node60.left = node50;
		node60.right = node70;
	 return root;
	}
	
	//inOrder traversing by iterative
	public void inOrederTraversing(TreeNode root){
		
		if(root == null)  
			return;
		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!(stack.empty())){
			
			if(current.left != null){
				stack.push(current.left);
				current = current.left;
			}else{
				current = stack.pop();
				System.out.print(" "+current.data);
				if(current.right != null){
					stack.push(current.right);
					current = current.right;
				}
			}
		}
	}
	
private static void inorderTraverse(TreeNode bsTree ){
       ArrayDeque<TreeNode> stack = new ArrayDeque<>();// step 1
        TreeNode current = bsTree;

        while(current != null || !stack.isEmpty()){

            while(current != null) {
                stack.push(current);
                current = current.left;
            }
                current = stack.poll();
                System.out.print(current.data);

                current = current.right;

        }
    }
    
    /**
     * 1. Initialize current as root
     * 2. While current is not NULL
     *    If current does not have left child
     *       a) Print current’s data
     *       b) Go to the right, i.e., current = current->right
     *    Else
     *       a) Make current as right child of the rightmost
     *          node in current's left subtree
     *       b) Go to this left child, i.e., current = current->left
     */
    public void morrisTraversal(TreeNode root){
        TreeNode current, pre;

        if (root == null)
            return;

        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            }
            else {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                /* Revert the changes made in if part to restore the
                    original tree i.e., fix the right child of predecssor*/
                else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                } /* End of if condition pre->right == NULL */

            } /* End of if condition current->left == NULL*/

        } /* End of while */
    }
	
	//inOrder traversing by recursively
	public void inOrder(TreeNode root) {  
	  if(root !=  null) {  
		   inOrder(root.left);  
		   //Visit the node by Printing the node data    
		   System.out.printf("%d ",root.data);  
		   inOrder(root.right);  
	  }  
 }  
 
 public static void levelTraversing(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Root current = queue.poll();

            System.out.print(current.data);

            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);


        }
    }
	
	//pre order traversing by iterative
	public void preOrderTraverse(TreeNode root){
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!(stack.empty())){
			TreeNode node = stack.pop();
			System.out.print(" "+node.data);
			if(node.right != null){
				stack.push(node.right);
			}
			if(node.left != null){
				stack.push(node.left);
			}
		}
	}
	
	//pre order traversing by recursive
	public void preorder(TreeNode root) {  
    if(root !=  null) {  
   //Visit the node by Printing the node data    
      System.out.printf("%d ",root.data);  
      preorder(root.left);  
      preorder(root.right);  
    }
    
    private int countsInternalNode(Root root){
    	if(root == null)
	 return 0;
	if(root.left == null && root.right == null)
	 return 0;
	 
	return 1+ countsInternalNode(root.left) + countsInternalNode(root.right);
	
    }
    
  } 
	
	public static void main(String...args){
		
		BSTTraversing tree = new BSTTraversing();
		TreeNode root = tree.createTreeNode();
		System.out.println("Pre Order Traverse Iterative");
		tree.preOrderTraverse(root);
		System.out.println("\n");
		System.out.println("Pre Order Traverse Recursive");
		tree.preorder(root);
		System.out.println("\n");
		System.out.println("In Order Traverse iteratively");
		tree.inOrederTraversing(root);
		System.out.println("\n");
		System.out.println("In Order Traverse recursively");
		tree.inOrder(root);
		System.out.println("\n");
	}
	
}

class TreeNode{
	
	public int data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int data){
		this.data = data;
	}
}
