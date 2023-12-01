package thread.pp.sortedjobs.multiplethread;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private final List<Integer> nums;

    private int curr = 0;

    public Container() {
        this.nums = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            nums.add(i);
        }
        curr = 0;
    }


    /*public  int pluck() {
        if (curr == nums.size()) {
            return -1;
        }
        int val = nums.get(curr);
        curr++;
        return val;
    }*/

    public synchronized int pluck() {
        if (curr == nums.size()) {
            return -1;
        }
        int val = nums.get(curr);
        curr++;
        return val;
    }
}
