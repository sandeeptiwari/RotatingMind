package com.rotatingmind.librarymgmt.search;

import com.rotatingmind.librarymgmt.modle.BookCopy;

import java.util.List;

public class AuthorBookSearcher implements BookSearcher {

    private final List<String> authors;

    public AuthorBookSearcher(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public List<BookCopy> search() {
        return null;
    }
}
