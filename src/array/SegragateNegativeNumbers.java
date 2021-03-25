package array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SegragateNegativeNumbers {

    public static void main(String[] args) {
        int arr[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        SegragateNegativeNumbers obj = new SegragateNegativeNumbers();
        obj.toSegragate(arr);
        String result =
                Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(", "));;
        System.out.println(result);
    }

    public void toSegragate(int arr[]) {
      int len = arr.length;

        for (int i = 0, j = len - 1; i < j; ) {
            if (arr[i] > 0 && arr[j] < 0) {
                swap(arr, i, j);
                i++;
                j--;
            } else if (arr[i] < 0 && arr[j] < 0) {
                i++;
            } else if(arr[i] < 0 && arr[j] > 0) {
                j--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
