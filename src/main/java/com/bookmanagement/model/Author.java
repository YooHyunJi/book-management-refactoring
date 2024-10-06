package com.bookmanagement.model;

public class Author {

    private int author_id;
    private String name;
    private int book_id;

    public Author(String name, int book_id) {
        this.name = name;
        this.book_id = book_id;
    }

    public Author(){
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Override
    public String toString() {
        return String.format(
                ">> Author Details:\n" +
                "   author_id: %d\n" +
                "   name:      %s\n" +
                "   book_id:   %d\n",
                author_id, name, book_id
        );
    }

}
