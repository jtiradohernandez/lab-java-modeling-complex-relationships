package com.example.Modeling.complex.relations.repository;

import com.example.Modeling.complex.relations.models.Association;
import com.example.Modeling.complex.relations.models.Chapter;
import com.example.Modeling.complex.relations.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssociationRepository extends JpaRepository<Association, String> {


    Optional<Association> findById(int id);
}
