package com.example.jpa_study.project.domain;

import com.example.jpa_study.project.domain.type.Address;
import com.example.jpa_study.project.domain.type.DeliveryStatus;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "DELIVERIES")
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERIES_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "city", column = @Column(name = "DELIVERIES_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "DELIVERIES_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "DELIVERIES_ZIPCODE"))})
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public void addOrder(Order order) {
        this.order = order;
    }
}
