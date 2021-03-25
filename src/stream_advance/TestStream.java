package stream_advance;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestStream {

    public static void main(String[] args) {
        Vegetable v1 = new Vegetable(1000, "spinach", "leafy");
        Vegetable v2 = new Vegetable(1001, "red spinach", "leafy");
        Vegetable v3 = new Vegetable(1002, "fenugreed", "leafy");
        Vegetable v4 = new Vegetable(1003, "coriander", "leafy");
        Vegetable v5= new Vegetable(500, "spinach2", "leafy");
        List<Vegetable> vegs = Arrays.asList(v1, v2, v3, v4, v5);

        Predicate<Vegetable> isLessthan = vegetable -> vegetable.getId() < 1002;
        Predicate<Vegetable> startsWithS = vegetable -> vegetable.getName().startsWith("s");


        List<String> vegs2  = vegs.stream()
                .map(vegetable -> vegetable.getName())
                .sorted()
                .collect(Collectors.toList());

        //System.out.println("vegs1 name "+ vegs2);


        List<Map<String, String>> peoples = new ArrayList<>();
        Map<String,String> map = new HashMap<String, String>();
        Map<String,String> map1 = new HashMap<String, String>();
        map.put("Name", "Andy");
        map.put("Surname", "Smith");
        map.put("Age", "17");

        map1.put("Name", "Sandeep");
        map1.put("Surname", "Smith");
        map1.put("Age", "17");

        peoples.add(map);
        peoples.add(map1);

        List<String> allNames = new ArrayList<>();

        peoples.forEach(ele -> {
            List<String> names = ele.entrySet()
                            .stream()
                            .filter(ele2 -> ele2.getKey().equals("Name"))
                           .map(ele1 -> ele1.getValue())
                            .collect(Collectors.toList());
            allNames.addAll(names);
        });

        List<String> names =  peoples.stream()
                .map(ele -> ele.entrySet())
                .flatMap(ele -> ele.stream())
                .filter(ele -> ele.getKey().equals("Name"))
                .map(ele -> ele.getValue())
                .collect(Collectors.toList());

        System.out.println(allNames);
    }
}
