package com.tsi.mariama.joof.program;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int language_id;

    // Attributes
    String name;
    // Constructor

    public Language(int language_id, String name) {
        this.language_id = language_id;
        this.name = name;
    }

    public Language(){}

    //Getters and setters


    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
