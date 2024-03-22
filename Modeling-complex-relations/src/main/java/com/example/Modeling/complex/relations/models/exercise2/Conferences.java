package com.example.Modeling.complex.relations.models.exercise2;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Conferences extends Events {
    @Embedded
    @OneToMany(fetch = FetchType.EAGER)
    private List<Speaker> speakerList;

    public Conferences(Date date, int duration, String location, String title, List<Guest> guestList, List<Speaker> speakerList) {
        super(date, duration, location, title, guestList);
        this.speakerList = speakerList;
    }
}
