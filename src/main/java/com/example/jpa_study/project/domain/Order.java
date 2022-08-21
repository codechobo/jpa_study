package com.example.jpa_study.project.domain;

import com.example.jpa_study.project.domain.base.BaseTimeEntity;
import com.example.jpa_study.project.domain.type.DeliveryStatus;
import com.example.jpa_study.project.domain.type.OrderStatus;
import com.example.jpa_study.project.error.ErrorCode;
import com.example.jpa_study.project.error.exception.DeliveryCompletedItemException;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NamedEntityGraph(
        name = "order-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("member"),
                @NamedAttributeNode(value = "orderItems", subgraph = "orderItems-subgraph"),
                @NamedAttributeNode("delivery"),
        },
        subgraphs = {
                @NamedSubgraph(name = "orderItems-subgraph",
                        attributeNodes = {@NamedAttributeNode("item")})})
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
    @JsonBackReference
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERIES_ID")
    private Delivery delivery;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Builder
    public Order(Member member, List<OrderItem> orderItems, Delivery delivery, OrderStatus status) {
        this.member = member;
        this.orderItems = orderItems;
        this.delivery = delivery;
        this.status = status;
    }

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

    public void updateStatus(OrderStatus status) {
        this.status = status;
    }

    public static Order createOrder(Member member, Delivery delivery, List<OrderItem> orderItems) {
        Order order = Order.builder()
                .member(member)
                .delivery(delivery)
                .orderItems(orderItems)
                .status(OrderStatus.ORDER)
                .build();

        for (OrderItem orderItem : orderItems) {
            orderItem.addOrder(order);
        }

        return order;
    }

    public void cancel() {
        isDeliveryCompleted();
        this.updateStatus(OrderStatus.CANSEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }

    private void isDeliveryCompleted() {
        if (delivery.getStatus().equals(DeliveryStatus.COMP)) {
            throw new DeliveryCompletedItemException(ErrorCode.CAN_NOT_CANCEL);
        }
    }

    public int getTotalPrice() {
        return this.orderItems.stream().mapToInt(OrderItem::getTotalPrice).sum();
    }
}
