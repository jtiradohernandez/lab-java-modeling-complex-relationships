package com.example.Modeling.complex.relations.repository.exercise1;

import com.example.Modeling.complex.relations.models.exercise1.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByMemberId(int memberId);
}
