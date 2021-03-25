package stream_advance;

import stream_advance.util.WrapperVegetable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateElementFromList {

    /**
     * List<Employee> unique = employee.stream()
     *                                 .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingInt(Employee::getId))),
     *                                                            ArrayList::new));
     * @param args
     */
    public static void main(String[] args) {
        RemoveDuplicateElementFromList obj = new RemoveDuplicateElementFromList();
        List<Vegetable> vegetables = obj.getVegs();
        List<Vegetable> filterList = vegetables.stream()
                .map(WrapperVegetable::new)
                .distinct()
                .map(WrapperVegetable::unwrap)
                .collect(Collectors.toList());
        System.out.println(filterList);
    }

    private List<Vegetable> getVegs() {
        return Arrays.asList(
                new Vegetable(1, "spinach", "leafy"),
                new Vegetable(1, "spinach", "leafy"),
                new Vegetable(1, "spinach", "leafy"),
                new Vegetable(2, "bottle gourd", "gourd"),
                new Vegetable(2, "bottle gourd", "gourd")
        );
    }
}
