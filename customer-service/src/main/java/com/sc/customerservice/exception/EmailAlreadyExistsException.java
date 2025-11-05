package com.sc.customerservice.exception;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String ex){
        super(ex);
    }
}
