package com.rotatingmind.librarymgmt;

import com.rotatingmind.librarymgmt.modle.BookCopy;
import com.rotatingmind.librarymgmt.modle.BookDetails;
import com.rotatingmind.librarymgmt.modle.Member;
import com.rotatingmind.librarymgmt.search.*;
import com.rotatingmind.librarymgmt.security.UserAuthenticator;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class LibraryManager {

    private final Library library;

    public LibraryManager(Library library) {
        this.library = library;
    }

    public List<Member> searchMemberByMemberName(String memName, String adminToken) throws IllegalAccessException {

        if (memName == null) {
            throw new IllegalArgumentException("Member Name can't be null");
        }

        //authentication
        if (UserAuthenticator.isMember(adminToken)) {
            throw new IllegalAccessException("Operation forbidden");
        }

        MemberSearcher memberSearcher = new NameBasedMemberSearcher(memName);
        return memberSearcher.search();
    }

    public Member searchMemberBy(Long id) {

        return null;
    }

    public List<BookCopy> searchBookByName(String bookName) {
        if (bookName == null) {
            throw new IllegalArgumentException("Boo Name cant be null");
        }
        BookSearcher bookSearcher = new NameBasedBookSearcher(bookName);
        return bookSearcher.search();
    }

    public List<BookCopy> searchBookByAuth(List<String> authorName) {
        if (authorName == null) {
            throw new IllegalArgumentException("Author Name can't be null");
        }
        BookSearcher bookSearcher = new AuthorBookSearcher(authorName);
        return bookSearcher.search();
    }

    public void addBook(String bookName, Date publicationDate, List<String> authors, String adminToken) throws IllegalAccessException {
        //authentication
        if (UserAuthenticator.isMember(adminToken)) {
            throw new IllegalAccessException("Operation forbidden");
        }
        BookDetails bookDetails = new BookDetails(bookName, publicationDate, authors);
        Random random = new Random();
        long id = IdGenerator.getUniqueId();
        BookCopy bookCopy = new BookCopy(id, bookDetails);
        library.save(bookCopy);
    }

    public void deleteBook(int bookId, String adminToken) throws IllegalAccessException {
        //authentication
        if (UserAuthenticator.isMember(adminToken)) {
            throw new IllegalAccessException("Operation forbidden");
        }

        BookSearcher bookSearcher = new IdBasedBookSearcher(bookId);
        List<BookCopy> results = bookSearcher.search();
        if (results == null) {
            throw new IllegalAccessException("Id doesn't exist");
        }

        BookCopy bookCopy = results.stream().findFirst().orElse(null);

        if (bookCopy == null) {
            throw new IllegalAccessException("Id doesn't exist");
        }

        library.delete(bookCopy);
    }

    public void blockMember(int memberId, String adminToken) throws IllegalAccessException {
        if (memberId < 0 || adminToken == null || adminToken.isEmpty()) {

        }

        if (!UserAuthenticator.isAdmin(adminToken)) {
            throw new IllegalAccessException("Operation forbidden");
        }

        MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberId);
        List<Member> members = memberSearcher.search();
        if (members == null) {
            throw new IllegalArgumentException("Incorrect Member Id");
        }

        Optional<Member> first = members.stream().findFirst();

        first.ifPresent(library::blockMember);
    }

    public void issueBook(int bookCopyId, int memId, String token) {

    }

    public void returnBook(int bookCopyId, int memId, String token) {

    }

    /*public Member getBorrowerOfBook(int bookCopyId, String adminToken) {

    }

    public List<BookCopy> getBorrowerByMember(int memberId, String adminToken) {

    }*/
}
