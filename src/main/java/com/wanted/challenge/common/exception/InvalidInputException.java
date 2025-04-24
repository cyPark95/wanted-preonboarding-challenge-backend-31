package com.wanted.challenge.common.exception;

import lombok.Getter;

@Getter
public class InvalidInputException extends RuntimeException {

    private final String code = "INVALID_INPUT";

    public InvalidInputException(String message) {
        super(message);
    }
}
