package array;

import java.util.Arrays;

public class MinMaxInArray {

    public static void main(String[] args) {
        int arr[] = { 1000, 11, 445,
                1, 330, 3000 };
        MinMaxInArray minMaxInArray = new MinMaxInArray();
        System.out.println(minMaxInArray.minVal1(arr));
    }

    public int minVal(int[] inputs) {
        return Arrays.stream(inputs).sorted().findFirst().getAsInt();
    }
    public int minVal1(int[] inputs) {
        int min = inputs[0];
        int max = Integer.MAX_VALUE;

        for (int index = 0; index < inputs.length; index++) {
            if(max < min) {
                min = max;
            }
            max = inputs[index];
        }
        return min;
    }

    public int maxVal(int[] inputs) {
        return -1;
    }
}
