package array;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseArray {

    public static void main(String[] args) {
        ReverseArray reverse = new ReverseArray();
        int arr[] = {1, 2, 3};
        int arr1[] = {4, 5, 1, 2};
        int arr2[] = {1,2,3,4,5};
        Arrays.stream(arr1).forEach(System.out::print);
        arr1 = reverse.reverse1(arr1);
        System.out.println("\n");
        Arrays.stream(arr1).forEach(System.out::print);

        String [] arr3 = reverse.reverse2(arr2);
        System.out.println("\n");
        Arrays.stream(arr3).forEach(System.out::print);
    }

    public void reverse(int[] arr) {
       for (int i = 0, j = arr.length - 1; i <= j; i++, j--) {
           int temp = arr[i];
           arr[i] = arr[j];
           arr[j] = temp;
       }
    }

    public int[] reverse1(int[] arr) {
        return IntStream.rangeClosed(1, arr.length)
                .map(i -> arr[arr.length - i])
                .toArray();
    }

    /**
     * The problem is that we want to reverse a T[] array in O(N) linear time complexity and we want the algorithm to be in-place as well - so the algorithm can not use additional memory!
     *
     * For example: input is [1,2,3,4,5] then the output is [5,4,3,2,1]
     */
    public String[] reverse2(int[] arr) {
        return IntStream.rangeClosed(1, arr.length)
                .mapToObj(i -> arr[arr.length - i] + " ")
                .toArray(value -> new String[value]);
    }

}
