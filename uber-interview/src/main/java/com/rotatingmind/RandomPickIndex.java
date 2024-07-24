package com.rotatingmind;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Explanation of Reservoir Sampling, Hope this help!!!!!!
 * {1, 2, 3, 4, 3, 3, 5} with target 3. So we want to select 2, 4, 5 with a probability of 1/3 each.
 *
 * When we reach the first 3 with index of 2, the probability of selection is 1(prob of choosing itself) * 1/2(prob of not choosing second index 4) * 2/3(prob of not choosing the third index 5) = 1/3.
 *
 * When we reach the second 3 with index of 4, the prob of selection is 1/2(prob of choosing itself) * 2/3(prob of not choosing the third index 5) = 1/3
 *
 * 3.When we reach the third 3 with index of 5, the prob of selection is 1/3(prob of choosing itself)
 * ----------------------------------------------------------------------------------------------------------
 * probability for choosing zeroth index = 1/1 * (1-1/2) * (1-1/3) * ... * (1-1/n) = (1/n)
 *
 * You can see that the terms will cancel themselves and only (1/n) is left in the end.
 *
 * Now, probability for choosing any other element let's say the third element, prob = 1/1 * (1/1) * (1/3) * (1-1/4) * (1-1/5) * ... (1-1/n) = (1/n)
 *
 * Note that if we select 3rd element then we don't care if we had already selected any element before 3rd element previously. Therefore, I have added (1/1) as the probability of choosing any outcome for the numbers before our required index. Rest of the numbers will cancel themselves and the answer will be (1/n)
 *
 * Similarly every element has the same probability of getting chosen which is (1/n). Hence proved.
 *
 *
 * https://leetcode.com/problems/random-pick-index/solutions/1277297/Use-Reservoir-Sampling-Template/
 * ------------------------------------------------------------------------------------------------------------------------------
 *
 * At first, let's get clear that count is used to count the target number in nums. Say we now we have nums=[1,5,5,6,5,7,9,0] and the target is 5.
 *
 * Now let's focus on the loop. When i=1, we get the first target number, and by rnd.nextInt(++count) we select a random number between [0, 1), which means actually you could only select 0, so the probability of making result = 1 is 1.
 *
 * Keep going. In the loop where i = 2, we get the second number. Now we have to get a random number in {0,1}. So what should we do if we want to keep result = 1? It's simple: we have to make sure that, at this time, the random number generated should be 1 rather than 0 (otherwise the value of result will be changed), so the probability of keeping result = 1 is 1 * 1/2.
 *
 * It is similar when we get the third target number, i.e., i = 4. Now we have to get a random number in {0,1,2}. If we still wish to keep result = 1, the only way is to randomly get number 1 or 2 rather than 0, and the probability is 2/3. So the total probability of keeping result = 1 will be 1 * 1/2 * 2/3.
 *
 * Since we have four target number 5 here, the final probability of keeping result = 1 would be 1 * 1/2 * 2/3 * 3/4 = 1/4, which means the probability of picking index 0 is 1/4 as the problem required. The probability is the same if you wish to pick another index.
 *
 * You may ask what is the probability of picking the last possible index 4? Well, it simpler. You may ignore all operations before the loop where i = 4, and the only thing you have to do is to get the random number 0 among {0,1,2,3} in the loop where i = 4, so the probability is exactly 1/4.
 */
class Solution {
    private final Integer[] nums;
    private final Random rnd;

    public Solution(Integer[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick(int target) {
        int n = nums.length;
        int result = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != target) continue;

            int rnO = rnd.nextInt(++count);
            System.out.println("Number = " + rnO);
            System.out.println("count = " + count);

            if (rnO == 0) {
                result = i;
            }
        }
        return result;
    }

   /*
   HashMap<Integer, Queue<Integer>> map = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();

    public Solution(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], queue);
            }
            queue = map.get(nums[i]);
            queue.add(i);
            map.put(nums[i], queue);
        }
    }

    public int pick(int target) {
        Queue<Integer> tempQueue = map.get(target);
        int result = tempQueue.poll();
        tempQueue.add(result);
        return result;
    }
    */
}


public class RandomPickIndex {

    public static void main(String[] args) {
        String[] arr = {"Solution", "pick", "pick", "pick"};
        int n = arr.length;
        List<Integer[]> nums = List.of(
                new Integer[]{1, 2, 3, 5, 4, 9, 4, 6, 4},
                new Integer[]{4},
                new Integer[]{1},
                new Integer[]{4}
        );
        Solution solution = null;
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            if (arr[i].equals("Solution")) {
                solution = new Solution(nums.get(i));
                str[i] = null;
            } else {
                str[i] = "" + solution.pick(nums.get(i)[0]);
            }
        }
        Arrays.stream(str).forEach(ele -> {
            System.out.print(ele + ", ");
        });
    }

}
