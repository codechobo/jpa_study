package com.example.jpa_study.project.domain;


import com.example.jpa_study.project.domain.base.BaseTimeEntity;
import com.example.jpa_study.project.domain.type.Address;
import lombok.*;
import org.hibernate.engine.transaction.spi.JoinStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Getter
@NoArgsConstructor
@Table(name = "MEMBERS")
@Entity
@EntityListeners(value = MemberHistoryListener.class)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBERS_ID")
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

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Member(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public void updateAddress(Address address) {
        this.address = address;
    }

    public void joinStatus(JoinStatus status) {
        this.joinStatus = status;
    }
}
