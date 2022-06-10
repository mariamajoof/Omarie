package com.tsi.mariama.joof.program;


import org.hibernate.sql.Update;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class MockitoTest {
    private MyFirstMicroServiceApplication myFirstMicroServiceApplication;

    //Mocking the actor repository
    @Mock
    private ActorRepository actorRepository;

    @BeforeEach
    void setUp(){
        //FIX INSTRUCTION REPO
        myFirstMicroServiceApplication = new MyFirstMicroServiceApplication(actorRepository);
    }

    @Test
    public void getAllActors(){

        myFirstMicroServiceApplication.getAllActors();
        verify(actorRepository).findAll();
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

    //Update

    //Delete
    //MAKEUP AND ID - HOW DO I makeup and Id
    @Test
    public void removeActor(){
        Actor actor = new Actor("Jake", "Jakey");
        actor.setActor_id(1);
        when(actorRepository.findById(1)).thenReturn(Optional.of(actor));
        String expected = "Actor Deleted";
        String actual = myFirstMicroServiceApplication.removeActor(1);
        ArgumentCaptor<Integer> actorArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(actorRepository).deleteById(actorArgumentCaptor.capture());
        //actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Actor not deleted");



    }

}

