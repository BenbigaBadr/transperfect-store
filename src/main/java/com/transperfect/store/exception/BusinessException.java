package com.transperfect.store.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public final class BusinessException extends RuntimeException {

    private String message;

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public BusinessException(Exception e) {
        super(e);
    }


    public BusinessException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

}
