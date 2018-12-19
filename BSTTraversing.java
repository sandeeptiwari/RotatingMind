import java.util.Stack;
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
        Deque<TreeNode> bsTreeStack = new ArrayDeque<>();
        bsTreeStack.push(bsTree);
        Root current = bsTree;

        while (!bsTreeStack.isEmpty()){
            if(current.left != null){
                bsTreeStack.push(current.left);
                current = current.left;
            }else{
                current = bsTreeStack.pop();
                System.out.println(current.value);
                if(current.right != null){
                    bsTreeStack.push(current.right);
                    current = current.right;
                }
            }
        }
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
