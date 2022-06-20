package com.tsi.mariama.joof.program;


import DummyCode.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void setUp(){
        actorRepository= mock(ActorRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        languageRepository = mock(LanguageRepository.class);
        filmCategoryRepository = mock(FilmCategoryRepository.class);
        filmActorRepository = mock(FilmActorRepository.class);
        filmRepository = mock(FilmRepository.class);


        //FIX INSTRUCTION REPO
        myFirstMicroServiceApplication = new MyFirstMicroServiceApplication(actorRepository,languageRepository,categoryRepository,filmRepository,filmActorRepository,filmCategoryRepository);
    }

    @Test
    public void getAllActors(){

        myFirstMicroServiceApplication.getAllActors();
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
    public void addActor(){

        Actor savedActor = new Actor("first_name","last_name");

        String expected = "Saved";

        String Actual = myFirstMicroServiceApplication.addActor(savedActor.getFirst_name(),savedActor.getLast_name());

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);

       verify(actorRepository).save(actorArgumentCaptor.capture());

        actorArgumentCaptor.getValue();

        Assertions.assertEquals(expected,Actual,"Actor detail(s) is not saved into the database");
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

