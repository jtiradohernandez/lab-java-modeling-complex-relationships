package com.example.Modeling.complex.relations.repository;

import com.example.Modeling.complex.relations.models.Association;
import com.example.Modeling.complex.relations.models.Chapter;
import com.example.Modeling.complex.relations.models.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AssociationRepositoryTest {

    @Autowired
    private AssociationRepository associationRepository;

    Association association;
    @BeforeEach
    void setUp() {
        List<Chapter> setChapters = new ArrayList<Chapter>();
        association = new Association("Nurse association",setChapters);
    }

    @AfterEach
    void tearDown() {
        associationRepository.deleteAll();
    }

    @Test
    public void createAssociation(){
        associationRepository.save(association);
        Optional<Association> associationFound = associationRepository.findById(association.getId());
        assertTrue(associationFound.isPresent());
        assertEquals(association.getId(),associationFound.get().getId());
    }
}