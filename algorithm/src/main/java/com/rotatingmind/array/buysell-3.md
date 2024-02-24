public static void main (String[] args) throws java.lang.Exception
{
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int[] a = new int[n];

        for(int i= 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[][][] dp = new int[n][2][3];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        int profit = maxProfit(a, 0, 0, 2, dp);
        System.out.print(profit);
    }
    
    public static int maxProfit(int[] a, int i, int buy, int limit, int[][][] dp) {
        if(a.length == i) {
           return 0;
        }
        
         if(a.length==1)

        {
            return 0;
        }
        
        if(limit == 0) {
          return 0;
        }
        
        if (dp[i][buy][limit] != -1) {
            return dp[i][buy][limit];
        }
        
        int profit = 0;
        
        if (buy == 0) {
            int buyKro = -a[i] + maxProfit(a, i + 1, 1, limit, dp);
            int skipKro = 0 + maxProfit(a, i + 1, 0, limit, dp);
            
            profit = Math.max(buyKro, skipKro);
        } else {
            int sellKro = a[i] + maxProfit(a, i + 1, 0, limit-1, dp);
            int skipKro = 0 + maxProfit(a, i + 1, 1, limit, dp);
            
            profit = Math.max(sellKro, skipKro);
        }
        dp[i][buy][limit] = profit;
        return dp[i][buy][limit];
    }
========================================================================================================
Certainly! Let's go through each step using the example array int[] prices = {7, 1, 5, 3, 6, 4};.

Initialization:

We have the given array prices = {7, 1, 5, 3, 6, 4}.
We initialize three arrays v1, v2, and mx, each of size n, where n is the length of prices.
Setting initial values:

v1[0] = Integer.MAX_VALUE; (initialized to the maximum possible integer value)
v2[n - 1] = -1; (initialized to -1, indicating no higher price exists after the last day)
Finding minimum and maximum prices:

For v1 array:
v1[0] = Integer.MAX_VALUE; (initially)
v1[1] = min(v1[0], prices[0]) = min(Integer.MAX_VALUE, 7) = 7
v1[2] = min(v1[1], prices[1]) = min(7, 1) = 1
v1[3] = min(v1[2], prices[2]) = min(1, 5) = 1
v1[4] = min(v1[3], prices[3]) = min(1, 3) = 1
v1[5] = min(v1[4], prices[4]) = min(1, 6) = 1
For v2 array:
v2[5] = -1; (initially)
v2[4] = max(v2[5], prices[5]) = max(-1, 4) = 4
v2[3] = max(v2[4], prices[4]) = max(4, 6) = 6
v2[2] = max(v2[3], prices[3]) = max(6, 3) = 6
v2[1] = max(v2[2], prices[2]) = max(6, 5) = 6
v2[0] = max(v2[1], prices[1]) = max(6, 1) = 6
Calculating maximum profit starting from each day:

mx[5] = v2[5] - prices[5] = -1 - 4 = -5
mx[4] = v2[4] - prices[4] = 4 - 6 = -2
mx[3] = v2[3] - prices[3] = 6 - 3 = 3
mx[2] = v2[2] - prices[2] = 6 - 5 = 1
mx[1] = v2[1] - prices[1] = 6 - 1 = 5
mx[0] = v2[0] - prices[0] = 6 - 7 = -1
Calculating the maximum profit:

We iterate through the prices array from the second day to the last day.
For each day, we calculate the profit we can obtain if we buy on the current day and sell at any day in the future.
We add the profit to val.
If there is a chance to make further profit in the future (indicated by mx[i + 1]), we add that to val as well.
We update ans to the maximum of val and ans.
Return maximum profit:

The maximum profit would be the maximum value stored in ans.
This algorithm efficiently calculates the maximum profit by considering the minimum price encountered so far, the maximum price encountered so far, and the maximum profit that can be obtained starting from each day and selling at any day in the future.