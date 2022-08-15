package com.example.jpa_study.project.domain;

import com.example.jpa_study.project.domain.base.BaseTimeEntity;
import com.example.jpa_study.project.domain.type.Address;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.engine.transaction.spi.JoinStatus;

import javax.persistence.*;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Table(name = "MEMBERS_HISTORY")
@Entity
public class MemberHistory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBERS_HISTORY_ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "JOIN_STATUS")
    @Enumerated(EnumType.STRING)
    private JoinStatus joinStatus;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "city", column = @Column(name = "MEMBERS_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "MEMBERS_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "MEMBERS_ZIPCODE"))})
    private Address address;

    @Builder
    public MemberHistory(String name, String email, JoinStatus joinStatus, Address address) {
        this.name = name;
        this.email = email;
        this.joinStatus = joinStatus;
        this.address = address;
    }

    public void updateJoinStatus(JoinStatus status) {
        this.joinStatus = status;
    }
}
