package com.rotatingmind.librarymgmt;

import com.rotatingmind.librarymgmt.modle.BookCopy;
import com.rotatingmind.librarymgmt.modle.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<Long, BookCopy> bookCopyById = new HashMap<>();


    public void save(BookCopy bookCopy) {
        bookCopyById.put(bookCopy.getId(), bookCopy);
    }

    public void delete(BookCopy bookCopy) {
        bookCopyById.put(bookCopy.getId(), bookCopy);
    }

    public void blockMember(Member member) {

    }

    public void issueBook(BookCopy bookCopy, Member member) {

    }

    public void returnBook(BookCopy bookCopy, Member member) {

    }

    public void getBorrower(BookCopy bookCopy) {

    }

    public List<BookCopy> getBorrowedBook(Member member) {
        return null;
    }
}
