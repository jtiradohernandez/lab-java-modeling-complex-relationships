package com.example.Modeling.complex.relations.models.exercise2;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private int duration;
    private String location;
    private String title;
    @Embedded
    @OneToMany(fetch = FetchType.EAGER)
    private List<Guest> guestList;

    public Events(Date date, int duration, String location, String title, List<Guest> guestList) {
        this.date = date;
        this.duration = duration;
        this.location = location;
        this.title = title;
        this.guestList = guestList;
    }
}
