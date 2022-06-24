package com.tsi.mariama.joof.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LanguagesTest {

    private int ExpectedTestResult;
    private int Actual;

    private String ExpectedTestResultString;
    private String ActualString;

    private Language testLanguage = new Language(3, "Spanish");

//    @Test
//    void testGetLanguage_id(){
//        ExpectedTestResult = 3;
//        Actual = testLanguage.getLanguage_id();
//        Assertions.assertEquals(ExpectedTestResult, Actual, " Incorrect Language ID");
//    }

    @Test
    void testSetLanguage_id(){
        ExpectedTestResult = 5;
        testLanguage.setLanguage_id(ExpectedTestResult);
        Actual = testLanguage.getLanguage_id();
        Assertions.assertEquals(ExpectedTestResult, Actual , "Language ID set incorrectly");
    }

    @Test
    void testGetName(){
        ExpectedTestResultString = "Spanish";
        ActualString = testLanguage.getName();
        Assertions.assertEquals(ExpectedTestResultString, ActualString, "Incorrect Name");
    }

    @Test
    void testSetName(){
        ExpectedTestResultString = "English";
        testLanguage.setName(ExpectedTestResultString);
        ActualString = testLanguage.getName();
        Assertions.assertEquals(ExpectedTestResultString, ActualString , "Name set incorrectly");
    }
}
