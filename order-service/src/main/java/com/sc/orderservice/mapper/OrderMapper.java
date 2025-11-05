package com.sc.orderservice.mapper;

import com.sc.orderservice.dto.OrderItemDTO;
import com.sc.orderservice.dto.OrderRequestDTO;
import com.sc.orderservice.dto.OrderResponseDTO;
import com.sc.orderservice.model.Order;
import com.sc.orderservice.model.OrderItems;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class OrderMapper {
    public static Order toModel (UUID userId , OrderRequestDTO requestDTO){
        Order order = new Order();
        order.setUserId(userId);
        order.setStatus("PENDING");
        order.setCreatedAt(LocalDate.parse(requestDTO.getCreatedAt()));
        return order;
    }

    public static OrderResponseDTO toDTO (Order order , List<OrderItemDTO> itemsDto){
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setOrderId(order.getId());
        dto.setStatus(order.getStatus());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setItems(itemsDto);
        return dto;
    }

    public static OrderItemDTO toOrderItemDTO(OrderItems orderItem) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setProductId(orderItem.getProductId().toString());
        dto.setQuantity(orderItem.getQuantity());

        return dto;
    }

    public static List<OrderItemDTO> toOrderItemDTOList(List<OrderItems> orderItems){
        List<OrderItems> oItems = orderItems;
        List<OrderItemDTO> oDTOS = oItems.stream().map(o->toOrderItemDTO(o)).toList();
        return oDTOS;
    }
}
