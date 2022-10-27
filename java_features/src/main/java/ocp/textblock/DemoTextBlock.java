package ocp.textblock;

public class DemoTextBlock {
   private static int numForks;

    public static void main(String[] args) {
        method2();
    }

    private static void method1() {
        int numKnives = 1;
        System.out.print("""
          "# forks = " %s
           " # knives = " %s
          # cups = 0""".formatted(numForks, numKnives));
    }

    private static void method2() {
        var blocky = """
                squirrel \s
                pigeon   \
                termite""";
        System.out.print(blocky);
    }

    private static void method3() {

    }

    private static void method4() {

    }
}
