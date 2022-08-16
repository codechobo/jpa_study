package com.example.jpa_study.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@DiscriminatorValue("MOVIE")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie extends Item {

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "ACTOR")
    private String actor;

    @Builder
    public Movie(String name, int price, int stockQuantity, String director, String actor) {
        super(name, price, stockQuantity);
        this.director = director;
        this.actor = actor;
    }
}
