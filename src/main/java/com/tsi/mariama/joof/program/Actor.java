package com.tsi.mariama.joof.program;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="actor")

public class Actor {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String first_name;
    String last_name;

    //gets the film with a category
    @ManyToMany
    @JoinTable(name = "film_actor", joinColumns = {
            @JoinColumn(name = "actor_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "film_id", nullable = false)
    })
    Set<Film> films;

    //Constructors
    public Actor(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }

    //calling the constructor method
    public Actor(){}

    //getting the getters and setters


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}