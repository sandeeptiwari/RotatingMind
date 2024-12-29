package com.rottaingmind.ds.recursion;

public class PlayWithRecursion {

    public static void main(String[] args) {
        PlayWithRecursion recursion = new PlayWithRecursion();
        // System.out.println(recursion.sum(5));
        // System.out.println(recursion.fastPow(5, 3));
        // System.out.println(recursion.path(2, 2));
        /*int a[][] = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1}
        };
        recursion.floodFill(a, 4, 3, 3, 2);
        recursion.printMatrix(a);*/

        String s = "sandeep";

        System.out.println();

       // recursion.permutations("abc", 0, 2);

        int a[] = {1, 5, 7, 3, 2, 4};
        System.out.println(recursion.coinMax(a, 0, 5));
    }

    /**
     * Find sum of N natural number.
     * sum(n) = sum(n-1) + n;
     */
    public int sum(int num) {
        if (num == 1) {
            return 1;
        }
        return sum(num - 1) + num;
    }

    /**
     * Find power using recursion.
     * 2^2 = 2 * 2^(2-1) = 4
     * 2^3 = 2 * (2^(3-1))
     * = 2 * 2 * 2^2-1 = 8
     * pow(n, p) = n + n * pow(n-1);
     */
    public int pow(int base, int power) {
        if (power == 0) {
            return 1;
        }
        return base * pow(base, power - 1);
    }

    public int fastPow(int base, int power) {
        if (power == 0) {
            return 1;
        }
        if (power % 2 == 0) {
            return fastPow(base * base, power / 2);
        } else {
            return base * fastPow(base, power - 1);
        }
    }

    public int path(int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        }
        return path(n, m - 1) + path(n, m - 1);
    }

    public void floodFill(int a[][], int r, int c, int toFill, int prevFill) {
        int rows = a.length;
        int columns = a[0].length;

        if (rows <= r || r < 0 || c < 0 || c >= columns) {
            return;
        }
        if (a[r][c] != prevFill) {
            return;
        }
        a[r][c] = toFill; // fill the connected boxes

        floodFill(a, r - 1, c, toFill, prevFill); //top connected box in matrix
        floodFill(a, r, c - 1, toFill, prevFill); // left connected box in matrix
        floodFill(a, r + 1, c, toFill, prevFill); //bottom connected box in matrix
        floodFill(a, r, c + 1, toFill, prevFill);// right connected box in matrix
    }

    public void printMatrix(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.print("\n");
        }
    }

    public void permutations(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
            return;
        }

        for (int i = l; i <= r; i++) {
            s = interChangeChar(s, l, i);
            permutations(s, l + 1, r);
            s = interChangeChar(s, l, i);
        }
    }

    private String interChangeChar(String s, int l, int i) {
        char[] arr = s.toCharArray();
        char temp = arr[l];
        arr[l] = arr[i];
        arr[i] = temp;
        return String.valueOf(arr);
    }

    /**
     * a = { 1, 5, 7, 3}
     *
     *                   (2, 3)
     *     / a[0] + min{
     * max               (1, 2)
     *     \            (0, 1)
     *      a[3] + min{
     *                  (1, 2)
     */
    public int coinMax(int a[], int l, int r) {
        if (l + 1 == r) {
            return Math.max(a[l], a[r]);
        }
        return Math.max(a[l] + Math.min(
                coinMax(a, l + 2, r),
                coinMax(a, l + 1, r - 1)),
                a[r] + Math.min(
                        coinMax(a, l + 1, r - 1),
                        coinMax(a, l, r - 2)
                ));
    }
}
