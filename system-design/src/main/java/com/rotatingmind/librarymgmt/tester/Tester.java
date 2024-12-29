package com.rotatingmind.librarymgmt.tester;

import com.rotatingmind.librarymgmt.Library;
import com.rotatingmind.librarymgmt.LibraryManager;

import java.util.Date;
import java.util.List;

public class Tester {

    public static void main(String[] args) {
        Library library = new Library();
        LibraryManager libraryManager = new LibraryManager(library);
        try {
            libraryManager.addBook("Cracking Interview", new Date("20 June 2019"), List.of("A.P. Gupta"), "ImFkbWluIg");
        } catch (IllegalAccessException ie) {
            System.out.println(ie.getMessage());
        }
    }
}
