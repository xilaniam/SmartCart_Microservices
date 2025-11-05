package com.sc.orderservice.service;

import com.sc.orderservice.dto.OrderItemDTO;
import com.sc.orderservice.dto.OrderRequestDTO;
import com.sc.orderservice.dto.OrderResponseDTO;
import com.sc.orderservice.exception.EmptyProductStockException;
import com.sc.orderservice.grpc.ProductServiceGrpcClient;
import com.sc.orderservice.mapper.OrderMapper;
import com.sc.orderservice.model.Order;
import com.sc.orderservice.model.OrderItems;
import com.sc.orderservice.repository.OrderItemRepository;
import com.sc.orderservice.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import product.GetProductResponse;
import product.UpdateStockResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductServiceGrpcClient productServiceGrpcClient;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository , ProductServiceGrpcClient productServiceGrpcClient){
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productServiceGrpcClient = productServiceGrpcClient;
    }

    public OrderResponseDTO createOrder(UUID userId , OrderRequestDTO requestDTO){
        Order order = OrderMapper.toModel(userId,requestDTO);
        List<OrderItems> items = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
        for(OrderItemDTO dto : requestDTO.getOrderList()){
            OrderItems orderItem = new OrderItems();
            orderItem.setProductId(UUID.fromString(dto.getProductId()));

            GetProductResponse productResponse = productServiceGrpcClient.getProductId(dto.getProductId());

            if(Integer.valueOf(productResponse.getInventoryCount()) < dto.getQuantity()){
                throw new EmptyProductStockException("Theere are no items on the inventory stock of "+ productResponse.getName());
            }

            orderItem.setQuantity(dto.getQuantity());
            BigDecimal price = new BigDecimal(productResponse.getPrice());
            orderItem.setUnitPrice(price);
            orderItem.setOrder(order);
            orderItem.setLineTotal(price.multiply(BigDecimal.valueOf(dto.getQuantity())));
            total = total.add(orderItem.getLineTotal());
            items.add(orderItem);

            productServiceGrpcClient.updateProductStock(dto.getProductId(), -dto.getQuantity());
        }

        List<OrderItemDTO> orderItemDTOList = requestDTO.getOrderList();

        order.setItems(items);
        order.setTotalAmount(total.toString());
        order.setStatus("ORDERING");

        orderRepository.save(order);
        orderItemRepository.saveAll(items);

        return OrderMapper.toDTO(order,orderItemDTOList);
    }

    public List<OrderResponseDTO> getOrders(){
        List<Order> orders = orderRepository.findAll();
        List<OrderResponseDTO> responseDTOS = orders.stream()
                .map(o -> OrderMapper.toDTO(o , OrderMapper.toOrderItemDTOList(o.getItems())))
                .toList();
        return responseDTOS;
    }

}
