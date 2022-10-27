package oops.intrfdemo;

import java.util.List;

/**
 * Abstract class cannt be instantiated
 * can have contruct inside abstract class
 * no need to provide body to abstract method
 * concrete method can have inside abstract class
 */
public abstract class C {

    C() {

    }

    abstract void show();


    public void test() {
        System.out.println("Hello I am concrete method");
    }

}
