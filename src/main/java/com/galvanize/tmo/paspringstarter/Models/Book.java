package com.galvanize.tmo.paspringstarter.Models;

public class Book {

    public int id;
    public String author;
    public String title;
    public int yearPublished;

    public Book (int id, String author, String title, int yearPublished) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.yearPublished = yearPublished;
    }
}
