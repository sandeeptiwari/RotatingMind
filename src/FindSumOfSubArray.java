import java.util.stream.IntStream;
import java.util.stream.Stream;

//Given an Array: [5, 10, 4, 0, 2, 4, 6, 31, 6, 6, 8, 5, 1, 2, 3 ],
// find the number that is sum of its left and right subarrays.
public class FindSumOfSubArray {

    public int sumOfArray(int[] input) {
        return IntStream.of(input).sum();
    }

    public int findEle(int[] input) {
        int first = 0;
        int last = input.length;

        //while (first < last) {
            int mid = (first + last) / 2;

            if (last == 1) {
                return -1;
            }

            int [] left = new int[mid];
            int [] right = new int[input.length - mid];

            for (int i = 0; i < mid; i++) {
                left[i] = input[i];
            }
            if(input[mid] == sumOfArray(left)) {
                return input[mid];

            }
            for (int i = 0; i < (input.length - mid); i++) {
                right[i] = input[mid + i];
            }

            if(input[mid] == sumOfArray(right)) {
                return input[mid];
            }
            findEle(left);
            findEle(right);
       // }
        return -1;
    }


    private int findEquilibriumIndex(int[] input) {
        int leftSum = 0, rightSum = 0;

        rightSum = IntStream.of(input).sum();

        for (int i = 0; i < input.length; i++) {
            rightSum -= input[i];
            if(leftSum == rightSum) {
                return i;
            }
            leftSum += input[i];
        }
      return -1;
    }

    private int bruteFirstFindIndex(int[] input) {
        int len = input.length;


        for (int i = 0; i < len; i++) {
            int rSum = 0, lSum = 0;

            for (int j = 0; j < i; j++)
                lSum += input[j];

            for (int k = i+1; k < len; k++)
                rSum += input[k];

                if(lSum == rSum) {
                    return i;
                }
        }
        return -1;
    }

    public static void main(String...args) {
        int arr[] = {5, 10, 4, 0, 2, 4, 6, 31, 6, 6, 8, 5, 1, 2, 3};
        FindSumOfSubArray findSumOfSubArray = new FindSumOfSubArray();
        //System.out.println(findSumOfSubArray.findEle(arr));
        int index1 = findSumOfSubArray.findEquilibriumIndex(arr);
        int index = findSumOfSubArray.bruteFirstFindIndex(arr);
        System.out.println("Equilibrium index is "+index+" Equilibrium value is "+arr[index]);
    }
}
