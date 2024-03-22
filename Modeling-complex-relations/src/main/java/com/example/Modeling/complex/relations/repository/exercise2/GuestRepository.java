package com.example.Modeling.complex.relations.repository.exercise2;

import com.example.Modeling.complex.relations.models.exercise2.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, String> {
    Optional<Guest> findById(int id);
}
