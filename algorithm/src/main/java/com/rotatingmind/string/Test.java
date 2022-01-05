package com.rotatingmind.string;

public class Test {

    public static void main(String[] args) {
        System.out.println(contains("Io am a boy", "ab"));
    }

    public static boolean contains(String source, String target) {

        if (source.equals(target)) {
            return true;
        }

        int diff = source.length() - target.length();
        char first = target.charAt(0);
        for (int i = 0; i < diff; i++) {

            char currentChar = source.charAt(0);

            if (currentChar != first) {
                while(i < diff && currentChar != first) i++;
            }
            // Sandeep - San
            if (i <= diff) {
                int j = i + 1;
                int end = j + target.length() -1;

                for (int k = 1; j < end && target.charAt(k) == source.charAt(j); k++, j++) {

                    if (j == end - 1) {
                        return true;
                    }
                }

            }

        }
        return false;
    }
}
