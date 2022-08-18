package com.example.jpa_study.project.service;

import com.example.jpa_study.project.domain.*;
import com.example.jpa_study.project.domain.repository.ItemRepository;
import com.example.jpa_study.project.domain.repository.MemberRepository;
import com.example.jpa_study.project.domain.repository.OrderRepository;
import com.example.jpa_study.project.domain.type.DeliveryStatus;
import com.example.jpa_study.project.error.ErrorCode;
import com.example.jpa_study.project.error.exception.NotFoundItemEntityException;
import com.example.jpa_study.project.error.exception.NotFoundMemberEntityException;
import com.example.jpa_study.project.web.dto.order_dto.ResponseOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public ResponseOrderDto saveOrder(Long memberId, Long itemId, int count) {
        // 엔티티 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundMemberEntityException(ErrorCode.NOT_FOUND_MEMBER_ENTITY));

        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new NotFoundItemEntityException(ErrorCode.NOT_FOUND_ITEM_TYPE));

        // 배송정보 생성
        Delivery delivery = Delivery.builder()
                .address(member.getAddress())
                .status(DeliveryStatus.READY)
                .build();

        // 주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        Order order = Order.createOrder(member, delivery, List.of(orderItem));
        orderRepository.save(order);

        return new ResponseOrderDto(order);
    }

    public List<ResponseOrderDto> getOrderList() {
        return orderRepository.findAll().stream()
                .map(ResponseOrderDto::new)
                .collect(Collectors.toList());
    }
}
