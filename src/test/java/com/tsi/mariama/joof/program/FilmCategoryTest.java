package com.tsi.mariama.joof.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmCategoryTest {

    private int ExpectedTestResult;
    private int Actual;

    private FilmCategory testFilmCategory = new FilmCategory(1, 1);

    @Test
    void testGetCategory_id(){
        ExpectedTestResult = 1;
        Actual = testFilmCategory.getCategoryId();
        Assertions.assertEquals(ExpectedTestResult, Actual, "Returns incorrect Category ID");
    }

    @Test
    void testSetCategory_id(){
        ExpectedTestResult = 5;
        testFilmCategory.setCategoryId(ExpectedTestResult);
        Actual = testFilmCategory.getCategoryId();
        Assertions.assertEquals(ExpectedTestResult, Actual , "Category ID set incorrectly");
    }
}
