package com.rotatingmind.cache.cacheusingmap;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class BookCacheV1 {
    private Map<String, Book> cache;
    private Set<String> recentlyUsedKeys;

    private static final int MAX_CACHE_SIZE = 1000;

    public BookCacheV1() {
        cache = new LinkedHashMap<>(MAX_CACHE_SIZE, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Book> eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
        recentlyUsedKeys = new LinkedHashSet<>();
    }

    public void addToCache(Book book) {
        String bookId = book.id();
        cache.put(bookId, book);
        recentlyUsedKeys.add(bookId);
    }

    public Book getFromCache(String id) {
        Book book = cache.get(id);
        if (book != null) {
            recentlyUsedKeys.remove(id);
            recentlyUsedKeys.add(id);
        }
        return book;
    }
}
