package oops.intrfdemo;




public class Test implements A, B {

    @Override
    public void show() {

    }

    public static void main(String[] args) {
       A a = () -> System.out.println("Print me");
       a.heyICameInJava8();
    }
}
