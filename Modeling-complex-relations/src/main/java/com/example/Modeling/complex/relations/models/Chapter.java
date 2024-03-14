package com.example.Modeling.complex.relations.models;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "chapter")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chapterId;
    private String name;
    private String district;

    @OneToOne
    @JoinColumn(name="president_id")
    private Member president;

    @ManyToMany
    @JoinTable(
            name = "chapter_assignation",
            joinColumns = { @JoinColumn(name = "chapter_id")},
            inverseJoinColumns = { @JoinColumn(name = "member_id")}
    )
    private List<Member> list;
}
