package com.bookmanagement.mapper;

import com.bookmanagement.model.Genre;
import org.apache.ibatis.annotations.*;
import com.bookmanagement.model.Book;

import java.util.List;

@Mapper
public interface BookMapper {

    // add new book
//    @Insert("INSERT INTO BOOK (title, author, genre_id, pageCount) VALUES (#{title},#{author},#{genre.genre_id},#{pageCount})")
//    @Result(column="GENRE_ID",
//            property="genre",
//            javaType= Genre.class,
//            one = @One(select="com.bookmanagement.mapper.GenreMapper.findGenreByID"))
    void saveBook(Book book);

    //find all books
//    @Select("SELECT * FROM BOOK")
//    @Result(column="GENRE_ID",
//            property="genre",
//            javaType= Genre.class,
//            one = @One(select="com.bookmanagement.mapper.GenreMapper.findGenreByID"))
    List<Book> findAllBook();

    // find book by id
//    @Select("SELECT * FROM BOOK WHERE id = #{id}")
//    @Result(column="GENRE_ID",
//            property="genre",
//            javaType= Genre.class,
//            one = @One(select="com.bookmanagement.mapper.GenreMapper.findGenreByID"))
    Book findBookByID(int id);

    // delete book by id
//    @Delete("DELETE FROM BOOK WHERE id = #{id}")
    void deleteBookByID(int id);

    // update book
//    @Update("UPDATE BOOK SET title = #{title}, author = #{author}, genre_id = #{genre.genre_id},pageCount = #{pageCount} WHERE id = #{id}")
//    @Result(column="GENRE_ID",
//            property="genre",
//            javaType= Genre.class,
//            one = @One(select="com.bookmanagement.mapper.GenreMapper.findGenreByID"))
    void updateBook(Book existBook);

}