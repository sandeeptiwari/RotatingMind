🟢 **Easy Level**

1. **Maximum Sum Subarray of Size K**

**Hint:** Use a fixed-size sliding window and track the maximum sum by adjusting the window's start and end points.

2. **Minimum Size Subarray Sum**

**Hint:** Use a variable-sized window to find the smallest subarray with a sum greater than or equal to a target.

3. **Find All Anagrams in a String**

**Hint:** Use a hashmap or array to track character counts in a fixed window size.

4. **Longest Substring Without Repeating Characters**

**Hint:** Use a hashmap to track the last seen index of characters.

5. **Sliding Window Maximum**

**Hint:** Use a Deque to efficiently track the maximum in each window.


🟡 **Medium Level**

1. **Fruit Into Baskets (Longest Subarray with At Most 2 Distinct Elements)**

Hint: Use a hashmap to count distinct elements and shrink the window when needed.

2. **Longest Substring with At Most K Distinct Characters**

Hint: Track distinct characters using a hashmap and maintain the longest valid window.

3. **Longest Repeating Character Replacement**

Hint: Track the most frequent character count and adjust the window accordingly.

4. **Permutation in String**

Hint: Use a hashmap for character counts and match each window with the target string's frequency.

5. **Binary Subarrays With Sum**

Hint: Use two pointers and maintain the count of valid subarrays.

6. **Maximum Points You Can Obtain from Cards**

Hint: Calculate the total sum and use a sliding window to minimize the sum of remaining cards.

🔴 **Hard Level**

1. **Minimum Window Substring**

Hint: Use two pointers to expand and contract the window while tracking required characters.

2. **Count Number of Nice Subarrays**

Hint: Use a sliding window to track subarrays containing exactly k odd numbers.

3. **Subarrays with K Different Integers**

Hint: Use the sliding window technique twice — once for atMost(k) and once for atMost(k-1) to calculate the exact count.

4. **Maximum Consecutive Ones III**

Hint: Use a sliding window to track the maximum consecutive ones by flipping at most k zeroes.

5. **Shortest Subarray with Sum at Least K**

Hint: Use a Deque to efficiently track prefix sums.


### Bonus Problems for Practice

* Longest Subarray of 1's After Deleting One Element
* Minimum Swaps to Group All 1's Together
* Subarray Product Less Than K
* Longest Substring with Equal Number of 0s, 1s, and 2s
* Count Number of Substrings with Exactly K Distinct Characters




    📋 Preparation Tips for FANG-Level Problems
    ✅ Master both fixed window and variable window patterns.
    ✅ Focus on edge cases like empty strings, all identical characters, etc.
    ✅ Learn how to efficiently track values using hashmaps, deques, and prefix sums.
    ✅ Practice problems involving dual sliding windows (like "Subarrays with K Different Integers").