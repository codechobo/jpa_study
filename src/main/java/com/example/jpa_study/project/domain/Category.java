package com.example.jpa_study.project.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORIES_ID")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "CATEGORIES",
            joinColumns = @JoinColumn(name = "CATEGORIES_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEMS_ID"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    public void addParentCategory(Category category) {
        this.parent = category;
    }

    public void addChildCategory(Category child) {
        this.child.add(child);
        child.addParentCategory(this);
    }
}
