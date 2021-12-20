package com.galvanize.tmo.paspringstarter;

import com.galvanize.tmo.paspringstarter.Models.Book;
import com.galvanize.tmo.paspringstarter.Models.LibraryDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class LibraryController {

    @GetMapping("/health")
    public void health() {

    }

    @PostMapping("api/books")
    public ResponseEntity<Book> saveBook(@RequestBody Book requestBody) {
        //First, find out the ID to be assigned to the new book
        int newBookID = LibraryDatabase.getInstance().getNextAvailableBookID();
        //Create and add new book to the library
        Book newBook = LibraryDatabase.getInstance().addBook(new Book(newBookID, requestBody.author, requestBody.title, requestBody.yearPublished));

        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @GetMapping("api/books")
    public ResponseEntity<ArrayList<Book>> getBooks() {
        ArrayList<Book> books = LibraryDatabase.getInstance().getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping("api/books")
    public ResponseEntity<Void> deleteBooks() {
        LibraryDatabase.getInstance().deleteAllBooks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
