package com.tsi.mariama.joof.program;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
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

    ////////Actors///////

    // get all actor
    @Test
    public void getAllActors() {
        //this will check if the find all  method is call
        myFirstMicroServiceApplication.getAllActors();

        //check find all  function is run
        verify(actorRepository).findAll();
    }

    /// delete actor
    @Test
    public void deleteActor() {
        when(actorRepository.existsById(1)).thenReturn(true);
        myFirstMicroServiceApplication.removeActor(1);
        verify(actorRepository).deleteById(1);
    }

    @Test
    public void deleteActorFalseStatement(){

        String actual =myFirstMicroServiceApplication.removeActor(1987);
        Assertions.assertEquals("Actor not found", actual);
    }

    // add actor
    @Test
    public void addActor() {
        myFirstMicroServiceApplication.addActor("mariama", "Joof");
        //allows us to see what data is been saved to the database
        ArgumentCaptor<Actor> captor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(captor.capture());
        Actor actor = captor.getValue();
        Assertions.assertEquals("mariama", actor.getFirst_name());
        Assertions.assertEquals("Joof", actor.getLast_name());
    }

    //Update actor

    //Update actor if its true
    @Test
    public void upDateActor() {
        Actor actornew = new Actor();
        actornew.setActor_id(6);
        // when in the futur my code has id 6 return true. when function is pretending
        when(actorRepository.existsById(6)).thenReturn(true);
        //optional function can return  something or nothing
        when(actorRepository.findById(6)).thenReturn(Optional.of(actornew));

        myFirstMicroServiceApplication.updateActor(6, "Lily", "Hopkins");
        ArgumentCaptor<Actor> captor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(captor.capture());
        Actor actor = captor.getValue();
        Assertions.assertEquals(6, actor.getActor_id());
        Assertions.assertEquals("Lily", actor.getFirst_name());
        Assertions.assertEquals("Hopkins", actor.getLast_name());
    }

    //Testing the false statement update actor
    @Test
    public void updateActorFalseStatement(){

        String actual =myFirstMicroServiceApplication.updateActor(1987, "Marie", "Leo");
        Assertions.assertEquals("Actor 1987 not found in the system.", actual);
    }
    ////////////////LANGUAGE///////////////


    @Test
    public void getAllLanguages() {

        myFirstMicroServiceApplication.getAllLanguages();
        verify(languageRepository).findAll();
    }
    @Test
    public void getLanguageName(){

    }

    @Test
    public void getLanguageById() {

        Language dummyLanguage = new Language();
        dummyLanguage.setLanguage_id(7);
        when(languageRepository.existsById(7)).thenReturn(true);
        when(languageRepository.findById(7)).thenReturn(Optional.of(dummyLanguage));

        String expected = dummyLanguage.getName();
        String actual = myFirstMicroServiceApplication.getLanguageById(dummyLanguage.language_id);

        Assertions.assertEquals(expected, actual, "Values are not the same");
    }

    ////////FILM//////////

    @Test
    public void getFilmByIdToName() {
        Film dummyFilm = new Film();
        dummyFilm.setFilm_id(8);
        when(filmRepository.findById(dummyFilm.getFilm_id())).thenReturn(Optional.of(dummyFilm));

        Film expected = dummyFilm;
        Film actual = myFirstMicroServiceApplication.getFilmByIdToName(dummyFilm.getFilm_id());
        Assertions.assertEquals(expected, actual, "Values are not the same");

    }
    @Test
    public void getFilmById(){

    }

    @Test
    public void getAllFilmActor() {
        myFirstMicroServiceApplication.getAllFilmActor();
        verify(filmActorRepository).findAll();

    }


    @Test
    void getFilmByKeyword() {
        String word = "Start";
        myFirstMicroServiceApplication.getFilmByWordSearch(word);
        verify(filmRepository).findByDescriptionLikeOrTitleLike("%" + word + "%", "%" + word + "%");
    }

    ////////CATEGORY//////////

    @Test
    public void getFilmIdByCategory(){
 }


    @Test
    public void getAllCategory() {

        myFirstMicroServiceApplication.getAllCategory();
        verify(categoryRepository).findAll();
    }

    //    @Test
//    public void getCategoryId(){
//        myFirstMicroServiceApplication.getCategoryId();
//        verify(categoryRepository).findByName();
//
//    }
    @Test
    public void getAllFilmCategory() {

        myFirstMicroServiceApplication.getAllFilmCategory();
        verify(filmCategoryRepository).findAll();
    }


}

