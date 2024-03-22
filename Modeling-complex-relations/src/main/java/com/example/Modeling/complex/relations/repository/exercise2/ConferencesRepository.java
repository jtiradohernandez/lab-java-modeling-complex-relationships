package com.example.Modeling.complex.relations.repository.exercise2;

import com.example.Modeling.complex.relations.models.exercise2.Conferences;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConferencesRepository extends JpaRepository<Conferences, String> {
    Optional<Conferences> findById(int id);
}
