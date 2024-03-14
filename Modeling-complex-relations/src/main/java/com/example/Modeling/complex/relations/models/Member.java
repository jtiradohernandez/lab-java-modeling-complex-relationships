package com.example.Modeling.complex.relations.models;


import com.example.Modeling.complex.relations.enums.MemberStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;
    private String name;
    @Enumerated (EnumType.STRING)
    private MemberStatus status;
    private Date renewalDate;
}
