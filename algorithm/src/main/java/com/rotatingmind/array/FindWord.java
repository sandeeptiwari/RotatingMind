package com.rotatingmind.array;

//["R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"] = PORTUGAL
public class FindWord {

    public static void main(String[] args) {
        String arr[] = {"R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"};
        System.out.println(buildWord(arr));
    }

    private static String buildWord(String[] arr) {
        int len = arr.length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            String []curr = arr[i].split(">");
            if (builder.length() == 0) {
                mutate(curr[0], builder);
                mutate(curr[1], builder);
            } else {
                for (int j = 0; j < builder.length(); j++) {
                        
                }
            }

        }
        return builder.toString();
    }

    private static void mutate(String str, StringBuilder builder) {
        if (!builder.toString().contains(str)) {
            builder.append(str);
        }
    }
}
