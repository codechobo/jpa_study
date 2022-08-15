package com.example.jpa_study.project.domain;


import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Entity
@DiscriminatorValue("ALBUM")
public class Album extends Item {

    private String artist;

    private String etc;
}
