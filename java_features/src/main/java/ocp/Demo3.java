package ocp;

import com.rotatingmind.java8.stream.predicate.Predicate;

public class Demo3 {

    /*
     *  var var = 3; -> will not compile
     *  Var case = new Var(); -> will not compile
     *  int Var() { var _ = 7; return _;} -> will not compile
     * var var() { return null; }
     */




    public static void main(String[] args) {
        question2();
    }

    private static void question1() {
        int moon = 9, star = 2 + 2 * 3;
        float sun = star>10 ? 1 : 3;
        double jupiter = (sun + moon) - 1.0f;
        int mars = --moon <= 8 ? 2 : 3;
        System.out.println(sun+"-"+jupiter+"-"+mars);
    }

    public static void question2() {
        var s1 = "Java";
        var s2 = "Java";
        var s3 = "Ja".concat("va");
        var s4 = s3.intern();
        var sb1 = new StringBuilder();
        sb1.append("Ja").append("va");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(sb1.toString() == s1);
        System.out.println(sb1.toString().equals(s1));
    }

    public static void question3() {
        final int score1 = 8, score2 = 3;
        char myScore = 7;
        /*switch (myScore) {
            default:
                score1:
                2: 6: System.out.print("great-");
                4: System.out.print("good-"); break;
            score2:
            1: System.out.print("not good-");
        }*/
    }

    private static void testDemo() {
        //test((int i) ‐> i == 5)
         // boolean test = test((int i) ‐> { return i == 5;});// not compiled
        //System.out.println(test(i -> i == 5));
        //System.out.println(test((i) -> i == 5));
        // System.out.println(test((i) -> return i == 5)); not compiled
    }

    private static boolean test(Predicate<Integer> p) {
        return p.test(5);
    }
}
