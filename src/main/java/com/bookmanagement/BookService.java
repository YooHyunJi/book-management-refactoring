package com.bookmanagement;

import java.util.List;
import java.util.Scanner;

import com.bookmanagement.mapper.AuthorMapper;
import com.bookmanagement.mapper.BookMapper;
import com.bookmanagement.mapper.GenreMapper;
import com.bookmanagement.model.Author;
import com.bookmanagement.model.Book;
import com.bookmanagement.model.Genre;
import org.apache.ibatis.session.SqlSession;

public class BookService {

    private BookMapper bookMapper;
    private GenreMapper genreMapper;
    private AuthorMapper authorMapper;

    public BookService(SqlSession session){
        bookMapper = session.getMapper(BookMapper.class);
        genreMapper = session.getMapper(GenreMapper.class);
        authorMapper = session.getMapper(AuthorMapper.class);
    }

    Scanner input = new Scanner(System.in);

    public Author getAuthorByID(int author_id){

        Author author = authorMapper.findAuthorByID(author_id);
        return author;

    }

    public List<Author> getAllAuthors(){

        List<Author> author = authorMapper.findAllAuthor();
        return author;

    }

    public List<Author> getAuthorsByBookID(int book_id){

        List<Author> authors = authorMapper.findAuthorsByBookID(book_id);
        return authors;

    }

    public void addAuthor(Book book){

        System.out.println("Author ID: ");
        int author_id = input.nextInt();
        input.nextLine(); // consume new line


        Author author = authorMapper.findAuthorByID(author_id);
        book.addAuthor(author);
        authorMapper.saveAuthor(author);

    }

    public void deleteAuthor(Book book){

        System.out.println("Author ID: ");
        int author_id = input.nextInt();
        input.nextLine(); // consume new line

        Author author = authorMapper.findAuthorByID(author_id);
        book.deleteAuthor(author);
        authorMapper.deleteAuthor(author);

    }

    // Method to register book:
    public void saveBook (){

        System.out.println("Title: ");
        String title = input.nextLine();

        System.out.println("Genre ID: ");
        int genre_id = input.nextInt();
        Genre genre = genreMapper.findGenreByID(genre_id);

        System.out.println("Page Count: ");
        int pageCount = input.nextInt();

        input.nextLine(); // consume new line

        // After getting all data from the user we create a new object using constructor

        Book newBook = new Book(title, genre, pageCount);

        bookMapper.saveBook(newBook);

    }

    // bring all listed books
    public List<Book> getAllBooks (){

        List<Book> bookList = bookMapper.findAllBook();
        return bookList;

    }

    // find book by id
    public Book getBookByID (int id){

        Book book = bookMapper.findBookByID(id);
        if (book == null){
            System.out.println("There is not a book with this id: " + id);
        }
        return book;

    }

    // method to delete book by id:
    public void deleteBookByID (int id){

        bookMapper.deleteBookByID(id);

    }

    // method to update:
    public void updateBook (int id){

        // find book by id from the table:

        Book existBook = getBookByID(id);

        if (existBook == null){
            System.out.println("Book with ID: " + id + "is not found.");
        } else {
            // Ask all data from the user:

            System.out.println("Title: ");
            String title = input.nextLine();

            System.out.println("Genre ID: ");
            int genre_id = input.nextInt();
            Genre genre = genreMapper.findGenreByID(genre_id);

            System.out.println("Page Count: ");
            int pageCount = input.nextInt();

            // Start updating existing book:

            existBook.setTitle(title);

            existBook.setGenre(genre);
            existBook.setPagecount(pageCount);

            // We can leave id unchanged.

            bookMapper.updateBook(existBook);

        }

    }


}
