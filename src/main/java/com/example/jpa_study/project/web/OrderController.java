package com.example.jpa_study.project.web;

import com.example.jpa_study.project.service.OrderService;
import com.example.jpa_study.project.web.dto.order_dto.ResponseOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{member-id}")
    public ResponseEntity<ResponseOrderDto> createOrder(
            @PathVariable("member-id") Long memberId,
            @RequestParam("item-id") Long itemId,
            @RequestParam("count") int count) {
        ResponseOrderDto responseOrderDto = orderService.saveOrder(memberId, itemId, count);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseOrderDto);
    }

    @GetMapping
    public ResponseEntity<List<ResponseOrderDto>> getList() {
        List<ResponseOrderDto> orderList = orderService.getOrderList();
        return ResponseEntity.status(HttpStatus.OK).body(orderList);
    }
}
