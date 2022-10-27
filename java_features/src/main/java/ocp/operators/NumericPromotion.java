package ocp.operators;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1. If two values have different data types, Java will automatically promote one of the values to the larger of the
 * two data types.
 *
 * 2. If one of the values is integral and the other is floating-point, Java will automatically promote the integral value
 * to the floating-point value's data type.
 *
 * 3. Smaller data types, namely, byte, short, and char, are first promoted to int any time they're used with a Java binary
 * arithmetic operator with a variable (as opposed to a value), even if neither of the operands is int.
 *
 * 4.After all promotion has occurred and the operands have the same data type, the resulting value will have the same
 * data type as its promoted operands.
 */
public class NumericPromotion {


    public static void main(String[] args) {
        method7();
    }

    private static void method1() {
        boolean healthy = false;
        if(healthy = true)
            System.out.print("Good!");
    }

    private static void method2() {
        boolean bear = false;
        boolean polar = (bear = true);
        System.out.println(polar);  // true
    }

    /**
     * For object comparison, the equality operator is applied to the references to the objects, not the objects they
     * point to. Two references are equal if and only if they point to the same object or both point to null.
     * Let's take a look at some examples:
     */
    public static void method3() {
        var monday = new File("schedule.txt");
        var tuesday = new File("schedule.txt");
        var wednesday = tuesday;
        System.out.println(monday == tuesday);    // false
        System.out.println(tuesday == wednesday); // true
        System.out.print(null == null);  // true
    }

    //Numeric Comparison Operators
    public static void method4() {
        int gibbonNumFeet = 2, wolfNumFeet = 4, ostrichNumFeet = 2;
        System.out.println(gibbonNumFeet < wolfNumFeet); // true
        System.out.println(gibbonNumFeet <= wolfNumFeet); // true
        System.out.println(gibbonNumFeet >= ostrichNumFeet); // true
        System.out.println(gibbonNumFeet > ostrichNumFeet); // false
    }

    /**
     * One area the exam might try to trip you up on is using instanceof with incompatible types. For example,
     * Number cannot possibly hold a String value, so the following causes a compilation error:
     * @param time
     */
    public static void openZoo(Number time) {
        //if(time instanceof String) // DOES NOT COMPILE
            System.out.print(time);

        System.out.print(null instanceof Object);  // false

        Object noObjectHere = null;
        System.out.print(noObjectHere instanceof String);  // false
       // System.out.print(null instanceof null);  // This example does not compile, since null is used on the right side of the instanceof operator:
    }

    public static void method5() {
        boolean eyesClosed = true;
        boolean breathingSlowly = true;

        boolean resting = eyesClosed | breathingSlowly;
        boolean asleep = eyesClosed & breathingSlowly;
        boolean awake = eyesClosed ^ breathingSlowly;
        System.out.println(resting);  // true
        System.out.println(asleep);   // true
        System.out.println(awake);    // false
    }

    public static void method6() {
        boolean canine = true, wolf = true;
        int teeth = 20;
        canine = (teeth != 10) ^ (wolf=false);
        System.out.println(canine+", "+teeth+", "+wolf);
    }

    public static void method7() {
       int hungryHippopotamus = 8;
       while (hungryHippopotamus > 0) {
           do {
               hungryHippopotamus -= 2;
           } while (hungryHippopotamus > 5);

           hungryHippopotamus--;
           System.out.print(hungryHippopotamus + ", ");
       }
    }

    public static void method8() {
        Set<Integer> integers = new HashSet<>();
        Map<String, Integer> map  = new HashMap<>();//not allowed in for each loop
        for (var a:
                map.entrySet()) {

        }
    }

    public static void method9(int category) {
        /*var type = switch (category) {
            case 2 -> "Snake";
            case 4 -> "Lizard";
            case 6 -> "Turtle";
            case 8 -> "Alligator";
            //default -> throw new IllegalStateException("Unexpected value: " + category);
        };*/
       // System.out.println(type);
    }
}
