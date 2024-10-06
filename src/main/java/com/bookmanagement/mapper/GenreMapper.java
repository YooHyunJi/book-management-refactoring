package com.bookmanagement.mapper;

import com.bookmanagement.model.Genre;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GenreMapper {

    //find all genres
//    @Select("SELECT * FROM GENRE")
    List<Genre> findAllGenre();

    // find genre by id
//    @Select("SELECT * FROM GENRE WHERE genre_id = #{genre_id}")
    Genre findGenreByID(int genre_id);

}