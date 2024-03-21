package com.example.Modeling.complex.relations.repository;

import com.example.Modeling.complex.relations.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByMemberId(int memberId);
}
