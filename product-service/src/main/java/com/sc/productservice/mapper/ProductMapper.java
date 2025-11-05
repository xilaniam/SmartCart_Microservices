package com.sc.productservice.mapper;

import com.sc.productservice.dto.ProductRequestDTO;
import com.sc.productservice.dto.ProductResponseDTO;
import com.sc.productservice.model.Product;
import com.sc.productservice.utils.FieldUtils;

import java.time.LocalDate;

public class ProductMapper {
    public static ProductResponseDTO toDto(Product product){
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId().toString());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setInventoryCount(product.getInventoryCount());
        return dto;
    }

    public static Product toModel(ProductRequestDTO dto){
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setInventoryCount(dto.getInventoryCount());
        product.setCreatedAt(LocalDate.parse(dto.getCreatedAt()));
        product.setUpdatedAt(LocalDate.parse(dto.getUpdatedAt()));
        return product;
    }

    public static Product toUpdateModel(Product product , ProductRequestDTO reqDto){
        FieldUtils.updateIfNotBlank(product::setName, reqDto.getName());
        FieldUtils.updateIfNotBlank(product::setDescription, reqDto.getDescription());
        FieldUtils.updateIfNotBlank(product::setInventoryCount, reqDto.getInventoryCount());
        FieldUtils.updateIfNotBlank(product::setPrice, reqDto.getPrice());
        product.setUpdatedAt(LocalDate.parse(reqDto.getUpdatedAt()));
        return product;
    }
}
