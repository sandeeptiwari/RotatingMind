package lrucache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final ReentrantLock hardCacheLock = new ReentrantLock();

    /** The size of hard cache. */
    private final int HARD_SIZE;

    private LRUCache(){
        this.HARD_SIZE = 100;
    }

    private LRUCache(int size){
        super(size, 0.75f, true);
        this.HARD_SIZE = size;
    }

    public static <K, V> LRUCache<K, V> newInstance(int size){
        return new LRUCache<>(size);
    }

    @Override
    public V put(K key, V value) {

        //aquire lock
        hardCacheLock.lock();
            put(key, value);
        hardCacheLock.unlock();

        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        super.putAll(m);
    }

    @Override
    public V remove(Object key) {
        return super.remove(key);
    }
}
