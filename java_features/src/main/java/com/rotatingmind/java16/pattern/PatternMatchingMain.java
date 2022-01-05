package com.rotatingmind.java16.pattern;

public class PatternMatchingMain {

    public static void main(String[] args) {
        Record o = new Person("Sandeep");

        // Person o = new Person("Sandeep"); // its always true
       /*
         * o instanceof Person p || p.name().startsWith("S") then it will give compile time error
         * because in OR operator it will even-though checks second part if first part doesn't
         * correct while in and second check ignored if first check doesnt correct.
        */
        if (o instanceof Person p && p.name().startsWith("S")) {
            System.out.println(p.name());
        }

        /* Case - 2
           Now p no longer cast into person because if block negation is falsy
           so we have to put and else block which means that P is available in else section
         */

        if (!(o instanceof Person p)) {
            System.out.println("p is not available here, because its in negation");
        } else {
            System.out.println(p.name());
        }
    }
}
