package com.tsi.mariama.joof.program;

import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findByName(String name);


}
