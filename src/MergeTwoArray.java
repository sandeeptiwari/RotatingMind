import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MergeTwoArray {

    public static void main(String...args){
       /* MergeTwoArray merge = new MergeTwoArray();
        int a[] = {1, 5, 8, 11};
        int b[] = {2, 4, 10, 14};
        merge.toMerge(a, b);*/
        int ar[] ={10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.print(sockMerchant(9, ar));
    }


    public void toMerge(int[] arr1, int[] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i = 0, j =0, k= 0;
        int result[] = new int[len1 + len2];

        while (i < len1 && j < len2){

            result[k++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
        }

        while (i < len1){

            result[k++] = arr1[i++];
        }

        while (j < len2){

            result[k++] = arr2[j++];
        }

        for (int index = 0; index < result.length; index++) {
            System.out.print(" "+result[index]);
        }
    }

    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        HashSet< Integer > socks = new HashSet<>();
        for( int sock : ar )
            if( !socks.add( sock ) )
            {
                pairs++;
                socks.remove( sock );
            }

        return pairs;
    }
}
