package com.rottaingmind.ds.stack.applications.canonicalpath;

import java.util.Stack;

public class SimplifiedCanonicalPath {

    public String simplifiedCanonicalPath(String path) {
        int currPos = 1;
        Stack<String> stack = new Stack<>();

        while (currPos < path.length()) {
            StringBuilder str = new StringBuilder();
            char c = path.charAt(currPos);
            while (c != '/') {
                str.append(c);
                currPos++;
                if (currPos < path.length()) {
                    c = path.charAt(currPos);
                } else {
                    break;
                }
            }
            currPos++;

            if (str.length() != 0) {
                if (str.toString().equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }else if (str.toString().equals(".")) {

                } else {
                    stack.push(str.toString());
                }
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }


        StringBuilder res = new StringBuilder();
        for (String s : stack) {
            res.append('/');
            res.append(s);
        }
        return res.toString();
    }
}
