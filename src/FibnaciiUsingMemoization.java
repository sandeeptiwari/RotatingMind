import java.util.HashMap;
import java.util.Map;

public class FibnaciiUsingMemoization {
    Map<Integer, Integer> map = new HashMap<>();


    public int fib(int n){

        if(map.containsKey(n)){

            if(n <= 1)
                map.putIfAbsent(n, n);


            int val = fib(n - 1) + fib(n - 2);

            map.putIfAbsent(n, val);
        }

       return map.get(n);

    }

    public static void main(String...args){
        FibnaciiUsingMemoization fibonacci = new FibnaciiUsingMemoization();
        System.out.print(fibonacci.fib(5));
    }
}
