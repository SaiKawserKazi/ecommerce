package com.ecommerce.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


@ControllerAdvice
@RequiredArgsConstructor
public class ControllerExceptionHandler {

    private final MessageSource messageSource;
    private final String COMMON_ERROR_MESSAGE_CODE = "BECD7007";
    Logger logger = LogManager.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<IErrorResponse> handleNullPointerExceptions(@NonNull HttpServletRequest request, NullPointerException e) {
        HttpStatus status = HttpStatus.OK;
        String message = messageSource.getMessage(COMMON_ERROR_MESSAGE_CODE, new String[]{""}, Locale.ENGLISH);
        IErrorResponse errorResponse = getErrorResponseBodyFromHttpRequest(request, COMMON_ERROR_MESSAGE_CODE, message);
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(AbstractException.class)
    public ResponseEntity<IErrorResponse> handleAbstractExceptions(@NonNull HttpServletRequest request, AbstractException e) {
        HttpStatus status = HttpStatus.OK;
        String message = messageSource.getMessage(e.getMessageCode(), new String[]{""}, Locale.ENGLISH);
        logger.error(messageSource.getMessage(e.getLogMessageCode(), new String[]{""}, Locale.ENGLISH));
        IErrorResponse errorResponse = getErrorResponseBodyFromHttpRequest(request, e.getMessageCode(), message);
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<IErrorResponse> handleHttpClientErrorExceptions(@NonNull HttpServletRequest request, HttpClientErrorException e) {
        HttpStatus status = HttpStatus.OK;
        String message = messageSource.getMessage(COMMON_ERROR_MESSAGE_CODE, new String[]{""}, Locale.ENGLISH);
        IErrorResponse errorResponse = getErrorResponseBodyFromHttpRequest(request, COMMON_ERROR_MESSAGE_CODE, message);
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<IErrorResponse> handleExceptions(@NonNull HttpServletRequest request, Exception e) {
        HttpStatus status = HttpStatus.OK;
        String message = messageSource.getMessage(COMMON_ERROR_MESSAGE_CODE, new String[]{""}, Locale.ENGLISH);
        ErrorResponse responseBody = (ErrorResponse) getErrorResponseBodyFromHttpRequest(request, COMMON_ERROR_MESSAGE_CODE, message);
        return new ResponseEntity<>(responseBody, status);
    }

    public IErrorResponse getErrorResponseBodyFromHttpRequest(@NonNull HttpServletRequest request, @NonNull String errorCode, @NonNull String errorMessage) {
        try {

            return new ErrorResponse(new ErrorResponseBody(errorCode, errorMessage));
        } catch (Exception ignored) {
        }
        return getErrorResponse(errorCode, errorMessage);
    }

    @NonNull
    private ErrorResponse getErrorResponse(@NonNull String errorCode, @NonNull String errorMessage) {
        Map<String, Object> body = new HashMap<>();
        body.put("ResultCode", errorCode);
        body.put("ResultDesc", errorMessage);
        return new ErrorResponse(new ErrorResponseBody(errorCode, errorMessage));
    }





}



