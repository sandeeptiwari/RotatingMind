package com.rotatingmind;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Solve a given equation and return the value of 'x' in the form of a string "x=#value". The equation contains only '+', '-'
 * operation, the variable 'x' and its coefficient. You should return "No solution" if there is no solution for the equation,
 * or "Infinite solutions" if there are infinite solutions for the equation.
 *
 * If there is exactly one solution for the equation, we ensure that the value of 'x' is an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: equation = "x+5-3+x=6+x-2"
 * Output: "x=2"
 * Example 2:
 *
 * Input: equation = "x=x"
 * Output: "Infinite solutions"
 * Example 3:
 *
 * Input: equation = "2x=x"
 * Output: "x=0"
 *
 *
 * Constraints:
 *
 * 3 <= equation.length <= 1000
 * equation has exactly one '='.
 * equation consists of integers with an absolute value in the range [0, 100] without any leading zeros, and the variable 'x'.
 */
public class SolveTheEquation {

    public static int coffi(String x) {
        x = x.replaceAll("x", "");
        int count = 0;
        if (x.isEmpty())  {
            count = 1;
        } else if (x.length() == 1){
            if (x.contains("+")) {
                count = 1;
            } else if (x.contains("-")) {
                count = -1;
            } else {
                count = Integer.parseInt(x);
            }
        } else {
            count = Integer.parseInt(x);
        }
        return count;
    }

    public static String solveEquation(String equation) {

        //split equation by =
        String[] lr = equation.split("=");
        List<String> lhs = breakIt(lr[0]);
        List<String> rhs = breakIt(lr[1]);

        AtomicInteger lhsValue = new AtomicInteger(0);
        AtomicInteger lhsXCount = new AtomicInteger(0);
        lhs.forEach(ele -> {
            if (ele.contains("x")) {
                lhsXCount.addAndGet(coffi(ele));
            } else {
                lhsValue.addAndGet(Integer.parseInt(ele));
            }
        });

        AtomicInteger rhsValue = new AtomicInteger(0);
        AtomicInteger rhsXCount = new AtomicInteger(0);
        rhs.forEach(ele -> {
            if (ele.contains("x")) {
                rhsXCount.addAndGet(coffi(ele));
            } else {
                rhsValue.addAndGet(Integer.parseInt(ele));
            }
        });

        int rhsV = rhsValue.addAndGet(-(lhsValue.get()));
        int xCoffi = lhsXCount.addAndGet(-(rhsXCount.get()));
        String ans = "";

        if (xCoffi == 0 && rhsV == 0) {
            ans = "Infinite solutions";
        } else if (xCoffi == 0 && rhsV != 0) {
            ans = "No solution";
        } else {
            int xValue = rhsV / xCoffi;
            ans = "x=" + xValue;
        }

        return ans;
    }

    public static List <String> breakIt(String s) {
        List < String > res = new ArrayList < > ();
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (!r.isEmpty())
                    res.add(r);
                r = "" + s.charAt(i);
            } else
                r += s.charAt(i);
        }
        res.add(r);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Hello Iam good now ");
        //String ans = solveEquation("x+5-3+x=6+x-2");
        //String ans = solveEquation("x=x");
        //String ans = solveEquation("2x=x");
       //String ans = solveEquation("2x+3x-6x=x+2"); // -1
        //String ans = solveEquation("x=x+2"); // no solution
        String ans = solveEquation("1-x+x-x+x=-99-x+x-x+x"); // no solution



        System.out.println(ans);
    }


    public static int parseCoefficient(String term) {
        term = term.replaceAll("x", "");
        if (term.isEmpty() || term.equals("+")) {
            return 1;
        } else if (term.equals("-")) {
            return -1;
        } else {
            return Integer.parseInt(term);
        }
    }

    public static String solveEquationV1(String equation) {
        // Split equation by '='
        String[] sides = equation.split("=");
        int[] lhsResult = evaluateSide(sides[0]);
        int[] rhsResult = evaluateSide(sides[1]);

        // lhsResult[0] is the sum of coefficients of x
        // lhsResult[1] is the sum of constants
        int xCoefficient = lhsResult[0] - rhsResult[0];
        int constant = rhsResult[1] - lhsResult[1];

        if (xCoefficient == 0) {
            return (constant == 0) ? "Infinite solutions" : "No solution";
        }

        return "x=" + (constant / xCoefficient);
    }

    public static int[] evaluateSide(String side) {
        List<String> terms = breakTerms(side);
        int xCoefficient = 0;
        int constant = 0;

        for (String term : terms) {
            if (term.contains("x")) {
                xCoefficient += parseCoefficient(term);
            } else {
                constant += Integer.parseInt(term);
            }
        }

        return new int[]{xCoefficient, constant};
    }

    public static List<String> breakTerms(String side) {
        List<String> terms = new ArrayList<>();
        Matcher matcher = Pattern.compile("[+-]?[^-+]+").matcher(side);

        while (matcher.find()) {
            terms.add(matcher.group());
        }

        return terms;
    }

}
