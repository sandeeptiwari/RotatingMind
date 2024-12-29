package com.rotatingmind.string;

public class ImplementStringContains extends Object {

    public static void main(String[] args) {
        ImplementStringContains obj = new ImplementStringContains();
        System.out.println("Find At " + obj.indexOf("NamanT Tiwari", "Tiwari"));
        System.out.println("NamanT Tiwari".contains("Tiwari"));
    }



    public int indexOf1(String srcStr, String targetStr) {

        if (srcStr != null && targetStr != null) {
            int diff = srcStr.length() - targetStr.length();
            char first = targetStr.charAt(0);
            for (int i = 0; i < diff; i++) {
                char currentChar = srcStr.charAt(i);
                if (currentChar != first) {
                     i = 0;
                    while (i < diff) i++;
                }
                // Found first character, now look at the rest of v2
                if (i <= diff) {
                    int j = i + 1;
                    int end = j  + targetStr.length() - 1;
                    for (int k = 1;
                         j < end && srcStr.charAt(j) == targetStr.charAt(k);
                         j++, k++) {
                        if (j == end - 1) {
                            // Found whole string.
                            return i;
                        }

                    }
                }
            }
        }
        return -1;
    }

    public int indexOf(String src, String trg) {
        if (src.length() == trg.length()) {
            return 0;
        }
        if (src.length() <= trg.length()) {
            return -1;
        }

        int diff = src.length() - trg.length();
        char first = trg.charAt(0);
        for (int i = 0; i < diff; i++) {
            char current = src.charAt(i);
            if (current != first) {
                while(i < diff) i++;
            }

            if (i <= diff) {
                int j = i + 1;
                int end = j + trg.length() - 1;
                for (int k = 1;
                     j < end && trg.charAt(k) == src.charAt(j);
                     k++, j++) {
                     if (j == end - 1 ) {
                         return i;
                     }
                }
            }
        }

        return -1;
    }












}
