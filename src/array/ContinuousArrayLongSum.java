package array;

public class ContinuousArrayLongSum {

    public static void main(String[] args) {
        int arr[] = {1,2,3,-2,5};
        ContinuousArrayLongSum  longSum = new ContinuousArrayLongSum();
//        System.out.println(longSum.longestSum1(arr));
//        System.out.println(longSum.longestSum2(arr));
//        System.out.println(longSum.longestSum3(arr));
        longSum.dynamicSetVal(10, 10);
    }

    public int longestSum1(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = 0;
                for (int k = 0; k < len; k++) {
                    sum += arr[k];
                }
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
    public int longestSum2(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += arr[j];
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
    public int longestSum3(int[] arr) {
        int max = arr[0];
        int maxSoFar = arr[0];
        int len = arr.length;

        for (int i = 1; i < len; i++) {
             maxSoFar =  Math.max(arr[i], maxSoFar + arr[i]);
             max = Math.max(max, maxSoFar);
        }

        return max;
    }

    public void dynamicSetVal(int x, int y) {
        if(x == y) {
            System.out.println("Equal");
        }
    }
}
