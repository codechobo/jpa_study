package com.example.jpa_study.project.web;

import com.example.jpa_study.project.service.OrderService;
import com.example.jpa_study.project.web.dto.order_dto.RequestOrderSaveDto;
import com.example.jpa_study.project.web.dto.order_dto.ResponseOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<ResponseOrderDto> createOrder(
            @Valid @RequestBody RequestOrderSaveDto requestOrderSaveDto) {
        ResponseOrderDto responseOrderDto = orderService.saveOrder(requestOrderSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseOrderDto);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<ResponseOrderDto>> getList() {
        List<ResponseOrderDto> orderList = orderService.getOrderList();
        return ResponseEntity.status(HttpStatus.OK).body(orderList);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Long> cancelOrder(
            @PathVariable("id") Long orderId) {
        Long cancelId = orderService.cancel(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(cancelId);
    }
}
