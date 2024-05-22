package com.ecommerce.exception;

import lombok.Data;

import java.util.UUID;


@Data
public class AbstractException extends Exception {

    private static final long serialVersionUID = 9004674664241996502L;

    private String messageCode;
    private String logMessageCode;
    private String requestId;

    public AbstractException(String messageCode, String logMessageCode) {
        super(messageCode);
        this.messageCode = messageCode;
        this.logMessageCode = logMessageCode;
        this.requestId = String.valueOf(UUID.randomUUID());
    }

/*    public AbstractException(String messageCode, String requestId) {
        super(messageCode);
        this.messageCode = messageCode;
        this.requestId = requestId;
    }*/

    public AbstractException(String messageCode, String logMessageCode, String requestId) {
        super(messageCode);
        this.messageCode = messageCode;
        this.logMessageCode = logMessageCode;
        this.requestId = requestId;
    }

    @Override
    public String getMessage() {
        return messageCode;
    }

}
