import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class TestMap {

    public static void main(String...args){
        // a Map with string keys and integer values
        Map<String, Integer> budget = new HashMap<>();
        budget.put("clothes", 120);
        budget.put("grocery", 150);
        budget.put("transportation", 100);
        budget.put("utility", 130);
        budget.put("rent", 1150);
        budget.put("miscellneous", 90);

       /* budget.entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(Collectors.toMap(e -> e.getKey(), e-> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new));*/
       float a1 = 4.0f;
       float a2 = 4.0f;
       //System.out.println(0.0 == 0.0);

        System.out.println(TestMap.m1());
    }

    public static int m1(){
        try{
            return 2;
        }finally {
            System.out.println("finally trumps return.");
            return 3;
        }
    }
}
