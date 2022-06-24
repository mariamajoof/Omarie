package com.tsi.mariama.joof.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorTest {

    private int ExpectedTestResult;
    private int Actual;

    private String ExpectedTestResultString;
    private String ActualString;


    private Actor testActor = new Actor( "FirstName", "LastName");

    @Test
    void testSetActor_id(){
        ExpectedTestResult = 5;
        testActor.setActor_id(ExpectedTestResult);
        Actual = testActor.getActor_id();
        Assertions.assertEquals(ExpectedTestResult, Actual , "Actor ID set incorrectly");
    }


    @Test
    void testSetFirstName(){
        ExpectedTestResultString = "John";
        testActor.setFirst_name(ExpectedTestResultString);
        ActualString = testActor.getFirst_name();
        Assertions.assertEquals(ExpectedTestResultString, ActualString , "First Name set incorrectly");
    }

    @Test
    void testGetFirstName(){
        ExpectedTestResultString = "FirstName";
        ActualString = testActor.getFirst_name();
        Assertions.assertEquals(ExpectedTestResultString, ActualString, "Returns incorrect First Name");
    }

    @Test
    void testSetLastName(){
        ExpectedTestResultString = "Smith";
        testActor.setLast_name(ExpectedTestResultString);
        ActualString = testActor.getLast_name();
        Assertions.assertEquals(ExpectedTestResultString, ActualString , "Last Name set incorrectly");
    }

    @Test
    void testGetLastName(){
        ExpectedTestResultString = "LastName";
        ActualString = testActor.getLast_name();
        Assertions.assertEquals(ExpectedTestResultString, ActualString, "Returns incorrect Last Name");
    }
}
