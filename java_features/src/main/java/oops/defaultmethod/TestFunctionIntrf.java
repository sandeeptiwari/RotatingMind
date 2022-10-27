package oops.defaultmethod;

public class TestFunctionIntrf {

    public static void main(String[] args) {
        new TestFunctionIntrf().lambdaTest(() -> System.out.println("I am implementation of FI"));
    }

    void lambdaTest(FuntionalIntrf fi) {
        fi.test();
    }
}
