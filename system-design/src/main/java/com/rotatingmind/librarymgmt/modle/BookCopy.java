package com.rotatingmind.librarymgmt.modle;

public class BookCopy {

    private final long id;

    //composition
    private final BookDetails bookDetails;

    public BookCopy(long id, BookDetails bookDetails) {
        this.id = id;
        this.bookDetails = bookDetails;
    }

    public long getId() {
        return id;
    }

    public BookDetails getBookDetails() {
        return bookDetails;
    }
}
