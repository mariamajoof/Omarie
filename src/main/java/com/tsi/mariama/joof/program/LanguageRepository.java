package com.tsi.mariama.joof.program;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageRepository extends CrudRepository<Language, Integer> {
    List<Language>findByName(String name);
}
