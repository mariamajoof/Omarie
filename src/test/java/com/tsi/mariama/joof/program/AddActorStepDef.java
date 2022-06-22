package com.tsi.mariama.joof.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AddActorStepDef {

//    private ActorRepository actorRepository;
//    MyFirstMicroServiceApplication app = new MyFirstMicroServiceApplication(actorRepository);

    // dummy Actor Class
    //setting values for when and given
    Actor dummyActor;
    String firsName, lastName;


        private MyFirstMicroServiceApplication myFirstMicroServiceApplication;
        //Mocking the actor repository
        @Mock
        private ActorRepository actorRepository;
        @Mock
        private CategoryRepository categoryRepository;

        @Mock
        FilmRepository filmRepository;
        @Mock
        FilmActorRepository filmActorRepository;
        @Mock
        FilmCategoryRepository filmCategoryRepository;
        @Mock
        LanguageRepository languageRepository;

        @BeforeEach
            //Its makes a mock repo
        void setUp() {
            actorRepository = mock(ActorRepository.class);
            categoryRepository = mock(CategoryRepository.class);
            languageRepository = mock(LanguageRepository.class);
            filmCategoryRepository = mock(FilmCategoryRepository.class);
            filmActorRepository = mock(FilmActorRepository.class);
            filmRepository = mock(FilmRepository.class);


            //creating an instance of the microservice
            myFirstMicroServiceApplication = new MyFirstMicroServiceApplication(actorRepository, languageRepository, categoryRepository, filmRepository, filmActorRepository, filmCategoryRepository);
        }
    @Given("I have the actor information")
    public void i_have_the_actor_information() {
    // Write code here that turns the phrase above into concrete actions
        //dummyActor = new Actor("Mariama" ,"Joof");
        firsName = "Mariama";
        lastName = "Joof";
    }
    @When("I added the actor to the database")
    public void i_added_actor_the_database() {
    // connect to my database using Api, send a web request to the database
    myFirstMicroServiceApplication.addActor(firsName, lastName);
        ArgumentCaptor<Actor> captor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(captor.capture());
        dummyActor = captor.getValue();



    }

    @Then("The system return {string}")
    public void the_system_return() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(firsName, dummyActor.getFirst_name(), "Wrong first name");
        Assertions.assertEquals(lastName, dummyActor.getLast_name(), "Wrong second name");
    }

}
