package com.rotatingmind.two_pointer;

public class FindAllPairOfSum {


    public int numOfPossiblePair(int[] arr, int target) {

        int ans = 0, i = 0, j = (arr.length - 1);

        while (i < j) {

            if (arr[i] + arr[j] > target) {
                j--;
            } else if (arr[i] + arr[j] < target) {
                i--;
            } else {
                if (arr[i] == arr[j]) {
                    int l = j - i + 1;
                    ans += l * (l - 1) / 2;
                    break;
                }
                int v1 = arr[i], v2 = arr[j], c1 = 0, c2 = 0;

                while (arr[i] == v1) {
                    i++;
                    c1++;
                }
                while (arr[j] == v2) {
                    j--;
                    c2++;
                }
                ans += (c1 * c2);
            }
        }
        return ans;
    }
}
