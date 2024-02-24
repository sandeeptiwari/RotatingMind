package com.rotatingmind.string;

public class StringOps {


    //A-65
    //a: 97
    public String toUpperCase(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if ((int)(ch[i]) >= 97 && (int)(ch[i]) <= 120) {
                ch[i] = (char)((int)(ch[i]) - 32);
            }
        }

        return new String(ch);
    }

    public String sort(String str) {
        int len = str.length();
        char[] a = str.toCharArray();
        int j = 0;
        for (int i = 1; i < len; i++) {
            j = i;
            while (j > 0 && a[j] < a[j - 1]) {
                int tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1 ] = (char)tmp;
                j--;
            }

        }
        return new String(a);
    }

    public static void main(String[] args) {
        StringOps obj = new StringOps();
        System.out.println(obj.toUpperCase("sAndeep"));
        System.out.println(obj.sort("badc"));
    }
}
