package com.example.Modeling.complex.relations.repository.exercise2;

import com.example.Modeling.complex.relations.models.exercise2.Expositions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpositionsRepository extends JpaRepository<Expositions, String> {
    Optional<Expositions> findById(int id);
}
