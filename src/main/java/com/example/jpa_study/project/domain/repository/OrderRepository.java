package com.example.jpa_study.project.domain.repository;

import com.example.jpa_study.project.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}