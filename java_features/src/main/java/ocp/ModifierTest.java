package ocp;

import java.util.Comparator;
import java.util.List;

public abstract class ModifierTest {
    /**
     * /*
     *       null and final
     * abstract and private
     * public and private
     * nonstatic and abstract
     * private and final
     * abstract and static
     * protected and abstract
     */
    // private abstract void test(); //not allowed

    private final void test1() {};//remove final private method declare as final

    // public abstract static void test2();

    protected abstract void test3();

    public static void main(String[] args) {
        int multiplier = 1;
        multiplier *= -1;
        List<Integer> list = List.of(99, 66, 77, 88);
        //Exception in thread "main" java.lang.UnsupportedOperationException

        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}
