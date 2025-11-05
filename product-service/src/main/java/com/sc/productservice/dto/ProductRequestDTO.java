package com.sc.productservice.dto;

import com.sc.productservice.dto.validators.CreateProductValidatorGroup;
import com.sc.productservice.dto.validators.UpdateProductValidatorGroup;
import jakarta.validation.constraints.NotBlank;

public class ProductRequestDTO {
    @NotBlank(message = "Name is required")
    private String name;
    private String description;
    @NotBlank(message = "Price is required")
    private String price;

    @NotBlank(message = "Inventory Count is required")
    private String inventoryCount;
    @NotBlank(groups = CreateProductValidatorGroup.class  ,message = "CreatedAt is required")
    private String createdAt;
    @NotBlank(groups = UpdateProductValidatorGroup.class,message = "UpdatedAt is required")
    private String updatedAt;

    @NotBlank(message = "inventory count is required ")
    public String getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(String inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
