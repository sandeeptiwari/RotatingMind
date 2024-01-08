package thread.pp.server;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {

    /*public static void main(String[] args) throws Exception {
        SingleThreadedServer s = new SingleThreadedServer();
        Random random = new Random();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            int qty = 30000;
            List<Integer> nums = new ArrayList<>();
            for (int j = 0; j < qty; j++)
                nums.add(random.nextInt(100, 200));

            int sum = random.nextInt(200, 400);
            Integer res = s.getPairCount(nums, sum);
            System.out.println("received response from server as : " + res);
        }
        long end = System.currentTimeMillis();
        System.out.println("Total time :: " + (end - start));
    }*/

    /*public static void main(String[] args) throws InterruptedException, ExecutionException {
        Server s = new Server();
        Random random = new Random();
        Map<Integer, FutureTask<Integer>> m = new HashMap<>();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            int qty = 30000;
            List<Integer> nums = new ArrayList<>();
            for (int j = 0; j < qty; j++)
                nums.add(random.nextInt(100, 200));

            int sum = random.nextInt(200, 400);
            FutureTask<Integer> pairCount = s.getPairCount(nums, sum);
            System.out.println("received response from server");
            m.put(i, pairCount);
        }
        long end = System.currentTimeMillis();
        System.out.println("Total time :: " + (end - start));
        for (int j = 0; j < 5; j++) {
            System.out.println("Req # " + j +" : " + m.get(j).get() );
        }

    }*/

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPool threadPool = new ThreadPool(10);
        List<FutureTask<Integer>> futureTasks =  new ArrayList<>();
        Random random = new Random();
        int k = 0;
        for (int i = 0; i < 10; i++) {
            FutureTask<Integer> res = null;
            if (i % 3 == 0) {
                threadPool.submit(new Thrower());
            } else if (i % 2 == 0) {
                int qty = 3000;
                List<Integer> nums = new ArrayList<>();
                for (int j = 0; j < qty; j++)
                    nums.add(random.nextInt(100, 200));

                int sum = random.nextInt(200, 400);
                res = threadPool.submit(new PairCounter(nums, sum));
            } else {
                res = threadPool.submit(new DummyCallable(k++));
            }
            futureTasks.add(res);
        }
        threadPool.shutDown();

        for (FutureTask<Integer> task: futureTasks) {
            Integer ans = null;
            ans = task.get();
            System.out.println("ANS :: " + ans);
        }

    }
}
