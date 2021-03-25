package functional.query;

public class Test {

    static void doSomething(Normal normal) {
        System.out.println(normal.move());
        System.out.println(normal.toString());
    }

    public static void main(String[] args) {
       //1-
       Normal n = () -> "Sandeep Tiwari";
       System.out.println(n.move());
       //2-
       doSomething(n);

    }
}
