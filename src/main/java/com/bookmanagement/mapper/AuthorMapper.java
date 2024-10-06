package com.bookmanagement.mapper;

import com.bookmanagement.model.Author;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthorMapper {

    //find all author
//    @Select("SELECT * FROM AUTHOR")
    List<Author> findAllAuthor();

    // find author by id
    Author findAuthorByID(int id);

    // find author by book id
    List<Author> findAuthorsByBookID(int book_id);

    // save author
    void saveAuthor(Author author);

    // delete author by id
    void deleteAuthor(Author author);

}