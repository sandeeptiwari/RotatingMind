package com.rotatingmind.librarymgmt.search;

import com.rotatingmind.librarymgmt.modle.BookCopy;

import java.util.List;

public interface BookSearcher {

    List<BookCopy>  search();
}
