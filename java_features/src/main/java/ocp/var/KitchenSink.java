package ocp.var;

public class KitchenSink {

    private static int numForks;

    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        int numKnives;
        System.out.print("""
          
          "# forks = " + numForks +
           " # knives = " + numKnives +
          # cups = 0""");
    }

    private static void method2() {
        int numKnives = 1;
        System.out.print("""
          "# forks = " %s
           " # knives = " %s
          # cups = 0""".formatted(numForks, numKnives));
    }
}
