package com.sc.productservice.service;

import com.sc.productservice.dto.ProductRequestDTO;
import com.sc.productservice.dto.ProductResponseDTO;
import com.sc.productservice.exception.ProductAlreadyExistsException;
import com.sc.productservice.exception.ProductNotFoundException;
import com.sc.productservice.mapper.ProductMapper;
import com.sc.productservice.model.Product;
import com.sc.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ProductResponseDTO> getProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> dtos = products.stream().map(product -> ProductMapper.toDto(product)).toList();
        return dtos;
    }

    public ProductResponseDTO getProduct(UUID id){
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("The product is not found"));
        return ProductMapper.toDto(product);
    }

    public ProductResponseDTO createProduct(ProductRequestDTO reqDto){
        if(productRepository.existsByName(reqDto.getName())){
            throw new ProductAlreadyExistsException("This product already exist on the inventory " + reqDto.getName());
        }
        /*if(reqDto.getUpdatedAt().isBlank() || reqDto.getUpdatedAt() == null)
        {
            reqDto.setUpdatedAt(reqDto.getCreatedAt());
        }
        else{
            reqDto.setUpdatedAt(reqDto.getCreatedAt());
        }*/

        reqDto.setUpdatedAt(reqDto.getCreatedAt());

        Product product = ProductMapper.toModel(reqDto);

        productRepository.save(product);

        return ProductMapper.toDto(product);
    }

    public ProductResponseDTO updateProduct(UUID id , ProductRequestDTO reqDTO){
        Product product = productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("This product is not found : " + reqDTO.getName() + " : " + id));

        if (reqDTO.getName() != null && !reqDTO.getName().isBlank() &&
                productRepository.existsByNameAndIdNot(reqDTO.getName(), id)) {
            throw new ProductAlreadyExistsException("This product already exists: " + reqDTO.getName());
        }

        reqDTO.setCreatedAt(product.getCreatedAt().toString());

        product = ProductMapper.toUpdateModel(product,reqDTO);

        productRepository.save(product);

        return ProductMapper.toDto(product);
    }

    public void deleteProduct(UUID id ){
        Product product = productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("This product is not found : " + id));
        productRepository.delete(product);
    }

}
