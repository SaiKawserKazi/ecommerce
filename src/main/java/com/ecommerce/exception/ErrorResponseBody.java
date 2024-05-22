package com.ecommerce.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class ErrorResponseBody {
    @JsonProperty("ResponseCode")
    private String ResponseCode;

    @JsonProperty("ResponseDesc")
    private String ResponseDesc;

    public ErrorResponseBody(String ResponseCode, String ResponseDesc) {
        this.ResponseCode = ResponseCode;
        this.ResponseDesc = ResponseDesc;
    }

}