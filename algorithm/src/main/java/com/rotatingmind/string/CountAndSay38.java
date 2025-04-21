package com.rotatingmind.string;

public class CountAndSay38 {

    public String countAndSay1(int n) {

        StringBuilder result = new StringBuilder();
        int i = 1;

        while (i <= n) {
            if (i == 1) {
                result.append(i);
            } else {
                int len = result.length();
                StringBuilder temp = new StringBuilder();

                for (int j = 0; j < len;) {
                    int index = result.charAt(j) - '0';
                    int k = index;
                    int freq = 1;
                    while(index == k && j + 1 < len) {
                        k = result.charAt(j + 1) - '0';
                        if (index == k) {
                            freq++;
                            j++;
                        }
                    }
                    temp.append(freq).append(index);
                    j++;
                }
                result = temp;
            }
            i++;
        }
        return result.toString();
    }


    public String countAndSay(int n) {
        if (n == 1) return "1";

        StringBuilder result = new StringBuilder();

        String say = countAndSay(n - 1);
        for (int i = 0; i < say.length(); i++) {
            int freq = 1;
            char ch = say.charAt(i);
            while(i < say.length() - 1 && say.charAt(i) == say.charAt(i + 1)) {
                freq++;
                i++;
            }
            result.append(freq).append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        CountAndSay38 countAndSay38 = new CountAndSay38();
        String res = countAndSay38.countAndSay(20);
        System.out.println("res: " + res);
    }

}
