/* Find out 3 last element in singly linked list */

public class SinglyListDemo{

	public static void main(String args[]){
		CustomLinkList customList = new CustomLinkList();
		Node node1 = new Node(10);
		customList.insertAtEnd(node1);
		Node node2 = new Node(14);
		customList.insertAtEnd(node2);
		Node node3 = new Node(12);
		customList.insertAtEnd(node3);
		Node node4 = new Node(11);
		customList.insertAtEnd(node4);
		Node node5 = new Node(18);
		customList.insertAtEnd(node5);
		Node node6 = new Node(16);
		customList.insertAtEnd(node6);
		Node node7 = new Node(19);
		customList.insertAtEnd(node7);
		Node node8 = new Node(20);
		customList.insertAtEnd(node8);
		Node node9 = new Node(23);
		//node9.setNext(node4);
		customList.insertAtEnd(node9);
		
		
		/*
		 * last 3 item from end
		*/
		/*Node head = customList.getHead();
		Node lastThird = head, lastSecond = head.next, lastFirst = head.next.next;
		while(lastFirst.next != null){
			lastThird = lastThird.next;
			
			lastSecond = lastSecond.next;
			
			lastFirst = lastFirst.next;
		}
		System.out.print(" 3-> "+lastThird+" 2 -> "+lastSecond+" 1-> "+lastFirst);
		*/
		
		System.out.print("List has loop "+customList.hasLoop(node1));
	}

}

class Node{
	public Node next;
	public int data;

	// Creates an empty node.
	public Node(){
		next = null;
		data = Integer.MIN_VALUE;
	}

	// Creates a node storing the specified data.
	public Node (int data){
		next = null;
		this.data = data;
	}

	// Returns the node that follows this one.
	public Node getNext(){
		return next;
	}

	// Sets the node that follows this one.
	public void setNext (Node node){
		next = node;
	}

	// Returns the data stored in this node.
	public int getData(){
		return data;
	}

	// Sets the data stored in this node.
	public void setdata (int elem){
		data = elem;
	}
	
	// Sets the data stored in this node.
	public String toString (){
		return Integer.toString(data);
	}	
}

class CustomLinkList{
	private Node head;
	private int length;
	
	// This class has a default constructor: 
	public CustomLinkList() {
		length = 0;
	}

	// Return the first node in the list 
	public synchronized Node getHead() { 
		return head; 
	}
	
	// Insert a node at the beginning of the list 
	public synchronized void insertAtBegin(Node node) {
		node.setNext(head);
		head = node;
		length++;
	}
	
	// Insert a node at the beginning of the list 
	public synchronized void insertAtEnd(Node node) {
		if(head == null){
			head = node;
		}else{
			Node temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
				
			temp.setNext(node);
		}
		length++;
	}
	
	// Add a new value to the list at a given position.
	// All values at that position to the end move over to make room.
	public void insert(int data, int position) {
		Node n = new Node(data);
		
		if(position < 0)
			position = 0;
		if(position > length)
			position = length;
		
		if(head == null){
			head = new Node(data);
		}else if(position == 0){
			n.setNext(head);
			head = n;
		}
		// else find the correct position and insert
		else {
			 Node temp = head;
			for(int i = 1; i < position; i++){
				temp = temp.getNext();
			}
			Node tNext = temp.getNext();
			n.setNext(tNext);
			temp.setNext(n);
		}
		length++;
	}
	
	// Remove and return the node at the head of the list 
	public synchronized Node removeFromBegin() {
		Node node = head;
		if(node != null){
			
			head = node.getNext();
			node.next = null;
		}
		length--;
		return node;
	}
	
	// Remove and return the node at the end of the list 
	public synchronized Node getLast() {
		if(head == null)
			return null;
		if(head.next == null)
			return head;
		
		Node last = head.next;
		while(last.next != null){
			last = last.next;
		}
		
		return last;
	}
	
	// Remove and return the node at the end of the list 
	public synchronized Node removeFromEnd() {
		Node p = head, q = null;
		if(head == null)
			return null;
		if(p.next == null){
			head = null;
			length--;
			return p;
		}
			
		
		while(p.next != null){
			q = p;
			p = p.next;
		}
		q.next = null;
		length--;
		return p;
	}
	
	public boolean hasLoop(Node root){
		Node slow = root;
		Node fast = root;
		
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast)
				return true;
		}
		
		return false;
	}
	
	public Node reverse(Node root){
		
		if(root == null)
			return null;
		
		if(root.next == null){
			return root;
		}
		
		Node secElement = root.next;
		
		root.next = null;
		
		Node reverseNode  = reverse(secElement);
		
		secElement.next = root;
		
		return reverseNode;
		
	}
}