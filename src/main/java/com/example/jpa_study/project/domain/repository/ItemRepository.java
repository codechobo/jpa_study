package com.example.jpa_study.project.domain.repository;

import com.example.jpa_study.project.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    boolean existsByName(String name);
}