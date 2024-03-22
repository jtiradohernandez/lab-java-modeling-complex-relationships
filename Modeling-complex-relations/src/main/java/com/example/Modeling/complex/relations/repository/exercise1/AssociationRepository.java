package com.example.Modeling.complex.relations.repository.exercise1;

import com.example.Modeling.complex.relations.models.exercise1.Association;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssociationRepository extends JpaRepository<Association, String> {
    Optional<Association> findById(int id);
}
