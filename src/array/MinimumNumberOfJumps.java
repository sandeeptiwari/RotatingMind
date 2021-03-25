package array;

public class MinimumNumberOfJumps {

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int arr1[] = {0, 1, 1, 1, 1};
        int arr2[] = {2, 1, 0, 3};
        int arr3[] = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        MinimumNumberOfJumps jumps = new MinimumNumberOfJumps();
        System.out.println(jumps.numberOfJumps(arr3, arr3.length));
    }

    public int numberOfJumps(int arr[], int n) {
        if (n <= 1) return 0;
        if (arr[0] == 0) return -1;
        int ladder = arr[0];
        int stairs = arr[0];
        int jump = 1;
        for (int level = 1; level < n; ++level) {
            if (level == n - 1) {
                return jump;
            }
            if (level + arr[level] > ladder) {
                ladder = level + arr[level];
            }
            stairs--;
            if (stairs == 0) {
                jump++;
                stairs = ladder - level;
                if (stairs == 0) return -1;
            }
        }
        return jump;
    }
}
