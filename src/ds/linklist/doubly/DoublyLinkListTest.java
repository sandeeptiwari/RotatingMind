package ds.linklist.doubly;

public class DoublyLinkListTest {

    public static void main(String[] args) {
        DoublyLinkList<String> doublyLinkList = new DoublyLinkList<>();
        doublyLinkList.insert("Adam");
        doublyLinkList.insert("Kyle");
        doublyLinkList.insert("Michael");
        doublyLinkList.insert("Mike");
        doublyLinkList.insert("Peter");

        doublyLinkList.traverseForward();
        System.out.println("\n");
        doublyLinkList.traverseBackward();
    }
}
