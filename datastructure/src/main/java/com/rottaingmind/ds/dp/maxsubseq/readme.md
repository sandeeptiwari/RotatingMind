Given int arr[n], find the max sum of subsequence s.t. no 2 elements are adjacent.
arr = [1, 10, 100, 40, 20]
o/p = 121 (1, 100, 20)
arr1 = [a, b, c, d, e, f]
not valid = [a, b, c]
valid = [a, c, e, f]

We have to think recursively: either take any element or just leave that element

any element can we choose or left

![img.png](img.png)

when we look at the part of any array last index any array

So we ca write like below:


    maxSum(i) = arr[i] + maxSum(i + 2)

              = maxSum(i + 1)

                 f(i)
                 /   \
            f(i + 1) f(i + 2)
             /
           f(i + 2)
Here you can see repetition is occurs, so we would need to use memorization, implementation as below: in top-down
![img_1.png](img_1.png)

In bottom -top approach we solve f(1), f(2) ..

![img_2.png](img_2.png)
ans[0] = max(0, arr[0])
ans[1] = max(and[0], arr[1])

for (i = 2 to n) {

   ans[i] = max(arr[i] + arr[i-2], arr[i-1])
}
return and[n]
Since we need only 2 previous value so there is no sense to use array
![img_3.png](img_3.png)

Max subsequence in matrix:
![img_4.png](img_4.png)
o/p = 200 + 70 = 270
![img_5.png](img_5.png)
Here is above table, we noticed 1 thing {c,D} is common in both it means from column 1 either we select 1st or 2nd ele we cant pick anything from 
next column any element so now we have 2 chices either we take max value from column 1 or just leave column 1 and move to column 2

        f(i) = 1. max( arr[0, i], arr[1, i]) + f(i + 2)    -> i is column number & f(i + 2) - it'll sum from i+2 to end 
               2. f(i+1)

Implementation:
![img_6.png](img_6.png)

Assignments:
https://codeforces.com/problemset/problem/698/A
https://codeforces.com/contest/456/problem/C
https://leetcode.com/problems/house-robber-ii/description/
https://www.geeksforgeeks.org/problems/adjacents-are-not-allowed3528/1
https://www.geeksforgeeks.org/problems/stickler-theif-1587115621/1
https://www.geeksforgeeks.org/problems/stickler-theif-1587115621/1