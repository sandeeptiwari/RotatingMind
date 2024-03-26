package com.rotatingmind.librarymgmt.dao;

import com.rotatingmind.librarymgmt.modle.BookCopy;
import com.rotatingmind.librarymgmt.modle.Member;

import java.util.List;

public interface Repository {

    Results getBookByName(String bookName);

    Results getBookByAuthors(List<String> authors);

    Results getMemberByName(String memberName);

    void save(BookCopy bookCopy);

    void deleteById(int id);


    void delete(BookCopy bookCopy);


    void markAsBlocked(int memberId);

    void issueBookCopyToMember(Member member, BookCopy bookCopy);


    void returnBookCopyFromMember(Member member, BookCopy bookCopy);

    void isBookCopyAvailable(BookCopy bookCopy);

    List<Results> getBorrower(BookCopy bookCopy);

    List<Results> getBorrowedBook(Member member);

}
