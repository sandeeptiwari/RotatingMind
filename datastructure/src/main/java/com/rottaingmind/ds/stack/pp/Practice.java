package com.rottaingmind.ds.stack.pp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Practice {

    public static void main (String[] args) throws java.lang.Exception
    {
        Practice p = new Practice();
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputlong = "5";//br.readLine();

        int n = Integer.parseInt(inputlong);

        Deque<Integer> stack = new ArrayDeque<>();

        String[] s = {"1", "2", "3", "4", "5"};//br.readLine().split(" ");

        for (int i = 0; i < n; i++ )  {

            stack.push(Integer.parseInt(s[i]));
        }


        p.reverse(stack);

        for (int i = 0; i < n; i++ )  {
            System.out.print(stack.pop());
        }
    }

    public  void reverse(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int data = stack.pop();
        reverse(stack);
        pushBottom(data, stack);
    }

    public void pushBottom(int ele, Deque<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(ele);
            return;
        }

        int data = stack.pop();
        pushBottom(ele, stack);
        stack.push(data);
    }
}
