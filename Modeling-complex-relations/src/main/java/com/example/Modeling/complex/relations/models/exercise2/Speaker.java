package com.example.Modeling.complex.relations.models.exercise2;
import com.example.Modeling.complex.relations.models.exercise2.Conferences;
import jakarta.persistence.*;

import lombok.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Embeddable
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int duration;

    @ManyToOne
    private Conferences conferences;

    public Speaker(String name, int duration, Conferences conferences) {
        this.name = name;
        this.duration = duration;
        this.conferences = conferences;
    }



}
