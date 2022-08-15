package com.example.jpa_study.project.domain;

import com.example.jpa_study.project.domain.base.BaseTimeEntity;
import com.example.jpa_study.project.error.ErrorCode;
import com.example.jpa_study.project.error.exception.NotEnoughStockException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEMS_ID")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    // 비지니스 로직
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        checkStock(restStock);
        this.stockQuantity = restStock;
    }

    private static void checkStock(int restStock) {
        if (restStock < 0) {
            throw new NotEnoughStockException(ErrorCode.NOT_ENOUGH_STOCK.getMessage(), ErrorCode.NOT_FOUND_MEMBER_ENTITY);
        }
    }

}
