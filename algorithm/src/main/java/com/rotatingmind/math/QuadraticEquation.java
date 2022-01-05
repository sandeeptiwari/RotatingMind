package com.rotatingmind.math;

import java.util.ArrayList;
import java.util.List;

public class QuadraticEquation {


    public static void main(String[] args) {
        QuadraticEquation obj = new QuadraticEquation();
        obj.solution1(2, 8, 8).forEach(System.out::println);
    }


    public List<Integer> solution1(int a, int b, int c) {
        ArrayList<Integer> list = new ArrayList<>();

        double D = Math.pow(b, 2) - (4 * a * c);

        if(D < 0) {
            list.add(-1);
        } else {
            Double root1 = (-b + Math.sqrt(D)) / (2 * a);
            Double root2 = (-b - Math.sqrt(D)) / (2 * a);

            list.add(root1.intValue());
            list.add(root2.intValue());
        }

        return list;
    }

    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        ArrayList<Integer> roots = new ArrayList<Integer>();
        int root1 = 0, root2 = 0;
        // value of b^2-4ac
        int temp = (int)(Math.pow(b, 2) - 4 * a * c);

        // if b^2-4ac is less then zero then roots are imaginary
        if (temp < 0)
            roots.add(-1);
        else {
            // calculate root1 and root2 using fomula
            // Math.floor method returns greatest integer below ( -b + sqrt(temp) )
            // Math.sqrt method returns square root of temp
            // (int) converts returned value type to integer
            root1 = (int)Math.floor((-1 * b + Math.sqrt(temp)) / (2 * a));
            root2 = (int)Math.floor((-1 * b - Math.sqrt(temp)) / (2 * a));
            // store both roots calculated in List
            // Math.max method returns greater value between root1 and root2
            // Math.min method returns smaller value between root1 and root2
            roots.add(Math.max(root1, root2));
            roots.add(Math.min(root1, root2));
        }
        return roots;
    }
}
