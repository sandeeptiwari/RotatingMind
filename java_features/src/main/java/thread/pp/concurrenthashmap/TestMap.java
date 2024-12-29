package thread.pp.concurrenthashmap;

public class TestMap {

    public static void main(String[] args) throws InterruptedException {
        MyConcHashMap map = new MyConcHashMap();
        map.put(1, 10);
        map.put(2049, 100);

        new Thread(new MapWorker(1, 10, map)).start();
        new Thread(new MapWorker(2049, 100, map)).start();
        Thread.sleep(4000);
        System.out.println(map.get(1));
        System.out.println(map.get(2049));
    }
}
