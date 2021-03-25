import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeDemo {


    public static void main(String... args) {
        TreeDemo treeDemo = new TreeDemo();
        Node root = treeDemo.createTree();

        //level order traversing
        treeDemo.printLevelOrder(root);
    }

    /*
     * printLevelOrder(x)
     *  1) create an empty queue q
     *  2) tempNode = root ( start from root )
     *  3) Loop while tempNode is not null
     *      a) print tempNode's data
     *      b) enqueue tempNode's children( first left then right) to q
     *      c) dequeue a node from q and assign it's value into tempNode
     *
     */
    public void printLevelOrder(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        Node tempNode = root;

        while (tempNode != null) {
            if (tempNode.data != null)
                System.out.print(tempNode.data);

            if (tempNode.lNode != null)
                queue.add(tempNode.lNode);

            if (tempNode.rNode != null)
                queue.add(tempNode.rNode);

            tempNode = queue.poll();
        }
    }

    public Node createTree() {
        Node root = new Node("A");

        Node ln1 = new Node("B");
        Node rn1 = new Node("C");

        root.setlNode(ln1);
        root.setrNode(rn1);

        Node ln2 = new Node("D");
        Node rn2 = new Node("E");

        ln1.setlNode(ln2);
        ln1.setrNode(rn2);

        Node ln3 = new Node("F");
        rn1.setlNode(ln3);

        return root;
    }

    static class Node {
        Node lNode;
        Node rNode;
        String data;

        public Node(String data) {
            this.data = data;
        }


        public Node getlNode() {
            return lNode;
        }

        public void setlNode(Node lNode) {
            this.lNode = lNode;
        }

        public Node getrNode() {
            return rNode;
        }

        public void setrNode(Node rNode) {
            this.rNode = rNode;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
