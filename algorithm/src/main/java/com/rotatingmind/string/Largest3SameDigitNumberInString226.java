package com.rotatingmind.string;

public class Largest3SameDigitNumberInString226 {

    public String largestGoodInteger(String num) {
        int w = 3;
        String largestGoodInteger = "";
        String s = num.substring(0, w);
        boolean isSame = s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2);

        if (isSame) {
            largestGoodInteger = s;
        }

        int n = num.length();

        for (int i = w; i < n; i++) {
            s = num.substring(i - w + 1, i + 1);
            isSame = s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2);

            if (isSame && !largestGoodInteger.isEmpty()) {
                if (s.charAt(0) > largestGoodInteger.charAt(0)) {
                    largestGoodInteger = s;
                }
            } else if (isSame) {
                largestGoodInteger = s;
            }
        }

        return largestGoodInteger;
    }

    public static void main(String[] args) {
        Largest3SameDigitNumberInString226 obj = new Largest3SameDigitNumberInString226();
        System.out.println(obj.largestGoodInteger("6777133339"));
    }
}
