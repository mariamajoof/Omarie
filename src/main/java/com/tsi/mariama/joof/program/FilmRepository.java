package com.tsi.mariama.joof.program;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

import java.time.Year;
import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Integer> {
    //Creating a method to find the des and title
    List<Film>findByDescriptionLikeOrTitleLike(String title, String description);

   // List<Film> findByReleaseYear(Year release_year);

    //List<Film>findByReleaseYear(Year release_year);

}
