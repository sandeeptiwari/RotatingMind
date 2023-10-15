package com.rotatingmind.cache.cacheusingmap;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;

/*
record CacheEntry<T>(T value, Instant expiryTime) {
    public boolean isExpired() {
        return Instant.now().isAfter(expiryTime);
    }

    public CacheEntry<T> updateExpiryTime(Instant newExpiryTime) {
        return new CacheEntry<>(value, newExpiryTime);
    }
}
*/

class CacheEntry<T> {
    private final T value;
    private LocalDateTime accessedTime;

    public CacheEntry(T value) {
        this.value = value;
        this.accessedTime = LocalDateTime.now();
    }

    public T getValue() {
        return value;
    }

    public LocalDateTime getAccessedTime() {
        return accessedTime;
    }

    public void setAccessedTime(LocalDateTime accessedTime) {
        this.accessedTime = accessedTime;
    }
}

public class BookCacheV2 {
    private int size;
    private Map<String, CacheEntry<Book>> cache;

    public BookCacheV2(int size) {
        this.size = size;
        this.cache = new LinkedHashMap<>(size, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, CacheEntry<Book>> eldest) {
                return super.removeEldestEntry(eldest);
            }
        };
    }

    public Book getFromCache(String bookId) {
        CacheEntry<Book> entry = cache.get(bookId);
        if (entry != null) {
            entry.setAccessedTime(LocalDateTime.now());
            return entry.getValue();
        }
        return null;
    }

    public void addToCache(Book book) {
        CacheEntry<Book> entry = new CacheEntry<>(book);
        cache.put(book.id(), entry);
    }

    public int getCacheSize() {
        return cache.size();
    }

    private boolean isEntryExpired(CacheEntry<Book> entry) {
        long minutesSinceLastAccess = ChronoUnit.MINUTES.between(entry.getAccessedTime(), LocalDateTime.now());
        return minutesSinceLastAccess > 5; // Expire entry if not accessed in the last 5 minutes
    }
}