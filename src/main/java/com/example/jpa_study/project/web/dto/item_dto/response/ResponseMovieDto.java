package com.example.jpa_study.project.web.dto.item_dto.response;

import com.example.jpa_study.project.domain.Movie;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ResponseMovieDto {
    private final String name;
    private final int price;
    private final int stockQuantity;
    private final String director;
    private final String actor;
    private final LocalDateTime createdAt;

    public ResponseMovieDto(Movie movie) {
        this.name = movie.getName();
        this.price = movie.getPrice();
        this.stockQuantity = movie.getStockQuantity();
        this.director = movie.getDirector();
        this.actor = movie.getActor();
        this.createdAt = movie.getCreatedAt();
    }
}
