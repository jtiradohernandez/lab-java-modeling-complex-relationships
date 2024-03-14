package com.example.Modeling.complex.relations.repository;

import com.example.Modeling.complex.relations.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
