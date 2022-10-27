package ocp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Deer {
    public Deer() {
        System.out.print("Deer");
    }
    public Deer(int age) {
        System.out.println("DeerAge");
    }
    protected boolean hasHorns() {return false;}
}
public class Reindeer extends Deer {

    public Reindeer(int age) {
        System.out.print("Reindeer");
    }

    public boolean hasHorns() {return true;}

    public static void main(String[] args) {
        //Deer deer = new Reindeer(5);
        //System.out.print(","+ deer.hasHorns());
        whatPrintedBy();
    }

    private static void whatPrintedBy() {
        int[] array = {6,9,8};
        List<Integer> list = new ArrayList<>();
        list.add(array[0]);
        list.add(array[2]);
        list.set(1, array[1]);
        list.remove(0);
        System.out.println(list);
        System.out.println("C" + Arrays.compare(array,
                new int[] {6, 8, 9}));
        System.out.println("M" + Arrays.mismatch(array,
                new int[] {6, 9, 8}));
    }
}
