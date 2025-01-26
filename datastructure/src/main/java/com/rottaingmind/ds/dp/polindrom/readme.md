### Longest Common Polindromic subsequence

1. Using LCS(s1, s2)

![img.png](img.png)

Case 1. When starting and ending chars match:
![img_1.png](img_1.png)


f(i, j) = LPS in S[i...j]
        = if(s[i] == s[j]) {
        2 + f(i + 1, j-1)
} else  //Case 2. When starting and ending chars doesn't match:
  return max ( f(i + 1, j), f(i, j-1))

**Note:** 
To denote the entire string to make a call for f(0, n-1), because when we call f(i, j), we call the part s[i] + s[j]

![img_2.png](img_2.png)
if (i == j) return 1

![img_3.png](img_3.png)

resolve overlapping problem:
![img_4.png](img_4.png)

TC: o(n^2)
SC: O(n^2)

Bottom Top:

![img_5.png](img_5.png)

![img_6.png](img_6.png)

Implementation:
![img_7.png](img_7.png)

### Longest polindromic substring
![img_8.png](img_8.png)

![img_9.png](img_9.png)

![img_10.png](img_10.png)

Implementation:

![img_11.png](img_11.png)

Assignments:
https://leetcode.com/problems/palindrome-partitioning-ii/description/
https://leetcode.com/problems/palindrome-partitioning-ii/description/
https://leetcode.com/problems/longest-palindromic-substring/description/
https://leetcode.com/problems/longest-palindromic-subsequence/description/
https://leetcode.com/problems/longest-palindromic-subsequence/description/