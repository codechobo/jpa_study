package com.example.jpa_study.project.domain.repository;

import com.example.jpa_study.project.domain.MemberHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Long> {
}
