import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestString {


    public static void main(String...args){
        Random r = new Random();
        String s1 = "hi5";
        String s2 = "12345";
        String s3 = s1 + s2.length();

        //System.out.println(s1 == s3);

        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(11);
        list.add(30); list.add(9);
        list.removeIf(e -> e % 2 != 0);

        Integer arr[] = new Integer[0];//{1, 2, 3, 4};
        arr[0] = null;

        for(Integer i : arr)
        System.out.println(Instant.now());
    }
}
