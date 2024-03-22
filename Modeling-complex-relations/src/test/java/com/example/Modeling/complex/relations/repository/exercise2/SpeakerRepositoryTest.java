package com.example.Modeling.complex.relations.repository.exercise2;

import com.example.Modeling.complex.relations.enums.GuestStatus;
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
class SpeakerRepositoryTest {

    @Autowired
    ConferencesRepository conferencesRepository;
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    SpeakerRepository speakerRepository;
    Speaker speaker1;
    Speaker speaker2;

    @BeforeEach
    void setUp() {
        List<Guest> guestList = new ArrayList<Guest>();
        List<Speaker> speakerList = new ArrayList<Speaker>();
        Date date = new Date();
        Conferences conference1 = new Conferences(date, 160, "Barcelona", "Como programar en Java", guestList, speakerList);
        conferencesRepository.save(conference1);
        Guest guest1 = new Guest("Ricard", GuestStatus.ATTENDING, conference1);
        Guest guest2 = new Guest("Victor", GuestStatus.ATTENDING, conference1);
        guestRepository.save(guest1);
        guestRepository.save(guest2);
        speaker1 = new Speaker("Xavi",160,conference1);
        speaker2 = new Speaker("Thais",160,conference1);
        speakerRepository.save(speaker1);
        speakerRepository.save(speaker2);
    }

    @AfterEach
    void tearDown() {
        speakerRepository.deleteAll();
        guestRepository.deleteAll();
        conferencesRepository.deleteAll();
    }


    @Test
    public void createSpeaker(){
        Optional<Speaker> speakerFound = speakerRepository.findById(speaker1.getId());
        assertTrue(speakerFound.isPresent());
        assertEquals(speaker1.getId(),speakerFound.get().getId());
    }

}