package com.tsi.mariama.joof.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmTest {

        private int ExpectedTestResult;
        private int Actual;

        private String ExpectedTestResultString;
        private String ActualString;

        private Film testFilm = new Film("The Red Book", "The red book journey", 120, 5);



        @Test
        void testSetFilmId(){
            ExpectedTestResult = 5;
            testFilm.setFilm_id(ExpectedTestResult);
            Actual = testFilm.getFilm_id();
            Assertions.assertEquals(ExpectedTestResult, Actual , "Film ID set incorrectly");
        }

        @Test
        void testGetTitle(){
            ExpectedTestResultString = "The Red Book";
            ActualString = testFilm.getTitle();
            Assertions.assertEquals(ExpectedTestResultString, ActualString, "Returns incorrect Title");
        }

        @Test
        void testSetTitle(){
            ExpectedTestResultString = "The Book Hunter";
            testFilm.setTitle(ExpectedTestResultString);
            ActualString = testFilm.getTitle();
            Assertions.assertEquals(ExpectedTestResultString, ActualString , "Name set incorrectly");
        }

        @Test
        void testGetDescription(){
            ExpectedTestResultString = "The red book journey";
            ActualString = testFilm.getDescription();
            Assertions.assertEquals(ExpectedTestResultString, ActualString, "Returns incorrect Description");
        }

        @Test
        void testSetDescription(){
            ExpectedTestResultString = "The Happy Book";
            testFilm.setDescription(ExpectedTestResultString);
            ActualString = testFilm.getDescription();
            Assertions.assertEquals(ExpectedTestResultString, ActualString , "Description set incorrectly");
        }

        @Test
        void testGetLength(){
            ExpectedTestResult = 120;
            Actual = testFilm.getLength();
            Assertions.assertEquals(ExpectedTestResult, Actual, "Returns incorrect Length");
        }

        @Test
        void testSetLength(){
            ExpectedTestResult = 130;
            testFilm.setLength(ExpectedTestResult);
            Actual = testFilm.getLength();
            Assertions.assertEquals(ExpectedTestResult, Actual , "Film Length set incorrectly");
        }

        @Test
        void testGetLanguageId(){
            ExpectedTestResult = 5;
            Actual = testFilm.getLanguage_id();
            Assertions.assertEquals(ExpectedTestResult, Actual, "Returns incorrect Film ID");
        }

        @Test
        void testSetLanguageId(){
            ExpectedTestResult = 3;
            testFilm.setLanguage_id(ExpectedTestResult);
            Actual = testFilm.getLanguage_id();
            Assertions.assertEquals(ExpectedTestResult, Actual , "Film ID set incorrectly");
        }

        @Test
        void filmConstructorTest(){
            String titleTest = "Film Test";
            Film testFilm = new Film(titleTest, "Film Test", 100, 1);

            Assertions.assertEquals(titleTest, testFilm.getTitle());
        }

    }
