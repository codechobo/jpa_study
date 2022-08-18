package com.example.jpa_study.project.web.dto.order_dto;

import com.example.jpa_study.project.domain.Order;
import com.example.jpa_study.project.domain.type.Address;
import com.example.jpa_study.project.domain.type.DeliveryStatus;
import com.example.jpa_study.project.domain.type.OrderStatus;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ResponseOrderDto {

    private final String memberEmail;
    private final Address memberAddress;

    private final List<ResponseOrderItemListDto> orderItems;

    private final DeliveryStatus deliveryStatus;
    private final OrderStatus orderStatus;

    public ResponseOrderDto(Order order) {
       this.memberEmail = order.getMember().getEmail();
       this.memberAddress = order.getDelivery().getAddress();
       this.orderItems = order.getOrderItems().stream()
               .map(ResponseOrderItemListDto::new)
               .collect(Collectors.toList());
       this.deliveryStatus = order.getDelivery().getStatus();
       this.orderStatus = order.getStatus();
    }
}
