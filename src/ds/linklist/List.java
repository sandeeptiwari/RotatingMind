package ds.linklist;

public interface List<T extends Comparable<T>> {
    void insert(T data);
    void remove(T data);
    default void  traverse() {};
    int size();

    default void reverse() {};

    default Node<T> reverseByRecursion(Node<T> root) {
        return null;
    };

    default Node<T> getMiddleNode() {
        return null;
    };

    default void traverseBackward() {};

    default void traverseForward() {};
}
