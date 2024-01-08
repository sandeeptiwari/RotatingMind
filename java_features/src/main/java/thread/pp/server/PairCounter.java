package thread.pp.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class PairCounter implements Callable<Integer> {
    private final List<Integer> nums;
    private final int sum;

    public PairCounter(List<Integer> nums, int sum) {
        this.nums = nums;
        this.sum = sum;
    }


    @Override
    public Integer call() throws Exception {
        int size = nums.size();
        Map<Integer, Integer> numsByIndex = new HashMap<>();
        int pairCount = 0;
        for (int i = 0; i < size; i++) {

            int complement = sum - nums.get(i);

            if (numsByIndex.containsKey(nums.get(i))) {
                pairCount++;
            }
            numsByIndex.put(complement, i);
        }
        return pairCount;
    }
}
