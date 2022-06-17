package com.tsi.mariama.joof.program;

import javax.persistence.*;

@Entity
@Table(name = "film_actor")

public class FilmActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actor_id;
    int film_id;


    // Constructor

    public FilmActor(int actor_id, int film_id) {
        this.actor_id = actor_id;
        this.film_id = film_id;
    }

    //this holds data from the database
    public FilmActor(){}
    //Getters and setters

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }
}
