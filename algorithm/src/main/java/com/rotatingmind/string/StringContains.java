package com.rotatingmind.string;

public class StringContains {

    public static boolean contains(String src, String target) {

        int len = src.length();
        int count = 0;
        boolean found = false;
        int k = 0;

        for (int i = 0; i < len; i++) {
            k = i;
            for (int j = 0; j < target.length(); j++) {
                if (src.charAt(k) != target.charAt(j)) {
                    break;
                } else {
                    count++;
                }
                k++;
            }

            if (count == target.length()) {
                found = true;
                break;
            } else {
                count = 0;
            }
        }
      return found;
    }

    /**
     * abc
     * @param src
     * @param token
     * @return
     */
    public static boolean contains1(String src, String token) {
        int l1 = src.length();
        int l2 = token.length();
        boolean found = true;

        for (int i = 0; i <= (l1 - l2); i++) {

            for (int j = i; j < i + l2 - 1; j++) {

                if (src.charAt(j) != token.charAt(j - i)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                break;
            }

        }
        return found;
    }


    public static void main(String[] args) {
        String s1 = "NavyaTiwari";
        String s2 = "vibha";

        boolean result = contains1(s1, s2);
        System.out.println(result);
    }
}
