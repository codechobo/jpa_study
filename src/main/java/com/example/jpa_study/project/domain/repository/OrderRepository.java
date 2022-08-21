package com.example.jpa_study.project.domain.repository;

import com.example.jpa_study.project.domain.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @EntityGraph(value = "order-entity-graph")
    List<Order> findAll();
}