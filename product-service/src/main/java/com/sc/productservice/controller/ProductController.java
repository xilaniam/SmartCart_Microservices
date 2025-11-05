package com.sc.productservice.controller;

import com.sc.productservice.dto.ProductRequestDTO;
import com.sc.productservice.dto.ProductResponseDTO;
import com.sc.productservice.dto.validators.CreateProductValidatorGroup;
import com.sc.productservice.dto.validators.UpdateProductValidatorGroup;
import com.sc.productservice.service.ProductService;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService ;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts(){
        List<ProductResponseDTO> dto = productService.getProducts();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable UUID id){
        ProductResponseDTO dto = productService.getProduct(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@Validated({Default.class , CreateProductValidatorGroup.class}) @RequestBody ProductRequestDTO reqDTO){
        ProductResponseDTO dto = productService.createProduct(reqDTO);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable UUID id , @Validated({UpdateProductValidatorGroup.class}) @RequestBody ProductRequestDTO reqDTO){
        ProductResponseDTO dto = productService.updateProduct(id,reqDTO);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
