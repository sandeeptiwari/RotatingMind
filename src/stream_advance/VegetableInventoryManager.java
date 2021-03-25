package stream_advance;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VegetableInventoryManager {


    public static List<List<Vegetable>> load() {
        List<List<Vegetable>> inventories = new ArrayList<>();

        //leafy - 0
        Vegetable v1 = new Vegetable(1000, "spinach", "leafy");
        Vegetable v2 = new Vegetable(1001, "red spinach", "leafy");
        Vegetable v3 = new Vegetable(1002, "fenugreed", "leafy");
        Vegetable v4 = new Vegetable(1003, "coriander", "leafy");
        List<Vegetable> leafyList = new ArrayList<>(Arrays.asList(v1, v2, v3, v4));
        inventories.add(leafyList);

        //gourd - 1
        Vegetable g1 = new Vegetable(2000, "bottle gourd", "gourd");
        Vegetable g2 = new Vegetable(2001, "bitter gourd", "gourd");
        Vegetable g3 = new Vegetable(2002, "sponge gourd", "gourd");
        Vegetable g4 = new Vegetable(2003, "snake gourd", "gourd");
        List<Vegetable> gourdList = new ArrayList<>(Arrays.asList(g1, g2, g3, g4));
        inventories.add(gourdList);

        //gourd- 2
        Vegetable s1 = new Vegetable(3000, "cucumber", "salad");
        Vegetable s2 = new Vegetable(3002, "radish", "salad");
        Vegetable s3 = new Vegetable(3003, "carrot", "salad");
        Vegetable s4 = new Vegetable(3004, "turnip", "salad");
        List<Vegetable> salads = new ArrayList<>(Arrays.asList(s1, s2, s3, s4));
        inventories.add(salads);

        //gobhi - 3
        Vegetable go1 = new Vegetable(4000, "cabage", "gobhi");
        Vegetable go2 = new Vegetable(4001, "qualiflower", "gobhi");
        Vegetable go3 = new Vegetable(4002, "braccoli", "gobhi");
        List<Vegetable> gobhies = new ArrayList<>(Arrays.asList(go1, go2, go3));
        inventories.add(gobhies);

        //ground - 4
        Vegetable ground1 = new Vegetable(5000, "potato", "ground");
        Vegetable ground2 = new Vegetable(5001, "sweet potato", "ground");
        Vegetable ground3 = new Vegetable(5002, "Yam", "ground");
        Vegetable ground4 = new Vegetable(5003, "beat", "ground");
        Vegetable ground5 = new Vegetable(5004, "taro", "ground");
        List<Vegetable> groundList = new ArrayList<>(Arrays.asList(ground1, ground2, ground3, ground4, ground5));
        inventories.add(groundList);

        //pepper - 5
        Vegetable p1 = new Vegetable(6000, "green chilli", "pepper");
        Vegetable p2 = new Vegetable(6001, "red chilli", "pepper");
        Vegetable p3 = new Vegetable(6002, "capsicum", "pepper");
        List<Vegetable> peppers = new ArrayList<>(Arrays.asList(p1, p2, p3));
        inventories.add(peppers);

        return inventories;
    }


    public static void main(String[] args) {
        List<List<Vegetable>> inventories = load();
        //System.out.println(inventories);
        System.out.println("===============================================================================================================");
        List<List<Vegetable>> refinedInventories = removeUnwantedRecords(inventories, Arrays.asList(2, 3, 1));

        Map<String, List<Vegetable>> map = refinedInventories
                .stream()
                //.peek(System.out::println)
                .collect(
                        Collectors
                                .toMap(ele -> ele.get(0)
                                        .getCategory(),
                                        Function.identity())
                    );


        testFlatMap();
        //System.out.println(map);
    }

    private static List<List<Vegetable>> removeUnwantedRecords(List<List<Vegetable>> datalst, List<Integer> removeIndex) {
        datalst.stream().
                forEach(list -> list.removeAll(removeIndex.stream()
                .filter(index -> index < list.size())
                        .map(list::get)
                        .collect(Collectors.toList()))
                );

        return datalst;
    }

    /*
     * 1- favor generic to raw types ( List<List<?>> rather than List<List>)
     * 2- don't collect if you want to change the state of the input lists
     *    But removing an element at a specified index changes the index (index=index-1) of all elements after it.
     *    To avoid that caveat you could process the list that contains indexes to remove in a descending order.
     * 3- List.remove(int) is a straight way to remove an element by index but we cannot pass any int value in.
     *    Indeed passing a int parameter out of bounds of the list throws an exception. So it has to be considered.
     */
    private static List<List<Vegetable>> removeUnwantedRecordsV2(List<List<Vegetable>> datalst, List<Integer> removeIndex) {
         removeIndex.stream()
                 .sorted(Comparator.reverseOrder())
                 .mapToInt(i -> i)
                 .forEach(index -> removeElement(index, datalst));

         return datalst;
    }

    private static void removeElement(int index, List<List<Vegetable>> datalst) {
        datalst.stream()
                .filter(ele -> index < ele.size())
                .forEach(ele -> ele.remove(index));
    }

    private static List<List<Vegetable>>
    removeUnwantedRecordsv1(List<List<Vegetable>> datalst, List<Integer> removeIndex ){
        datalst.forEach( row-> {
            for(int counter = 0 ; counter< removeIndex.size();counter++) {
                List<Vegetable> evenIndexedNames1 = IntStream
                        .range(0, row.size())
                        .filter(i -> i != 2 )
                        .mapToObj(i -> row.get(i))
                        .collect(Collectors.toList());

                evenIndexedNames1.forEach(str-> System.out.print(str));
            }
        });
        datalst.forEach(str-> System.out.println(str));
        return datalst;
    }


    public static void testFlatMap() {
        List<List<Vegetable>> inventories = load();

        Map<Integer, List<Vegetable>> maps = new HashMap<>();

        List<String> eles = inventories.stream().flatMap(Collection::stream)
                .map(ele -> ele.getName()).collect(Collectors.toList());

        maps.entrySet().stream().flatMap(ele -> ele.getValue().stream()).map(ele -> ele.getName());
        System.out.println(eles);
    }

}
