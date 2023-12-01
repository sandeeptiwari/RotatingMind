package com.rotatingmind.cache.cacheusingmap;

import java.util.HashMap;
import java.util.Map;

public class BookCache {
    private Map<String, Book> cache = new HashMap<>();

    public void addToCache(Book book) {
        cache.put(book.id(), book);
    }

    public Book getFromCache(String id) {
        return cache.get(id);
    }

}
