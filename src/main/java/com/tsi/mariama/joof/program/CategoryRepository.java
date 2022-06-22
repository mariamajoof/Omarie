package com.tsi.mariama.joof.program;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findByName(String name);

    //List<Category> findByNameAndId(String name, int category_id);
}
