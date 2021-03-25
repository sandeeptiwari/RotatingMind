import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Stream;

public class TestCommon {

    public void reverse(int start, int end, int[] arr){
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }

    public static int maxSum(int[] arr){
        int len = arr.length;
        int maxSum = 0, currentSum = 0;

        for (int i = 1; i < len; i++) {

            currentSum+=arr[i];

            if(arr[i] < 0){
                currentSum = 0;
            }
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    public static void main(String...args){
        int arr[] = {10, 20, 30, 40, 50, 60};
        int arr1[] = {1, -2, 3, 4, -4, 6, -14, 8, 2};
        /*int k = 2;
        TestCommon common = new TestCommon();
        common.reverse(0, k -1, arr);
        common.reverse(k, arr.length - 1 , arr);
        common.reverse(0, arr.length - 1, arr);

        Arrays.stream(arr).forEach(System.out::println);*/

        System.out.print(TestCommon.maxSum(arr1));
    }
}
