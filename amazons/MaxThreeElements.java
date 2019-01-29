public class MaxThreeElements {

    public static void main(String...args){
        int k = 3;// 9910678434
        int temp = 0;

        int arr[] = {1, 23, 12, 9, 30, 2, 50};
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if(arr[i] < arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(arr[i]);
        }

    }
}
