package com.rotatingmind.exception;

import java.io.*;

public class TryCatchSyntax {

    /**
     * I also have some problems about that. So try Edit Configurations.
     * You can find it at Run -> Edit Configurations..
     * Then edit Working directory to where your file locates.
     * By the way, you can edit it to base directory and add path in your code.
     * @param args
     */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("basic_try_demo.txt"))) {
            //read the line
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } /*catch (FileNotFoundException e) {
            System.err.format("FileNotFoundException: %s%n", e);
        }*/ catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        test1();
    }


    public static void test1() {
        StringBuilder sb = new StringBuilder();
        String str = null;
        try {
            sb.append("a");
            str.toUpperCase();
            sb.append("b");
        } catch (IllegalArgumentException ie) {
            sb.append("c");
            System.err.format("IllegalArgumentException: %s%n", ie);
        } catch (Exception e) {
            sb.append("d");
        }finally {
            sb.append("e");
        }

        System.out.println(sb);
    }
}
