package com.example.Modeling.complex.relations.repository.exercise2;

import com.example.Modeling.complex.relations.models.exercise2.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpeakerRepository extends JpaRepository<Speaker, String> {
    Optional<Speaker> findById(int id);
}
