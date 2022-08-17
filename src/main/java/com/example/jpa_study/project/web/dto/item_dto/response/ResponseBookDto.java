package com.example.jpa_study.project.web.dto.item_dto.response;

import com.example.jpa_study.project.domain.Book;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ResponseBookDto {

    private final String name;
    private final int price;
    private final int stockQuantity;
    private final String author;
    private final String isbn;
    private final LocalDateTime createdAt;

    public ResponseBookDto(Book book) {
        this.name = book.getName();
        this.price = book.getPrice();
        this.stockQuantity = book.getStockQuantity();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
        this.createdAt = book.getCreatedAt();
    }
}
