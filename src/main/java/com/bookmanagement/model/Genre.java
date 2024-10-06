package com.bookmanagement.model;

public class Genre {

    private int genre_id;
    private String name;

    public Genre(int genre_id, String name) {
        this.genre_id = genre_id;
        this.name = name;
    }

    public Genre(){
    }

    public int getGenreId() {
        return genre_id;
    }

    public void setGenreId(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                ">> Genre Details:\n" +
                "       genre_id:  %d\n" +
                "       name:      %s\n",
                genre_id, name
        );
    }
}
