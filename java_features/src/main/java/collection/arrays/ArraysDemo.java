package collection.arrays;

import java.util.Arrays;

public class ArraysDemo {

    public static void compareDemo() {
        int[] a = {6, 8, 9};
        int[] b = {6, 7, 9};
        int[] c = {6, 7, 9};
        int[] d = {6, 7};
        int[] e = { 7, 9};

        System.out.println(Arrays.compare(a, b));//1
        System.out.println(Arrays.compare(b, c));//0
        System.out.println(Arrays.compare(c, d));//1
        System.out.println(Arrays.compare(d, e));//-1
    }

    public static void main(String[] args) {
        compareDemo();
    }
}
