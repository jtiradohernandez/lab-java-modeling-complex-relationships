package com.example.Modeling.complex.relations.repository.exercise2;

import com.example.Modeling.complex.relations.models.exercise2.Conferences;
import com.example.Modeling.complex.relations.models.exercise2.Guest;
import com.example.Modeling.complex.relations.models.exercise2.Speaker;
import com.example.Modeling.complex.relations.repository.exercise2.ConferencesRepository;
import com.example.Modeling.complex.relations.repository.exercise2.GuestRepository;
import com.example.Modeling.complex.relations.repository.exercise2.SpeakerRepository;
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
class ConferencesRepositoryTest {

    @Autowired
    ConferencesRepository conferencesRepository;
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    SpeakerRepository speakerRepository;
    @Autowired
    EventsRepository eventsRepository;
    Conferences conference1;


    @BeforeEach
    void setUp() {
        List<Guest> guestList = new ArrayList<Guest>();
        List<Speaker> speakerList = new ArrayList<Speaker>();
        Guest guest1 = new Guest();
        Guest guest2 = new Guest();
        guestList.add(guest1);
        guestList.add(guest2);
        guestRepository.save(guest1);
        guestRepository.save(guest2);
        Speaker speaker1 = new Speaker();
        Speaker speaker2 = new Speaker();
        speakerRepository.save(speaker1);
        speakerRepository.save(speaker2);
        Date date = new Date();
        conference1 = new Conferences(date, 160, "Barcelona", "Como programar en Java", guestList, speakerList);
        conferencesRepository.save(conference1);
    }

    @AfterEach
    void tearDown() {
        //conferencesRepository.deleteAll();
    }


    @Test
    public void createConference(){
        Optional<Conferences> conferenceFound = conferencesRepository.findById(conference1.getId());
        assertTrue(conferenceFound.isPresent());
        assertEquals(conference1.getId(),conferenceFound.get().getId());
    }
}