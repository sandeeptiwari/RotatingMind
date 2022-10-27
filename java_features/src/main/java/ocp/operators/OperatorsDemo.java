package ocp.operators;

public class OperatorsDemo {

    public static void main(String[] args) {
        method1();
    }

    public int valid() {
        int y = 10;
        int x; // x is declared here
        x = 3; // x is initialized here
        int z; // z is declared here but never initialized or used
        int reply = x + y;
        return reply;
    }

    public static void method2() {
            int y = 10;
            int x; // local variable must be initialized
          //  int reply = x + y; // DOES NOT COMPILE
        //System.out.println(reply);
    }

    private static void method1() {
        //double d1, double d2;
         int i1; int i2;
        //int i3; i4;
        //double notAtStart = _1000 .00;          // DOES NOT COMPILE
        //double notAtEnd = 1000.00_;            // DOES NOT COMPILE
        //double notByDecimal = 1000_.00;        // DOES NOT COMPILE
        double annoyingButLegal = 1_00_0.0_0;  // Ugly, but compiles
        double reallyUgly = 1__________2;      // Also compiles
    }

    /**
     * The code does not compile. Remember that for local variable type inference, the compiler looks only at the
     * line with the declaration. Since question and answer are not assigned values
     * on the lines where they are defined, the compiler does not know what to make of them. For this reason,
     * both lines 4 and 6 do not compile.
     * @param check
     */
    private static void method4(boolean check) {
            //var question;
            //question = 1;
           // var answer;
            if (check) {
            //    answer = 2;
            } else {
            //    answer = 3;
            }
           // System.out.println(answer);
    }

    public static void method5() {
     //int a, int b = 3;  // DOES NOT COMPILE
    // var n = null;      // DOES NOT COMPILE
   }

    //public static int method5(var a, var b) { // DOES NOT COMPILE
     //   return a + b;
    //}
}
