package com.tsi.mariama.joof.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmActorTest {

    private int ExpectedTestResult;
    private int Actual;

    private FilmActor testFilmActor = new FilmActor(10, 10);

    @Test
    void testGetFilm_id(){
        ExpectedTestResult = 10;
        Actual = testFilmActor.getFilm_id();
        Assertions.assertEquals(ExpectedTestResult, Actual, "Returns incorrect Film ID");
    }

    @Test
    void testSetFilm_id(){
        ExpectedTestResult = 8;
        testFilmActor.setFilm_id(ExpectedTestResult);
        Actual = testFilmActor.getFilm_id();
        Assertions.assertEquals(ExpectedTestResult, Actual , "Film ID set incorrectly");
    }

    @Test
    void testGetActor_id(){
        ExpectedTestResult = 10;
        Actual = testFilmActor.getActor_id();
        Assertions.assertEquals(ExpectedTestResult, Actual, "Returns incorrect Category ID");
    }

    @Test
    void testSetActor_id(){
        ExpectedTestResult = 8;
        testFilmActor.setActor_id(ExpectedTestResult);
        Actual = testFilmActor.getActor_id();
        Assertions.assertEquals(ExpectedTestResult, Actual , "Category ID set incorrectly");
    }
}
