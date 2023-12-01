package com.rotatingmind.cache.cacheusingmap;

public class BookCacheTest {

    public static void main(String[] args) {
        BookCache bookCache = new BookCache();
        BookCacheTest bookCacheTest = new BookCacheTest();
        bookCacheTest.simulateCacheUsage(bookCache);
    }

    public void simulateCacheUsage(BookCache bookCache) {
        // Adding books to the cache
        for (int i = 1; i <= 1000; i++) {
            Book book = new Book("B" + i, "Book " + i);
            bookCache.addToCache(book);
        }

        // Retrieving books from the cache
        for (int i = 1; i <= 1000; i++) {
            String bookId = "B" + i;
            Book cachedBook = bookCache.getFromCache(bookId);
            System.out.println("Book with ID " + bookId + ": " + cachedBook);
        }
    }
}
