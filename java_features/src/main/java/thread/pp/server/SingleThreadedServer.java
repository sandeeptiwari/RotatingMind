package thread.pp.server;

import java.util.List;

public class SingleThreadedServer {

    public Integer getPairCount(List<Integer> nums, int sum) throws Exception {
        return new PairCounter(nums, sum).call();
    }
}
