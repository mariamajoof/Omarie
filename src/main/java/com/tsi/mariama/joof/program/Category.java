package com.tsi.mariama.joof.program;

//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "category_id")
    int categoryId;
    String name;
    //gets the film with a category
    @ManyToMany
    @JoinTable(name = "film_category", joinColumns = {
            @JoinColumn(name = "category_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "film_id", nullable = false)
    })
    Set<Film> films;

    public Category(int categoryId, String name){

        this.categoryId = categoryId;
        this.name = name;
     }

    public Category(){}


    //Getters and setters

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
