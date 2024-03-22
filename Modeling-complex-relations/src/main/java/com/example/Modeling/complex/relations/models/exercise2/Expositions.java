package com.example.Modeling.complex.relations.models.exercise2;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
public class Expositions extends Events {
    public Expositions(Date date, int duration, String location, String title, List<Guest> list) {
        super(date, duration, location, title, list);
    }
}
