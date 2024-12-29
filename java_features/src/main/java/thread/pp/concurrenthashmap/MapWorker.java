package thread.pp.concurrenthashmap;

public class MapWorker implements Runnable {

    private final int key, value;

    private final MyConcHashMap map;

    public MapWorker(int key, int value, MyConcHashMap map) {
        this.key = key;
        this.value = value;
        this.map = map;
    }


    @Override
    public void run() {
        map.put(key, value);
    }
}
