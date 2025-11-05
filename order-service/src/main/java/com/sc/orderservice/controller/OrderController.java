package com.sc.orderservice.controller;

import com.sc.orderservice.dto.OrderRequestDTO;
import com.sc.orderservice.dto.OrderResponseDTO;
import com.sc.orderservice.service.OrderService;
import jakarta.validation.groups.Default;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> createOrder(@PathVariable UUID id, @Validated({Default.class}) @RequestBody OrderRequestDTO reqDTO){
        OrderResponseDTO respDto = orderService.createOrder(id,reqDTO);
        return ResponseEntity.ok().body(respDto);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getOrders(){
        List<OrderResponseDTO> dtos = orderService.getOrders();
        return ResponseEntity.ok().body(dtos);
    }
}
