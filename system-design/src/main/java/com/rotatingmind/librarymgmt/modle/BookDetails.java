package com.rotatingmind.librarymgmt.modle;

import java.util.Date;
import java.util.List;

public class BookDetails {
    private final String name;

    private final Date publishDate;

    private final List<String> authors;

    public BookDetails(String name, Date publishDate, List<String> authors) {
        this.name = name;
        this.publishDate = publishDate;
        this.authors = authors;
    }
}
