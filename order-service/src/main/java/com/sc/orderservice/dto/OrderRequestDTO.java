package com.sc.orderservice.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public class OrderRequestDTO {
    @NotNull(message = "Order Items cannot be empty")
    private List<OrderItemDTO> orderList;

    @NotNull(message = "Status cannot be empty")
    private String status;

    @NotNull(message = "Total Amount cannot be empty")
    private String totalAmount;

    @NotNull(message = "Created At cannot be empty")
    private String createdAt;

    @NotNull(message = "Updated At cannot be empty")
    private String updatedAt;

    public List<OrderItemDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderItemDTO> orderList) {
        this.orderList = orderList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
