package stream.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an unsorted array of numbers, write a function that returns true if array consists of consecutive numbers.
 *     Examples:
 * a.    If array is {5, 2, 3, 1, 4}, then the function should return true because the array has consecutive numbers from 1 to 5.
 * b.    If array is {83, 78, 80, 81, 79, 82}, then the function should return true because the array has consecutive numbers from 78 to 83.
 * c.    If the array is {34, 23, 52, 12, 3}, then the function should return false because the elements are not consecutive.
 * d.     If the array is {7, 6, 5, 5, 3, 4}, then the function should return false because 5 and 5 are not consecutive.
 */
public class ConsecutiveNumberTest {

    /**
     * Sample-1 : {4, 3, 5, 1, 5, 2};
     * Sample-2 : {83, 78, 80, 81, 79, 82}
     * Sample-3 : {5, 2, 3, 1, 4}
     */
    public static void main(String[] args) {
        ConsecutiveNumberTest test = new ConsecutiveNumberTest();
        int[] arr = {5, 2, 3, 1, 4, 8, 6};
        System.out.println(test.isConsecutive2(arr));
    }
    private boolean isConsecutive(int[] values) {
        List<Integer> numbers = Arrays.stream(values).sorted().boxed().collect(Collectors.toList());
        int count = numbers.size();
        int first = numbers.get(0);
        int standardSum = (int)((count/2f) * (2*first + (count - 1)));
        int currentSum = numbers.stream().mapToInt(Integer::intValue).sum();
        return standardSum == currentSum;
    }

    private boolean isConsecutive2(int[] values) {
        List<Integer> numbers = Arrays.stream(values).sorted().boxed().collect(Collectors.toList());
        boolean isConsecutive = true;
        int first = numbers.get(0);
        for (int i = 1; i < numbers.size() - 1; i++) {
            if (!numbers.contains(first + i)) {
                isConsecutive = false;
            }
        }
        return isConsecutive;
    }
}
