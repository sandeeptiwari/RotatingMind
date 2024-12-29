package collection.map;

import java.util.HashMap;
import java.util.Map;

public class Country {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("US", "United State");
        map.put("US", "USA");
        map.put("India", "India");
        map.put(null, "France");

        System.out.println(map.size());
    }
}
