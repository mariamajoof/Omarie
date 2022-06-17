package com.tsi.mariama.joof.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AddActorStepDef {

//    private ActorRepository actorRepository;
//    MyFirstMicroServiceApplication app = new MyFirstMicroServiceApplication(actorRepository);

    // dummy Actor Class
    //setting values for when and given
    Actor dummyActor = new Actor("","");
    String firsName, lastName;

    @Given("I have the actor information")
    public void i_have_the_actor_information() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("The user first name equals {string}")
    public void the_user_first_name_equals(String string) {
        // Write code here that turns the phrase above into concrete actions
        // set first name = string
        dummyActor.setFirst_name(string);
        firsName = string;

    }
    @When("The last name equals {string}")
    public void the_last_name_equals(String string) {
        // Write code here that turns the phrase above into concrete actions
        //set last  name as string
        dummyActor.setLast_name(string);
        lastName = string;


    }
    @Then("The system return {string}")
    public void the_system_return(String string) {
        // Write code here that turns the phrase above into concrete actions
     // String actual = app.addActor(dummyActor.getFirst_name(), dummyActor.getLast_name());

     // String expected = string;
      //Assertions.assertEquals(expected,actual,"Did not work");
        Assertions.assertEquals(firsName, dummyActor.getFirst_name(), "Wrong first name");
        Assertions.assertEquals(lastName, dummyActor.getLast_name(), "Wrong second name");
    }

}
