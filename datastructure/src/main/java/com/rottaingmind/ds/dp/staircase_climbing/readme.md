Sure! Let’s break it down step by step with an example and explain why we use Math.min(dp[n - 1], dp[n - 2]) at the end.

Understanding the Problem
You are given an array cost[], where:

* cost[i] represents the cost to step on i-th stair.
* You can take 1 step or 2 steps at a time.
* Your goal is to reach the top with minimum cost.


  `int[] cost = {10, 15, 20};`

### Index Representation

    Stair 0 -> Cost: 10
    Stair 1 -> Cost: 15
    Stair 2 -> Cost: 20

But the top (stair 3) is beyond the last step, meaning:

You can reach the top from step 1 or step 2.


**Why Math.min(dp[n - 1], dp[n - 2])?**

Since we can jump either 1 step or 2 steps, the final position (top) is reached from either:

1. The last step (n-1), OR
2. The second-last step (n-2).

So, the minimum cost to reach the top is the minimum cost required to stand on either of these two steps.

**Building the DP Table (dp array)**

dp[i] stores the minimum cost to reach step i.

For cost = {10, 15, 20}:

Step-by-Step Calculation

**Base Cases:**

    dp[0] = cost[0] = 10
    dp[1] = cost[1] = 15

If you start from step 0, you pay 10.

If you start from step 1, you pay 15.

**Calculate dp[2]:**

    dp[2] = cost[2] + Math.min(dp[1], dp[0])
    = 20 + Math.min(15, 10)
    = 20 + 10
    = 30

**You can reach step 2:**
* From dp[0] with total cost 10 + 20 = 30
* From dp[1] with total cost 15 + 20 = 35


Minimum is 30, so dp[2] = 30.

**Final Decision:**

To reach the top, you must come from either step 1 or step 2, so:

    Answer = Math.min(dp[1], dp[2])
    = Math.min(15, 30)
    = 15


**Why is dp of length n?**

Since we don't need to explicitly store the top (we are not stepping on it, just reaching it), our dp array needs to store up to the last step (n-1).

dp[i] stores the minimum cost to reach step i, but we don't need to store a separate step for "top" because we calculate it from dp[n-1] and dp[n-2].





