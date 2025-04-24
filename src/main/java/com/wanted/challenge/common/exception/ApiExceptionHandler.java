package com.wanted.challenge.common.exception;

import com.wanted.challenge.common.response.ApiError;
import com.wanted.challenge.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ApiResponse<Void>> handleInvalidInputException(InvalidInputException e) {
        ApiError apiError = ApiError.builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
        ApiResponse<Void> response = ApiResponse.error(apiError);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
