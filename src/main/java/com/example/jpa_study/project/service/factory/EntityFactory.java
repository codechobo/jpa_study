package com.example.jpa_study.project.service.factory;

import com.example.jpa_study.project.domain.*;
import com.example.jpa_study.project.domain.type.DeliveryStatus;
import com.example.jpa_study.project.web.dto.order_dto.RequestOrderSaveDto;

import java.util.List;

public class EntityFactory {

    public static Order createOrderInfo(Member member, Item item, RequestOrderSaveDto requestOrderSaveDto) {
        Delivery delivery = getDelivery(member);
        OrderItem orderItem = getOrderItem(item, requestOrderSaveDto);
        return Order.createOrder(member, delivery, List.of(orderItem));
    }

    private static OrderItem getOrderItem(Item item, RequestOrderSaveDto requestOrderSaveDto) {
        return OrderItem.createOrderItem(item, requestOrderSaveDto.getOrderQuantity());
    }

    private static Delivery getDelivery(Member member) {
        return Delivery.createDelivery(member.getAddress(), DeliveryStatus.READY);
    }

}
