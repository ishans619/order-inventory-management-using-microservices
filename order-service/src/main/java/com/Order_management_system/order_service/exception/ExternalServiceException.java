package com.Order_management_system.order_service.exception;

public class ExternalServiceException extends RuntimeException{

    public ExternalServiceException(String message){
        super(message);
    }
}
