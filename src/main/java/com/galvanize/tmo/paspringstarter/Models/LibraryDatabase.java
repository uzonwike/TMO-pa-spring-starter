package com.galvanize.tmo.paspringstarter.Models;

import java.util.ArrayList;
import java.util.HashMap;

public class LibraryDatabase {

    private static LibraryDatabase singleton = new LibraryDatabase();
    final ArrayList<Book> books = new ArrayList<>();

    private LibraryDatabase() {}

    public static LibraryDatabase getInstance() {
        if (singleton == null)
            singleton = new LibraryDatabase();
        return singleton;
    }

    public Book addBook(Book newBook) {
        Book currentBook;
        // loop through all elements
        for (int i = 0; i < this.books.size(); i++) {

            currentBook = this.books.get(i);

            //Keep traversing the list until we find a title that is alphabetically greater than that of the new book's title
            if (currentBook.title.compareToIgnoreCase(newBook.title) < 0)
                continue;
            //If we find a duplicate title, no need to re-add the book. Just return current book
            if (currentBook.title.compareToIgnoreCase(newBook.title) == 0)
                return currentBook;
            //Otherwise, we have found the location to add the new book, so add it and break out of the loop
            this.books.add(i, newBook);
            return newBook;
        }
        //We looked through all the books, and they were all alphabetically smaller than the new book, so we add the new book to the end of the list
        this.books.add(newBook);
        return newBook;
    }

    public ArrayList<Book> getAllBooks() {
        return this.books;
    }

    public void deleteAllBooks() {
        this.books.clear();
    }

    public int getNextAvailableBookID () {
        return this.books.size() + 1;
    }
}
