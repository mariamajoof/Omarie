package com.tsi.mariama.joof.program;


import org.hibernate.sql.Update;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.yaml.snakeyaml.events.Event;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

public class MockitoTest {
    private MyFirstMicroServiceApplication MyFirstMicroServiceApplication;

    @Mock
    private ActorRepository ActorRepository;

    @BeforeEach
    void setUp(){
        //FIX INSTRUCTION REPO
        MyFirstMicroServiceApplication = new MyFirstMicroServiceApplication(ActorRepository);
    }

    @Test
    public void getAllActors(){

        MyFirstMicroServiceApplication.getAllActors();
        verify(ActorRepository).findAll();
    }

    @Test
    public void addActor(){

        Actor savedActor = new Actor("testCocktail","test Description");

        String expected = "Saved";

        String Actual = MyFirstMicroServiceApplication.addActor(savedActor.getFirst_name(),savedActor.getLast_name());

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);

       verify(ActorRepository).save(actorArgumentCaptor.capture());

        actorArgumentCaptor.getValue();

        Assertions.assertEquals(expected,Actual,"Actor detail(s) is not saved into the database");
    }

    //Update

    //Delete
    //MAKEUP AND ID - HOW DO I makeup and Id
    //@Test
    //public void

}

