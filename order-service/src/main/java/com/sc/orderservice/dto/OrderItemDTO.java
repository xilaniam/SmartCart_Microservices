package com.sc.orderservice.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class OrderItemDTO {
    @NotNull
    private String productId;

    @NotNull
    private Integer quantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
