package com.bookmanagement.model;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private int id;
    private String title;
    private List<Author> authors;
    private Genre genre;
    private int pageCount;

    // constructors with parameters
    public Book(String title, Genre genre, int pageCount) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.genre = genre;
        this.pageCount = pageCount;
    }

    public Book() {
    }

    // getter &  setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthor() {
        return authors;
    }

//    public void setAuthor(String author) {
//        this.author = author;
//    }
    public void addAuthor(Author author){
        this.authors.add(author);
    }

    public void deleteAuthor(Author author){
        this.authors.remove(author);
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPagecount() {
        return pageCount;
    }

    public void setPagecount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return String.format(
                ">> Book Details:\n" +
                "   ID:         %d\n" +
                "   Title:      %s\n" +
                "   Author:     %s\n" +
                "   Genre:      %s\n" +
                "   Page Count: %d",
                id, title, (authors.isEmpty()? "X": authors.toString()), (genre != null ? genre.toString() : "X"), pageCount
        );
    }
}
