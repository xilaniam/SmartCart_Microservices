package com.sc.productservice.exception;

import com.sc.productservice.model.Product;

public class ProductAlreadyExistsException extends RuntimeException{
    public ProductAlreadyExistsException(String msg){
        super(msg);
    }
}
