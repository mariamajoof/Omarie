package com.tsi.mariama.joof.program;


import javax.persistence.*;



@Entity
@Table(name= "film")

public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Attributes

    int film_id;

    String title;
    String description;

    int length;
    int language_id;

    //Constructors


    public Film(String title, String description, int length, int language_id ) {
        this.title = title;
        this.description = description;
        this.length = length;
        this.language_id = language_id;
       // this.release_year = release_year;
    }


    public Film(){}

    // Getters and Setters


    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

}
