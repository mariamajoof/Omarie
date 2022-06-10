package com.tsi.mariama.joof.program;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "film_category")

public class FilmCategory  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int category_id;
    int film_id;
    DateTimeFormat last_update;

    public FilmCategory(int category_id, int film_id, DateTimeFormat last_update){
        this.category_id = category_id;
        this.film_id = film_id;
        this.last_update = last_update;

    }

}
