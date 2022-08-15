package com.example.jpa_study.project.domain;


import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Entity
@DiscriminatorValue("BOOK")
public class Book extends Item {

    private String author;

    private String isbn;


}
