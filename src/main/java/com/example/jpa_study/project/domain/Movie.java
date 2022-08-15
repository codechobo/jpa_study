package com.example.jpa_study.project.domain;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Entity
@DiscriminatorValue("MOVIE")
public class Movie extends Item {

    private String director;

    private String actor;

}
