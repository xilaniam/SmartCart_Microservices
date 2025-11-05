package com.sc.orderservice.exception;

public class EmptyProductStockException extends RuntimeException{
    public EmptyProductStockException(String msg){
        super(msg);
    }
}
