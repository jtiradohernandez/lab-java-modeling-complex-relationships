package com.example.Modeling.complex.relations.repository.exercise2;

import com.example.Modeling.complex.relations.models.exercise2.Conferences;
import com.example.Modeling.complex.relations.models.exercise2.Expositions;
import com.example.Modeling.complex.relations.models.exercise2.Guest;
import com.example.Modeling.complex.relations.models.exercise2.Speaker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExpositionsRepositoryTest {

    @Autowired
    ExpositionsRepository expositionsRepository;
    @Autowired
    GuestRepository guestRepository;

    Expositions exposition1;


    @BeforeEach
    void setUp() {
        List<Guest> guestList = new ArrayList<Guest>();
        Guest guest1 = new Guest();
        Guest guest2 = new Guest();
        guestList.add(guest1);
        guestList.add(guest2);
        guestRepository.save(guest1);
        guestRepository.save(guest2);
        Date date = new Date();
        exposition1 = new Expositions(date, 160, "Barcelona", "Como programar en Java", guestList);
        expositionsRepository.save(exposition1);
    }

    @AfterEach
    void tearDown() {
        expositionsRepository.deleteAll();
    }


    @Test
    public void createExposition(){
        Optional<Expositions> expositionFound = expositionsRepository.findById(exposition1.getId());
        assertTrue(expositionFound.isPresent());
        assertEquals(exposition1.getId(),expositionFound.get().getId());
    }
}