import linklist.LinkList1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLinkList {

   /* private LinkList1 linkList;
    private Node one;

    @Before
    public void setUp() {
        linkList = new LinkList1();
        one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);

        one.setNext(two); two.setNext(three); three.setNext(four);
        four.setNext(five); five.setNext(six); six.setNext(seven);
        seven.setNext(eight); eight.setNext(nine); nine.setNext(ten);
    }

    @Test
    public void testDeletionNodeFromMiddle() {
        //create the link list
        linkList.insertAtFront(new Node(40));
        linkList.insertAtFront(new Node(30));
        linkList.insertAtFront(new Node(20));
        linkList.insertAtFront(new Node(10));

        // delete the node
        Assert.assertTrue(linkList.size() == 4);
        linkList.remove(new Node(30));
        Assert.assertTrue(linkList.size() == 3);
    }

    @Test
    public void testDeleteByNode() {
        Node node40 = new Node(40);
        Node node30 = new Node(30);
        Node node20 = new Node(20);
        Node node10 = new Node(10);
        //create the link list
        linkList.insertAtFront(node40);
        linkList.insertAtFront(node30);
        linkList.insertAtFront(node20);
        linkList.insertAtFront(node10);

        // delete the node
        Assert.assertTrue(linkList.size() == 4);
        linkList.deleteByNode(node20);
        Assert.assertTrue(linkList.size() == 3);
    }


    @Test
    public void testReArrangeNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        //create the link list
        linkList.insertAtFront(node3);
        linkList.insertAtFront(node4);
        linkList.insertAtFront(node2);
        linkList.insertAtFront(node1);


        Node result = linkList.reArrangeTheNode(node1);
        Assert.assertTrue(linkList.size() == 3);
    }
*/
}
