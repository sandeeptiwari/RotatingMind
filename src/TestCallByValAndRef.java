public class TestCallByValAndRef {
    int a = 9;
    int b = 1_50_450;
    public void show(int a) {
        a += 1;
        System.out.print(" In show "+a);
        System.out.print(" In show b "+b);
    }

    public void call() {
        show(a);
        System.out.print(" in call "+a);
    }

    public static void main(String... args) {
        TestCallByValAndRef ref = new TestCallByValAndRef();
        ref.call();
    }
}
