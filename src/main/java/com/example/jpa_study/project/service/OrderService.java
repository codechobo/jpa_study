package com.example.jpa_study.project.service;

import com.example.jpa_study.project.domain.*;
import com.example.jpa_study.project.domain.repository.ItemRepository;
import com.example.jpa_study.project.domain.repository.MemberRepository;
import com.example.jpa_study.project.domain.repository.OrderRepository;
import com.example.jpa_study.project.domain.type.DeliveryStatus;
import com.example.jpa_study.project.error.ErrorCode;
import com.example.jpa_study.project.error.exception.BusinessException;
import com.example.jpa_study.project.error.exception.NotFoundItemEntityException;
import com.example.jpa_study.project.error.exception.NotFoundMemberEntityException;
import com.example.jpa_study.project.error.exception.NotFoundOrderEntityException;
import com.example.jpa_study.project.web.dto.order_dto.RequestOrderSaveDto;
import com.example.jpa_study.project.web.dto.order_dto.ResponseOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public ResponseOrderDto saveOrder(RequestOrderSaveDto requestOrderSaveDto) {
        // 조회
        Member member = findMemberEntity(requestOrderSaveDto);
        Item item = findItemEntity(requestOrderSaveDto);

        // 생성
        Delivery delivery = createDelivery(member);
        OrderItem orderItem = OrderItem.createOrderItem(item, requestOrderSaveDto.getOrderQuantity());
        Order order = Order.createOrder(member, delivery, List.of(orderItem));

        // 저장
        Order saveOrder = orderRepository.save(order);
        return new ResponseOrderDto(saveOrder);
    }

    private static Delivery createDelivery(Member member) {
        return Delivery.createDelivery(member.getAddress(), DeliveryStatus.READY);
    }

    private Item findItemEntity(RequestOrderSaveDto requestOrderSaveDto) {
        return getOptional(itemRepository.findById(requestOrderSaveDto.getItemId()),
                new NotFoundItemEntityException(ErrorCode.NOT_FOUND_ITEM_TYPE));
    }

    private Member findMemberEntity(RequestOrderSaveDto requestOrderSaveDto) {
        return getOptional(memberRepository.findById(requestOrderSaveDto.getMemberId()),
                new NotFoundMemberEntityException(ErrorCode.NOT_FOUND_MEMBER_ENTITY));
    }

    private <T> T getOptional(Optional<T> optional, BusinessException businessException) {
        return optional.orElseThrow(() -> businessException);
    }

    public List<ResponseOrderDto> getOrderList() {
        return orderRepository.findAll().stream()
                .map(ResponseOrderDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long cancel(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundOrderEntityException(ErrorCode.NOT_FOUND_ORDER_ENTITY));

        order.cancel();
        return order.getId();
    }
}
