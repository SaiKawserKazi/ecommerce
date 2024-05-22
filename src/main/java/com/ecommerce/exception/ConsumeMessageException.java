package com.ecommerce.exception;



public class ConsumeMessageException extends  RuntimeException {


    public ConsumeMessageException(String message) {
        super(message);
    }


    public ConsumeMessageException(String message, Throwable cause) {
        super(message, cause);
    }


    public ConsumeMessageException(Throwable cause) {
        super(cause);
    }
}
