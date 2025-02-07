package com.rottaingmind.ds.dp.practice;

public class FabCh1 {

    /**
     * f(i) = f(i-2) + f(i-1)
     *
     * T(n)=T(n−1)+T(n−2)+O(1)
     *
     * Where:
     *
     * T(n-1) is the time taken for fib(n-1)
     * T(n-2) is the time taken for fib(n-2)
     * O(1) is the constant time taken for the base case and addition operation.
     *
     * For fib(n), the recursion tree expands as follows:
     *
     *                 fib(n)
     *                /      \
     *          fib(n-1)   fib(n-2)
     *          /      \     /      \
     *    fib(n-2)  fib(n-3) fib(n-3) fib(n-4)
     *    /    \
     * fib(n-3) fib(n-4)
     *
     * Each node represents a function call.
     * Each function call makes two more calls, leading to exponential growth in the number of calls.
     *
     *
     * Step 3: Counting the Number of Calls
     * The recursion tree forms a binary tree, where:
     *
     * The depth of the tree is approximately n (since each level reduces n by 1).
     * Each level doubles the number of calls.
     * At level k, there are approximately 2^k function calls.
     *
     * The total number of calls is approximately the sum of all nodes in the tree:
     *
     * T(n) ≈ 2^0 + 2^1 + 2^2 +⋯+2^n
     *
     *             k=0
     *   T(n) =    ∑   2^k
     *             n=v
     * Using the formula for the sum of a geometric series:
     *  S=
     * 2−1
     * 2
     * n+1
     *  −1
     * ​
     *  =2
     * n+1
     *  −1
     *
     *  Ignoring the constant -1, the dominant term is:
     *  T(n) = o(2^n)
     *
     *  🔹 The brute force Fibonacci recursion takes O(2ⁿ) time because:
     *
     * Each function call makes two recursive calls.
     * The recursion tree has a depth of n.
     * The total number of function calls grows exponentially.
     *
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    /**
     * f(i) = f(i-2) + f(i-1)
     * State: n
     * int [] n = new int[n]
     *
     * Tree Representation Without Memoization::
     *
     *         fib(5)
     *        /     \
     *     fib(4)   fib(3)
     *     /    \    /    \
     * fib(3) fib(2) fib(2) fib(1)
     *  /   \   /  \
     * fib(2) fib(1) fib(1) fib(0)
     *  /  \
     * fib(1) fib(0)
     *
     * Tree Representation With Memoization
     *
     *         fib(5)
     *        /     \
     *     fib(4)   (dp[3] = 2)
     *     /    \
     * (dp[3]=2)  (dp[2]=1)
     *
     * How It Works Efficiently
     * The function is called recursively for fib(n - 1) and fib(n - 2), but each result is stored in dp[] after the first computation.
     * The next time fib(n - 1) or fib(n - 2) is needed, it is returned in O(1) time from dp[] instead of making recursive calls.
     * The function only computes fib(k) once for each k from 0 to n.
     * Time Complexity Calculation
     * Each Fibonacci number is computed only once and stored in the array.
     *
     * We calculate fib(0) to fib(n) exactly once.
     * Since each call performs O(1) work (checking dp[] and summing two values),
     * The total number of calls is O(n).
     *
     */
    public int fibWithMemoization(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = fibWithMemoization(n - 1, dp) + fibWithMemoization(n - 2, dp);

        return dp[n];
    }

    // Helper method to call the function
    public int fibV1(int n) {
        int[] dp = new int[n + 1]; // Create an array to store computed results
        return fibWithMemoization(n, dp);
    }
}
