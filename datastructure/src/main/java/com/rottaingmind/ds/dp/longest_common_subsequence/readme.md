Given 2 String
s[m] & s2[n], find the length of their longest common subsequence
Example
S1 = "aabcb"
S2 = "abab"
character placement can be anything in same order in subsequence

Here common subsequences = [bb, aa, a, abb, aab, ....]
Now LCS (longest common subsequence) = 3

2^m subsequences can be possible for S1, because we can select each chars has 2 choices (take it or not take it)
2^n for S2

Then total common subsequences can  be :

S1: ......... a (i)
s2: ......a(j)

Here 2 thing possible either last char of both string match or not match

**Case 1: Match**
In this case last character of LCS must be end with a because a is match, what about above left characters

    LCS(s1, s2) = ............a

With that left part made of the remaining part of s1 and s2, yes. think like this if we finds pqr longest subsequest in left part then we can easily appended 
as prefix of a to that pqr = pqra

LCS(i, j) depends on s1[0...i] &
           = s2[0...j]

    LCS(i, j) = 1 + LCS(i-1, j-1)

means longest common subsequence of(s1[0...i], s2[0...j]) is store in LCS(i, j)

**Note:** 

why we are match last char (a) of s1 with last char of s2(a), why we are not matching with other a comes previous in s2
![img.png](img.png)

**case 2:** No match 
![img_1.png](img_1.png)
![img_2.png](img_2.png)

    LCS(i, j) = max(LCS(i, j-1), LCS(i-1, j))

when we reducing out indices whicvh is from 0 to i keep srinking and at one point its -ve, negative means empty string means there is no
indices left between 0 i and which means it blank

S1 = "" no matter what s2 is LCS("", abc) = 0
S1 = "" no matter what s1 is LCS(xyz, "") = 0

implementation:

![img_3.png](img_3.png)

TC o(m*n)
SC = o(m*n)

### Bottom Top Approach:
![img_4.png](img_4.png)
![img_5.png](img_5.png)

    Filling the DP Matrix
    s1 \ s2	0	G	X	T	X	A	Y	B
    0	    0	0	0	0	0	0	0	0
    A	    0	0	0	0	0	1	1	1
    G	    0	1	1	1	1	1	1	1
    G	    0	1	1	1	1	1	1	1
    T	    0	1	1	2	2	2	2	2
    A	    0	1	1	2	2	3	3	3
    B	    0	1	1	2	2	3	3	4
    
    Filling Logic for Each Cell
    First Row and Column (Base Case)
    mat[0][j] = 0 (LCS with empty s1)
    mat[i][0] = 0 (LCS with empty s2)
    Now Filling Cell-by-Cell Using the Recurrence Relation
    Row 1 (A vs GXTXAYB)
    
    mat[1][1]: A != G → max(0, 0) = 0
    mat[1][2]: A != X → max(0, 0) = 0
    mat[1][3]: A != T → max(0, 0) = 0
    mat[1][4]: A != X → max(0, 0) = 0
    mat[1][5]: A == A → 1 + mat[0][4] = 1
    mat[1][6]: A != Y → max(1, 0) = 1
    mat[1][7]: A != B → max(1, 0) = 1
    Row 2 (G vs GXTXAYB)
    
    mat[2][1]: G == G → 1 + mat[1][0] = 1
    mat[2][2]: G != X → max(1, 0) = 1
    mat[2][3]: G != T → max(1, 0) = 1
    mat[2][4]: G != X → max(1, 0) = 1
    mat[2][5]: G != A → max(1, 1) = 1
    mat[2][6]: G != Y → max(1, 1) = 1
    mat[2][7]: G != B → max(1, 1) = 1
    Row 3 (G vs GXTXAYB)
    
    Identical to Row 2 since both Gs behave the same way.
    Row 4 (T vs GXTXAYB)
    
    mat[4][1]: T != G → max(0, 1) = 1
    mat[4][2]: T != X → max(1, 1) = 1
    mat[4][3]: T == T → 1 + mat[3][2] = 2
    mat[4][4]: T != X → max(2, 1) = 2
    mat[4][5]: T != A → max(2, 2) = 2
    mat[4][6]: T != Y → max(2, 2) = 2
    mat[4][7]: T != B → max(2, 2) = 2
    Row 5 (A vs GXTXAYB)
    
    mat[5][5]: A == A → 1 + mat[4][4] = 3
    Rest cells are filled using max(dp[i-1][j], dp[i][j-1]).
    Row 6 (B vs GXTXAYB)
    
    mat[6][7]: B == B → 1 + mat[5][6] = 4
    Rest cells are filled using max(dp[i-1][j], dp[i][j-1]).
    Step 5: Extract LCS (Backtracking)
    Start from mat[m][n] = mat[6][7] = 4
    If s1[i-1] == s2[j-1], include it in LCS and move diagonally (i-1, j-1).
    Else move in the direction of max(dp[i-1][j], dp[i][j-1]).
    Result: "GTAB" (Length = 4)

Implementation:
![img_6.png](img_6.png)

ans array always point to i-1


Final Complexity

✅ Time Complexity: O(m×n)

✅ Space Complexity: O(m×n) (can be optimized to O(n) using a 1D array)

Summary
Matrix is filled row by row using a bottom-up approach.
Each cell is computed using recurrence relation (1 + diagonal or max(left, up)).
Final answer is stored in mat[m][n].
LCS is retrieved by backtracking.


### Printing any 1 longest common subsequence

![img_7.png](img_7.png)

![img_8.png](img_8.png)

implementation:

![img_9.png](img_9.png)

reverse the result **

TC = O(m+n)

Assignment:

https://leetcode.com/problems/longest-common-subsequence/description/

https://leetcode.com/problems/longest-common-subsequence/description/

https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem

