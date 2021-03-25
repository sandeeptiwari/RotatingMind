package array;

import java.util.Arrays;

public class SortWithoutSortingLogic {

    public static void main(String[] args) {
        int arr[] = {0, 2, 1, 2, 0};
        SortWithoutSortingLogic obj = new SortWithoutSortingLogic();
        obj.toSort(arr);
        Arrays.stream(arr).boxed().forEach(System.out::print);
    }
    
    public void toSort(int []arr) {
        int len  = arr.length;
        long zeros = Arrays.stream(arr).filter( ele -> ele == 0).count();
        long ones =  Arrays.stream(arr).filter( ele -> ele == 1).count();
        long twos = Arrays.stream(arr).filter( ele -> ele == 2).count();

        for (int i = 0; i < len; i++) {
            if (i < zeros) {
                arr[i] = 0;
            } else if (i < (zeros + ones)) {
                arr[i] = 1;
            } else {
                arr[i] = 2;
            }
        }

    }
}
