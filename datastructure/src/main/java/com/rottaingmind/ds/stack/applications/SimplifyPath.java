package com.rottaingmind.ds.stack.applications;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * Given an absolute path for a Unix-style file system, which begins with a slash '/', transform this path into its simplified canonical path.
 * <p>
 * In Unix-style file system context, a single period '.' signifies the current directory, a double period ".." denotes moving up one directory level, and multiple slashes such as "//" are interpreted as a single slash. In this problem, treat sequences of periods not covered by the previous rules (like "...") as valid names for files or directories.
 * <p>
 * The simplified canonical path should adhere to the following rules:
 * <p>
 * It must start with a single slash '/'.
 * Directories within the path should be separated by only one slash '/'.
 * It should not end with a slash '/', unless it's the root directory.
 * It should exclude any single or double periods used to denote current or parent directories.
 * Return the new path.
 * Example 1:
 * <p>
 * Input: path = "/home/"
 * <p>
 * Output: "/home"
 * <p>
 * Explanation:
 * <p>
 * The trailing slash should be removed.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: path = "/home//foo/"
 * <p>
 * Output: "/home/foo"
 * <p>
 * Explanation:
 * <p>
 * Multiple consecutive slashes are replaced by a single one.
 * <p>
 * Example 3:
 * <p>
 * Input: path = "/home/user/Documents/../Pictures"
 * <p>
 * Output: "/home/user/Pictures"
 * <p>
 * Explanation:
 * <p>
 * A double period ".." refers to the directory up a level.
 * <p>
 * Example 4:
 * <p>
 * Input: path = "/../"
 * <p>
 * Output: "/"
 * <p>
 * Explanation:
 * <p>
 * Going one level up from the root directory is not possible.
 * <p>
 * Example 5:
 * <p>
 * Input: path = "/.../a/../b/c/../d/./"
 * <p>
 * Output: "/.../b/d"
 * <p>
 * Explanation:
 * <p>
 * "..." is a valid name for a directory in this problem.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid absolute Unix path.
 */
public class SimplifyPath {

    public static String getAbsolutePath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        int n = path.length();

        for (int i = 0; i < n + 1; i++) {
            if ((i == n || path.charAt(i) == '/') && !builder.isEmpty()) {
                String dir = builder.toString();

                if (dir.equals("..") && !stack.isEmpty()) {
                    stack.pop();
                } else if (!dir.equals("..") && !dir.equals(".")) {
                    stack.push(dir);
                }
                builder.setLength(0);
            } else if (i < n && path.charAt(i) != '/') {
                builder.append(path.charAt(i));
            }
        }

        String res = "";

        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }

        return res;
    }

    public static String simplifyPath(String path) {

        String tokens[] = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!stack.isEmpty() && "..".equals(tokens[i])) {
                stack.pop();
            } else if (!Arrays.asList(".", "..", "").contains(tokens[i])) {
                stack.push(tokens[i]);
            }
        }

        String str[] = new String[stack.size()];
        int k = 0;
        while (!stack.isEmpty()) {
            str[k++] = stack.pop();
        }
        String temp = "";
        for (int i = str.length - 1; i >= 0; i--) {
            temp = temp + "/" + str[i];
        }
        return temp.length() == 0 ? "/" : temp;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        //System.out.println(getAbsolutePath("/../"));
        //System.out.println(getAbsolutePath("/.../a/../b/c/../d/./"));
        //System.out.println(getAbsolutePath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/")); //"/c"
    }
}
