package com.example.jpa_study.project.domain;

import com.example.jpa_study.project.domain.base.BaseTimeEntity;
import com.example.jpa_study.project.domain.type.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


// 주문한 회원 정보를 연관관계 없이 매핑 해보기인데?

// 주문한 회원 정보를
// - members table 에 email 필드를


// 연관관계 없이 조인
// 1. 쿼리를 새엇ㅇ

@Getter
@NoArgsConstructor
@Table(name = "ORDERS")
@Entity
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDERS_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBERS_ID")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERIES_ID")
    private Delivery delivery;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void addMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.addOrder(this);
    }

    public void addDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.addOrder(this);
    }
}
