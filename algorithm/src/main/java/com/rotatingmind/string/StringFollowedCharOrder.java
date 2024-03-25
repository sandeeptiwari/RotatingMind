package com.rotatingmind.string;

public class StringFollowedCharOrder {


    // Function to check if characters in the input string
    // follows the same order as determined by characters
    // present in the given pattern
    public static boolean checkPattern(String str, String pattern) {
        int n = pattern.length();
        int len = str.length();
        // if length of pattern is more than length of
        // input string, return false;
        if (str.length() < n)
        {
            return false;
        }

        for (int i = 0; i < n -1; i++) {
            // x, y are two adjacent characters in pattern
            int x = pattern.charAt(i);
            int y = pattern.charAt(i + 1);

            // find index of last occurrence of character x
            // in the input string
            int last = str.lastIndexOf(x);

            // find index of first occurrence of character y
            // in the input string
            int first = str.indexOf(y);

            // return false if x or y are not present in the
            // input string OR last occurrence of x is after
            // the first occurrence of y in the input string
            if (last == -1 || first == -1 || last > first)
            {
                return false;
            }
        }
        return true;
    }


    //axubbxcxbxd
    //abcd
    public static boolean doesFollowOrder(String source, String order) {
        boolean[] visited = new boolean[order.length()];
        boolean isFollowed = false;
        for (int i = 0; i < source.length(); i++) {

            if (!order.contains(source.charAt(i) + "")) continue;

            String curr = source.charAt(i) + "";
            if (isValidOrder(source, order, order.indexOf(curr), i)) {
                visited[order.indexOf(curr)] = true;
                isFollowed = true;
            } else  {
                isFollowed = false;
                break;
            }
        }

        return isFollowed;
    }

    public static boolean follow(String str, String pat) {
        int[] label = new int[260];
        for(int i=0;i<260;i++)
        {
            label[i] = -1;
        }
        int order = 1;
        for(int i=0;i<pat.length();i++)
        {
            label[pat.charAt(i)] = order;
            order++;
        }
        int lastOrder = -1;
        for (int i = 0; i < str.length(); i++)
        {
            if(label[str.charAt(i)] != -1)
            {
                if (label[str.charAt(i)] < lastOrder)
                    return false;
                lastOrder = label[str.charAt(i)];
            }
        }
        return true;
    }

    private static boolean isValidOrder(String source, String order, int index, int currIndex) {
        boolean isValid = false;
        if (currIndex == index) isValid = true;
        for (int i = 0; i < currIndex; i++) {
            if (!order.contains(source.charAt(i) + "")) continue;

            if (order.contains(source.charAt(i) + "") && order.indexOf(source.charAt(i)) > index) {
                isValid = false;
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
       String s1 = "engineers rock";
       String pattern = "er";
       String s2 = "axubbxcxbxd";
       String p2 = "abcd";
        String str = "engineers rock";
        String p3 = "gsr";
        boolean isFollow = follow(str, p3);
        System.out.println(isFollow);
    }
}
