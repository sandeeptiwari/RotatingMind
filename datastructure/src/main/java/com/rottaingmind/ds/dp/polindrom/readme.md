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


Description:

Total Substring possible = 

    N + N/2 + N/3.... = N * (N+ 1) / 2 = ~N^2

Here in this case we cant say that if border char match then middle remaining substring would be palindromic in nature

Let's thing come up with totally different definition: 

isPal(i, j): whether my substring starts at i and ends at j is palindrom or not?

    isPal(i, j) ? T : F

based on this definition

so if we chack inner substring starts at p and ends at p is pali(i, j) or not first criteria would be border element should match

     isPal(i, j) = S[i] == S[j]  && ispal(i +1, j-1)

Note: i always less that j, it's never possible to i become greater than j

lets say substring:

    (0, 0), (0, 1), (0, 2) ........(0, n-1)
             (1, 1)  (1, 2).........(1, n-1)

means only those cell need to populate where i < j, which is upper triangular part.

lets say cell (i, j), starts at i and ends at j, what would be length of substring = j - i + 1

so for diagonal cell where i = j means string length would be 1, all the string of length is palindromic in nature

so all cell initialize by "True" where i == j

and also if i > j means empty string, empty string is also palindromic in nature so just below diagonal of main diagonal 
and all cell becomes true

Implementation:

![img_11.png](img_11.png)

Assignments:

https://leetcode.com/problems/palindrome-partitioning-ii/description/

https://leetcode.com/problems/palindrome-partitioning-ii/description/

https://leetcode.com/problems/longest-palindromic-substring/description/

https://leetcode.com/problems/longest-palindromic-subsequence/description/

https://leetcode.com/problems/longest-palindromic-subsequence/description/