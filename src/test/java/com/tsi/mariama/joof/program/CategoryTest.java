package com.tsi.mariama.joof.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {


    private int ExpectedTestResult;
    private int Actual;

    private String ExpectedTestResultString;
    private String ActualString;

    private Category testCategory = new Category(3, "Children");

    @Test
    void testGetCategory_id(){
        ExpectedTestResult = 3;
        Actual = testCategory.getCategoryId();
        Assertions.assertEquals(ExpectedTestResult, Actual, "Incorrect Category ID");
    }

    @Test
    void testSetCategory_id(){
        ExpectedTestResult = 6;
        testCategory.setCategoryId(ExpectedTestResult);
        Actual = testCategory.getCategoryId();
        Assertions.assertEquals(ExpectedTestResult, Actual , "Category ID set incorrectly");
    }

    @Test
    void testGetName(){
        ExpectedTestResultString = "Children";
        ActualString = testCategory.getName();
        Assertions.assertEquals(ExpectedTestResultString, ActualString, "Incorrect Name");
    }

    @Test
    void testSetName(){
        ExpectedTestResultString = "Magic";
        testCategory.setName(ExpectedTestResultString);
        ActualString = testCategory.getName();
        Assertions.assertEquals(ExpectedTestResultString, ActualString, "Name set incorrectly");
    }
}
