package com.ecommerce.exception;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class ErrorResponse implements IErrorResponse{

    @JsonProperty("EcommerceAPIResponse")
    private ErrorResponseBody errorResponseBody;

    public ErrorResponse(ErrorResponseBody errorResponseBody) {
        this.errorResponseBody = errorResponseBody;
    }
}