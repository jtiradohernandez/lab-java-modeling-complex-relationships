package com.example.Modeling.complex.relations.models.exercise2;


import com.example.Modeling.complex.relations.enums.GuestStatus;
import com.example.Modeling.complex.relations.models.exercise2.Events;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Embeddable
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private GuestStatus status;

    @ManyToOne
    private Events events;

    public Guest(String name, GuestStatus status, Events events) {
        this.name = name;
        this.status = status;
        this.events = events;
    }
}
