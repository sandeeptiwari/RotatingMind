package com.rotatingmind.timeoutcache.handler;

import com.rotatingmind.timeoutcache.model.CacheValue;
import com.rotatingmind.timeoutcache.model.IGenericCache;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
//https://medium.com/@marcellogpassos/creating-a-simple-and-generic-cache-manager-in-java-e62e4204a10e

public class GenericCache<K, V> implements IGenericCache<K, V> {
    public static final Long DEFAULT_CACHE_TIMEOUT = 60000L;
    protected Long cacheTimeout;
    protected Map<K, CacheValue<V>> cacheMap;

    public GenericCache() {
        this(DEFAULT_CACHE_TIMEOUT);
    }

    public GenericCache(Long cacheTimeout) {
        this.cacheTimeout = cacheTimeout;
        this.clear();
    }

    @Override
    public void clean() {
        this.getExpiredKeys().stream().forEach(key -> {
            this.remove(key);
        });
    }

    protected Set<K> getExpiredKeys() {
        return cacheMap.keySet().parallelStream()
                .filter(this::isExpired)
                .collect(Collectors.toSet());
    }

    private boolean isExpired(K key) {
        LocalDateTime expirationDateTime =
                this.cacheMap.get(key).getCreatedAt()
                        .plus(this.cacheTimeout, ChronoUnit.MILLIS);
        return LocalDateTime.now().isAfter(expirationDateTime);
    }

    @Override
    public void clear() {
      this.cacheMap = new HashMap<>();
    }

    @Override
    public boolean containsKey(K key) {
        return this.cacheMap.containsKey(key);
    }

    @Override
    public Optional<V> get(K key) {
        this.clean();
        return Optional.ofNullable(this.cacheMap.get(key))
                .map(CacheValue::getValue);
    }

    @Override
    public void put(K key, V value) {
        this.cacheMap.put(key, this.createCacheValue(value));
    }

    protected CacheValue<V> createCacheValue(V value) {
        LocalDateTime now = LocalDateTime.now();
        return new CacheValue<V>() {

            @Override
            public V getValue() {
                return value;
            }

            @Override
            public LocalDateTime getCreatedAt() {
                return now;
            }
        };
    }


    @Override
    public void remove(K key) {
        this.cacheMap.remove(key);
    }
}
