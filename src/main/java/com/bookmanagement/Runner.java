package com.bookmanagement;

import com.bookmanagement.mapper.BookMapper;
import com.bookmanagement.model.Author;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import com.bookmanagement.model.Book;

public class Runner {

    /*
MiniProject: Book Management System
    1. Create Book Management System that can be used by any library or book store
    2. User (Admin) can: CRUD operations
        - register book (id, title, author, genre, pageCount fields)
        - list/display books
        - update book by id
        - delete book by id
*/

// 1. Create menu for the app
// 2. Create book class (entity)
// 3. Create methods for books
// 4. Create class to connect database

    public static void main(String[] args) throws IOException {

        // MyBatis Setting
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            start(session);
        }
    }

    public static void start(SqlSession session) {

        Scanner input = new Scanner(System.in);

        BookService bookService = new BookService(session);

        // Create an instance of service class


        int select;

        do {

            System.out.println("------------------------");
            System.out.println("--- Book Admin Panel ---");
            System.out.println("1- Register Book");
            System.out.println("2- List All Books");
            System.out.println("3- Delete Book By ID");
            System.out.println("4- Update Book");
            System.out.println("5- Find Book By ID");
            System.out.println("6- Find Authors By Book ID");
            System.out.println("7- Add Author By ID");
            System.out.println("8- Delete Author By ID");
            System.out.println("9- Find Author By ID");
            System.out.println("10- List All Authors");
            System.out.println("0- Exit ");
            System.out.println("Please Select Your Activity ");
            select = input.nextInt();
            input.nextLine(); // consume new line

            int id;
            Book book;

            switch (select) {
                case 1:
                    bookService.saveBook();
                    break;
                case 2:
                    List<Book> bookList = bookService.getAllBooks();
                    for(Book b: bookList){
                        System.out.println(b);
                    }
                    System.out.println("Books are listed");
                    break;
                case 3:
                    id = getBookID(input);
                    bookService.deleteBookByID(id);
                    break;
                case 4:
                    id = getBookID(input);
                    bookService.updateBook(id);
                    break;
                case 5:
                    id = getBookID(input);
                    book = bookService.getBookByID(id);
                    System.out.println(book);
                    break;
                case 6:
                    id = getBookID(input);
                    List<Author> authors = bookService.getAuthorsByBookID(id);
                    for(Author author: authors){
                        System.out.println(author);
                    }
                    break;
                case 7:
                    id = getBookID(input);
                    book = bookService.getBookByID(id);
                    bookService.addAuthor(book);
                    break;
                case 8:
                    id = getBookID(input);
                    book = bookService.getBookByID(id);
                    bookService.deleteAuthor(book);
                    break;
                case 9:
                    id = getAuthorID(input);
                    Author author = bookService.getAuthorByID(id);
                    System.out.println(author);
                    break;
                case 10:
                    List<Author> authorList = bookService.getAllAuthors();
                    for(Author a: authorList){
                        System.out.println(a);
                    }
                    break;
                case 0:
                    // exit
                    System.out.println("Thank You For Using the App");
                    break;
                default:
                    System.out.println("Please enter a number between 0 and 5");
                    break;
            }

        } while (select != 0);

    }

    private static int getBookID(Scanner input) {

        System.out.println("Please Enter Book ID: ");
        int id = input.nextInt();
        input.nextLine();

        return id;
    }

    private static int getAuthorID(Scanner input) {

        System.out.println("Please Enter Author ID: ");
        int id = input.nextInt();
        input.nextLine();

        return id;
    }

}