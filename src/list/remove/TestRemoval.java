package list.remove;

import stream_advance.Vegetable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRemoval {

    public static void main(String[] args) {
        Vegetable v1 = new Vegetable(1000, "spinach", "leafy");
        Vegetable v2 = new Vegetable(1001, "red spinach", "leafy");
        Vegetable v3 = new Vegetable(1002, "fenugreed", "leafy");
        Vegetable v4 = new Vegetable(1003, "coriander", "leafy");
        List<Vegetable> leafyList = new ArrayList<>(Arrays.asList(v1, v2, v3, v4));

       // Vegetable vn = new Vegetable(1000, "spinach", "leafy");

       // System.out.println(leafyList.remove(v2));

       // System.out.println(leafyList);
    }
}
