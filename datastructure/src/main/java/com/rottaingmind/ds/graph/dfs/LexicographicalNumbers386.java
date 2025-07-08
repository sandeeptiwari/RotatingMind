package com.rottaingmind.ds.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers386 {

    public List<Integer> lexicalOrder(int n) {

        List<Integer> result = new ArrayList<>();
        int curr = 1;

        for (int i = 0; i < n; i++) {
            result.add(curr);



            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr + 1 <= n && curr % 10 != 9) {
                curr += 1;
            } else {
                while ((curr / 10) > 0 && (curr % 10 == 9 || curr + 1 > n)) {
                    curr /= 10;
                }
                curr += 1;
            }
        }

        return result;
    }


    public List<Integer> lexicalOrderV1(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            solve(i, n, result);
        }


        return result;
    }

    private void solve(int curr, int n, List<Integer> result) {
        if (curr > n) {
            return;
        }

        result.add(curr);

        for (int append = 0; append <= 9; append++) {
            int newNUm = curr * 10 + append;
            if (newNUm > n) {
                return;
            }
            solve(newNUm, n, result);
        }
    }


    public List<Integer> lexicalOrderV2(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            solve1(i, n, result, 2);
        }


        return result;
    }

    private void solve1(int curr, int n, List<Integer> result, int k) {
        if (curr > n) {
            return;
        }

        if (curr == k) {
            result.add(curr);
            return;
        }

        for (int append = 0; append <= 9; append++) {
            int newNUm = curr * 10 + append;
            if (newNUm > n) {
                return;
            }
            solve(newNUm, n, result);
        }
    }


    public static void main(String[] args) {
        LexicographicalNumbers386 obj = new LexicographicalNumbers386();
        List<Integer> list = obj.lexicalOrderV1(13);
        System.out.println(list);
    }

}
