package com.rotatingmind;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*// allocates memory for 10 integers
        int[] anArray = new int[10];
        // initialize first element
        anArray[0] = 100;
        // initialize second element
        anArray[1] = 200;
        // and so forth
        anArray[2] = 300;
        anArray[3] = 400;
        anArray[4] = 500;
        anArray[5] = 600;
        anArray[6] = 700;
        anArray[7] = 800;
        anArray[8] = 900;
        anArray[9] = 1000;
*/
        B b = new B();
        String a = b.a();
        System.out.println(a);

        A a1 = () -> "I am interface's method";
        System.out.println(a1.a());
    }
}

@FunctionalInterface
interface  A {

    String a();

}

class B {


    public String a() {
        return "I am interface's method";
    }

}

class C extends B {

    public String a(String a) {
        return "I am interface's method";
    }
}