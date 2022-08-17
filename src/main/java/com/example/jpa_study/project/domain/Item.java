package com.example.jpa_study.project.domain;

import com.example.jpa_study.project.domain.base.BaseTimeEntity;
import com.example.jpa_study.project.error.ErrorCode;
import com.example.jpa_study.project.error.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Table(name = "ITEMS")
@Entity
public abstract class Item extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEMS_ID")
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "STOCK_QUANTITY")
    private int stockQuantity;

    @Column(name = "DTYPE", insertable = false, updatable = false)
    private String dtype;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    public Item(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // 비지니스 로직
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        checkStock(restStock);
    }

    private void checkStock(int restStock) {
        if (restStock < 0) {
            throw new NotEnoughStockException(ErrorCode.NOT_ENOUGH_STOCK);
        } else {
            this.stockQuantity = restStock;
        }
    }
}
