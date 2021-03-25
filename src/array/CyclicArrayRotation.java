package array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CyclicArrayRotation {

    public static void main(String[] args) {
        int[]arr = {10, 20, 30, 40, 50, 60};
        CyclicArrayRotation obj = new CyclicArrayRotation();
        obj.rotate(arr, 2);
        String result = Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(", "));
        System.out.println(result);
    }

    public void rotate(int arr[], int k) {
        int n = arr.length;
        reverse(arr, 0, k - 1); //20, 10, 30, 40, 50, 60
        reverse(arr, k, n-1);// 20, 10, 60, 50, 40, 30
        reverse(arr, 0, n-1);//30, 40, 50, 60, 10, 20
    }

    public void reverse(int arr[], int fromIndex, int toIndex) {
        for (int i = fromIndex, j = toIndex; i < j; j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }


    }
}
