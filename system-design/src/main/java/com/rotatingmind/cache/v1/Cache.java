package com.rotatingmind.cache.v1;

import java.util.Optional;

public interface Cache<K, V> {
    boolean put(K key, V value);

    Optional<V> get(K key);

    int size();

    boolean isEmpty();

    void clear();
}
