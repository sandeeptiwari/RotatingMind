package oops.intrfdemo;

/**
 * all variable constant inside interface
 * public abstract
 * A <- B <- C  x() : Sub interface win over child interface
 */
@FunctionalInterface
public interface A {
    int x = 10;

    void show();

    /**
     * instance method and can be overrid eby following overrid rules
     */
    default void heyICameInJava8() {
        System.out.println("I am default method");
    }

    static void heyIAmStaticCameInJava8() {

    }
}
