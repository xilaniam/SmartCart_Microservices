package com.sc.orderservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "product id cannot be null")
    private UUID productId;

    @NotNull(message = "product id cannot be null")
    private Integer quantity;

    @NotNull(message = "product id cannot be null")
    private BigDecimal unitPrice;

    @NotNull(message = "Line total cannot be null")
    private BigDecimal lineTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "order id cannot be null")
    @JoinColumn(name = "order_id" , nullable = false , foreignKey = @ForeignKey(name = "FK_orderItem_order"))
    private Order order;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(BigDecimal lineTotal) {
        this.lineTotal = lineTotal;
    }
}
