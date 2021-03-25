public class ExceptionDemo1 {

    public static void main(String... args) {
        try {
            throw new C();
        } catch (B b) {
            System.out.print("BBB");
        } catch (A a) {
            System.out.print("AAA");
        }
    }
}

class A extends Exception {

}

class B extends A {

}

class C extends B {

}
