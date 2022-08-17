package com.example.jpa_study.project.web.dto.item_dto.response;

import com.example.jpa_study.project.domain.Album;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ResponseAlbumDto {

    private final String name;
    private final int price;
    private final int stockQuantity;
    private final String artist;
    private final String etc;
    private final LocalDateTime createdAt;

    public ResponseAlbumDto(Album album) {
        this.name = album.getName();
        this.price = album.getPrice();
        this.stockQuantity = album.getStockQuantity();
        this.artist = album.getArtist();
        this.etc = album.getEtc();
        this.createdAt = album.getCreatedAt();
    }
}
