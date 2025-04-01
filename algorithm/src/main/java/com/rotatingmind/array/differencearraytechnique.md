🔍 **Difference Array Technique** Explained Simply

The Difference Array is a powerful tool used to efficiently handle multiple range updates in an array.


**🚀 Core Idea**

Instead of modifying the original array directly (which is inefficient), we use a difference array to track changes efficiently.

The difference array tracks where changes start and stop.
During the final step, a prefix sum reconstructs the updated array.

Step 1: Construct the Difference Array

Suppose you have an array:

    nums = [3, 4, 5]


✅ Create a difference array of size n + 1 (one extra element to manage boundary conditions).

✅ Initialize the diff array with zeros.

    diff = [0, 0, 0, 0]  // Size n + 1

Step 2: Range Update Using the Difference Array

Suppose you need to decrease elements from index 0 to 1 by 2.

* diff[start] -= 2 → Start reducing at index 0
* diff[end + 1] += 2 → Stop reducing after index 1

Update Steps:

    diff[0] -= 2   → diff = [-2, 0, 0, 0]
    diff[2] += 2   → diff = [-2, 0, 2, 0]

After Change:

    nums[0] = 3 + (-2) = 1
    nums[1] = 4 + (-2) = 2
    nums[2] = 5 + 2 = 7


Related Problems:


