package com.example.jpa_study.project.domain.repository;

import com.example.jpa_study.project.domain.MemberHistory;
import org.hibernate.engine.transaction.spi.JoinStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Long> {
    @Query("select m from MemberHistory m where m.joinStatus=:status")
    Page<MemberHistory> findAllByJoinStatus(@Param("status") JoinStatus joinStatus, Pageable pageable);
}
