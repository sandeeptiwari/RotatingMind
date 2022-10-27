package oops;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * java provide 8 types
 *  primitive
 *  Number ->  implicit or widning
 *  Integer -> byte(-2^7 to 2^7-1), short(-2^15 to 2^15-1), int(-2^31 to 2^31-1), long (-2^63 to 2^63 -1)
 *  Floating point -> float(32), double (64)
 *  character -> signed 0 to 2^16
 *  boolean -> true/false
 *  Long - -2^63 to 2^ 63-1
 *  Float - 3.4& 10^38 to 3.4*1038
 */
public class Session5Demo {


    public static void main(String[] args) {
        arrayMethod();

    }

    public static void variableAndClassObject() {
        //reference type var -> statement
        Person person1 = new Person();//instance of person
        person1.id = 1;
        person1.name = "Jhon";
        person1.age = 43;

        Person person2 = new Person();//instance of person
        person2.id = 2;
        person2.name = "Henry";
        person2.age = 23;

        int id = 100;//primitive var
        int age = id; //-> expression
        long phone = 12_234_567; // since java 7
        int hexVar = 0x0041; // 16 power 0 * 1 + 16 power 1 * 4 = 65 //hexadecimal declaration and intialization
        //octal
        int intOCt = 0101;
        //since java 7 binary
        int numBinary = 0b0100_00001;
        System.out.println("Binary value " + numBinary);
        long longVar = 100l;

        //byte age1 = 165;
        short rank = 129;
        int a = Byte.MAX_VALUE;
        int b = Byte.MIN_VALUE;
        System.out.println("max byte " + a);
        System.out.println("min byte " + b);

        int a1 = Short.MAX_VALUE;
        int b1 = Short.MIN_VALUE;
        System.out.println("max short " + a1);
        System.out.println("min short " + b1);

        // floating point:
        float floatVar = 3.123456789f; // 6-7 decimal
        double doubleVar = 3.123456789; // 15 - 16 decimal digit

        //Note: where ever you need exact correct value without loss do not go with float or double
        BigDecimal bg1 = new BigDecimal("1.2");
        BigDecimal bg2 = new BigDecimal("6.0000000000000000000000000000000000000000002121");
        float dbg = 6.0000000000000000000000000000000000000000002121f;

        System.out.println("Float " + floatVar);
        System.out.println("doubleVar " + doubleVar);

        System.out.println("bigdecimal " + bg2);
        System.out.println("double " + dbg);

        //character
        /**
         * defalt char = \u0000 -> NUL
         * UTF-16
         */
        char charVar = 'A';//[0 to 2^16-1]
        char defaultChar = '\u0000';
        System.out.println("default Char " + defaultChar);
        char bChar = 'B'; // \u0042 ->  00000000 01000010 -> 66
        char smily = '\u1F92';
        System.out.println("");

        /**
         * 1- instance variable
         * 2- static -> class level variable
         * 3- local variable -> inside method
         * we have 2 type variable conversion: implicit and explicit
         */

        long y = 42;
        int z = (int) y; //narrowing

    }
    public static void localVariable() {
        int y;
        int x = y = 10; // local variable and its scope is within this block only
        System.out.println(x);
    }

    /**
     *
     */
    public static void arrayMethod() {
        int[] arr = new int[5]; //** provide the size of array
        int[] arr1 = new int[]{
                1,2,3,4,5, 6, 7, 8, 9, 10
        };
        int[] arr2 = {1, 2,3,4,5};

        //iterate
        //1000 -> 1004 -> 1008 -> insertion order preserve
        //how to iterate the array
        System.out.println("Ele-0 " + arr1[0]);
        System.out.println("Ele-1 " + arr1[1]);
        System.out.println("Ele-2 " + arr1[2]);
        System.out.println("Ele-3 " + arr1[3]);
        System.out.println("Ele-4 " + arr1[4]);
        System.out.println("size of array " + arr1.length);
        int size  = arr1.length;
        for (int i = 0; i < size; i++) {
            System.out.println(arr1[i]);
        }

        Arrays.stream(arr1).forEach(System.out::println);
    }

    /**
     * Assignment - 1:
     *  1- you have to store country currency value in 1D array
     *  2- create convertCurrency method which accept currency and index of exchange rate array,
     *     and return converted value.
     * Assignment 2:
     *          *
     *         * *
     *        * * *
     *       * * * *
     *
     *       ***
     *       ***
     *       ***
     *         ***
     *         ***
     *         ***
     *            ***
     *            ***
     *            ***
     *
     */
    public static void work2DArrayMethod() {
        int arr[][] = new int [4][2];
        arr[0][0] = 9;

        int [][] arr11 = new int[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        };
        int [][] arr111 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
    }
}
