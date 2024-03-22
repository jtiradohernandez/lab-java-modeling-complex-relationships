package com.example.Modeling.complex.relations.repository.exercise2;

import com.example.Modeling.complex.relations.enums.GuestStatus;
import com.example.Modeling.complex.relations.models.exercise2.Conferences;
import com.example.Modeling.complex.relations.models.exercise2.Events;
import com.example.Modeling.complex.relations.models.exercise2.Guest;
import com.example.Modeling.complex.relations.models.exercise2.Speaker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestRepositoryTest {
    @Autowired
    ConferencesRepository conferencesRepository;
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    SpeakerRepository speakerRepository;

    Guest guest1;
    Guest guest2;

    @BeforeEach
    void setUp() {
        List<Guest> guestList = new ArrayList<Guest>();
        List<Speaker> speakerList = new ArrayList<Speaker>();
        Date date = new Date();
        Conferences conference1 = new Conferences(date, 160, "Barcelona", "Como programar en Java", guestList, speakerList);
        conferencesRepository.save(conference1);
        guest1 = new Guest("Xavi", GuestStatus.ATTENDING, conference1);
        guest2 = new Guest("Thais", GuestStatus.NOT_ATTENDING, conference1);
        guestRepository.save(guest1);
        guestRepository.save(guest2);
    }

    @AfterEach
    void tearDown() {
        guestRepository.deleteAll();
    }


    @Test
    public void createGuest(){
        Optional<Guest> guestFound = guestRepository.findById(guest1.getId());
        assertTrue(guestFound.isPresent());
        assertEquals(guest1.getId(),guestFound.get().getId());
    }
}