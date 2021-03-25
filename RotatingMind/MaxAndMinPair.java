public class MaxAndMinPair {
//Input : A[] = {1, 5, 9, 7, 1, 9, 4}
// Output : 2, {1, 9}

    public static void main(String...args){
        int arr[] = {2, 2, 2, 2, 2, 2, 2};//{1, 5, 9, 7, 1, 9, 4};
        getMinMaxSubArray(arr);
    }

    public static void getMinMaxSubArray(int []arr){
        int minCount = 0;
        int maxCount = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        int len = arr.length;
        for (int index = 0; index < len; index++) {
            int ele = arr[index];

            if(ele < min){
                min = ele;
            }else if(max < ele){
                max = ele;
            }
        }

        for (int i = 0; i < len; i++) {
            int ele = arr[i];
            if(min == max) {
                minCount = maxCount = 1;
                break;
            }
            if(ele == min){
                minCount++;
            }
            if(ele == max){
                maxCount ++;
            }
        }
        System.out.print("{ "+min+", "+max+" } occurs "+(minCount == maxCount ? minCount : Math.min(minCount, maxCount)));
    }
}
