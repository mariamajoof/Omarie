package com.tsi.mariama.joof.program;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class MockitoTest {
    @Mock
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
    void setUp(){
        actorRepository= mock(ActorRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        languageRepository = mock(LanguageRepository.class);
        filmCategoryRepository = mock(FilmCategoryRepository.class);
        filmActorRepository = mock(FilmActorRepository.class);
        filmRepository = mock(FilmRepository.class);


        //creating an instance of the microservice
        myFirstMicroServiceApplication = new MyFirstMicroServiceApplication(actorRepository,languageRepository,categoryRepository,filmRepository,filmActorRepository,filmCategoryRepository);
    }

    @Test
    public void getAllActors(){
        //this will check if the find all  method is call
        myFirstMicroServiceApplication.getAllActors();

        //check find all  function is run
        verify(actorRepository).findAll();
    }
    @Test
    public void getAllLanguages() {

        myFirstMicroServiceApplication.getAllLanguages();
        verify(languageRepository).findAll();
    }

    @Test
    public void getAllFilmActor() {

        myFirstMicroServiceApplication.getAllFilmActor();
        verify(filmActorRepository).findAll();
    }

    @Test
    public void getAllCategory() {

        myFirstMicroServiceApplication.getAllCategory();
        verify(categoryRepository).findAll();
    }

    @Test
    public void getAllFilmCategory() {

        myFirstMicroServiceApplication.getAllFilmCategory();
        verify(filmCategoryRepository).findAll();
    }

    @Test
    public void deleteActor(){
        myFirstMicroServiceApplication.removeActor(1);
        verify(actorRepository).deleteById(1);
    }

    @Test
    public void addActor(){
        myFirstMicroServiceApplication.addActor("mariama", "Joof");
        //allows us to see what data is been saved to the database
        ArgumentCaptor<Actor> captor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(captor.capture());
        Actor actor = captor.getValue();
        Assertions.assertEquals("mariama", actor.getFirst_name());
        Assertions.assertEquals("Joof", actor.getLast_name());
    }
    @Test
    public void upDateActor(){
        Actor actornew = new Actor();
        actornew.setActor_id(6);
        // when in the futur my code has id 6 return true. when function is pretending
        when(actorRepository.existsById(6)).thenReturn(true);
        //optional function can return  something or nothing
        when(actorRepository.findById(6)).thenReturn(Optional.of(actornew));
        myFirstMicroServiceApplication.updateActor(6,"Lily", "Hopkins");
        ArgumentCaptor<Actor> captor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(captor.capture());
        Actor actor = captor.getValue();
        Assertions.assertEquals(6, actor.getActor_id());
        Assertions.assertEquals( "Lily", actor.getFirst_name());
        Assertions.assertEquals("Hopkins", actor.getLast_name());
    }


  //  @Test
//    public void addCustomer(){
//
//        Customer savedCustomer = new Customer("first_name","last_name","email", "store_id","address_id","actor_id");
//
//        String expected = "Saved";
//
//        String Actual = myFirstMicroServiceApplication.addCustomer(savedCustomer.getFirst_name(),savedCustomer.getLast_name(),savedCustomer.getEmail(),savedStore_id.get);
//
//        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
//
//        verify(customerRepository).save(customerArgumentCaptor.capture());
//
//        customerArgumentCaptor.getValue();
//
//        Assertions.assertEquals(expected,Actual,"Customer detail(s) is not saved into the database");
//    }

    //Update

    //Delete
    //MAKEUP AND ID - HOW DO I makeup and Id
//    @Test
//    public void removeActor(){
//        Actor actor = new Actor("Jake", "Jakey");
//        actor.setActor_id(1);
//        when(actorRepository.findById(1)).thenReturn(Optional.of(actor));
//        String expected = "Actor Deleted";
//        String actual = myFirstMicroServiceApplication.removeActor(1);
//        ArgumentCaptor<Integer> actorArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
//        verify(actorRepository).deleteById(actorArgumentCaptor.capture());
//        //actorArgumentCaptor.getValue();
//        Assertions.assertEquals(expected, actual, "Actor not deleted");



   // }

}

