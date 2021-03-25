package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MinimizeTheHeight {

    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 10};
        int arr1[] = {3, 9, 12, 16, 20};
        int arr2[] = {5, 5, 8, 6, 4, 10, 3, 8, 9, 10}; //5, 10
        int arr3[] = {4, 2, 3, 6};
        MinimizeTheHeight obj = new MinimizeTheHeight();
        System.out.println(obj.getMinDiff(arr3, 4, 3));
        Arrays.stream(arr3).forEach(System.out::print);

    }


    private int minimizeHeight(int[] arr, int n, int k) {
        Arrays.sort(arr);

        int ans = arr[n-1] - arr[0];
        int small = arr[0] + k;
        int big = arr[n-1] - k;

        if (small > big) { //swap
            big = big + small;
            small = big - small;
            big = big - small;
        }

        for (int i = 1; i < n -1; i++) {
             int add = arr[i] + k;
             int sub = arr[i] - k;

             if(sub >= small || add <= big) {
                 continue;
             }

             if(big - sub  <= add - small) {
                small = sub;
             } else {
                 big = add;
             }
        }

        return Math.min(ans, big - small);
    }


    private int getMinDiff(int arr[], int n, int k) {
        List<Pair> possibleHeights = new ArrayList<>();
        int[] visited = new int[n];
        for (int index = 0; index < n; index++) {
            if(arr[index] - k >= 0) {
                possibleHeights.add(new Pair(arr[index] - k, index));
            }
            possibleHeights.add(new Pair(arr[index] + k, index));
            visited[index] = 0;
        }
        possibleHeights = possibleHeights.stream()
                .sorted(Comparator.comparingInt(Pair::getValue))
                .collect(Collectors.toList());
        
        int ele = 0;
        int left = 0, right = 0;
        int size = possibleHeights.size();

        while (ele < n && right < size) {
            if (visited[possibleHeights.get(right).getIndex()] == 0) {
                ele++;
            }
            visited[possibleHeights.get(right).getIndex()]++;
            right++;
        }

        int ans = possibleHeights.get(right - 1).getValue() - possibleHeights.get(left).getValue();

        while (right < size) {
            if (visited[possibleHeights.get(left).getIndex()] == 1) {
                ele--;
            }
            visited[possibleHeights.get(left).getIndex()]--;
            left++;

            while (ele < n && right < size) {
                if (visited[possibleHeights.get(right).getIndex()] == 0) {
                    ele++;
                }
                visited[possibleHeights.get(right).getIndex()]++;
                right++;
            }

            if(ele == n) {
                ans = Math.min(ans, possibleHeights.get(right - 1).getValue() - possibleHeights.get(left).getValue());
            } else {
                break;
            }
        }

        return ans;
    }

}


class Pair {
    private int value;
    private int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}