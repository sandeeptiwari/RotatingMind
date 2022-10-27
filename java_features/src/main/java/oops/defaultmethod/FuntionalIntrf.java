package oops.defaultmethod;

public interface FuntionalIntrf {
    default void test1() {
        System.out.println("I am default method");
    }
    void test();
}
