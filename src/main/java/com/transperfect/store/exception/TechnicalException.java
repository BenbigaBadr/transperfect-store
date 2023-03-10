package com.transperfect.store.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class TechnicalException extends Exception {

    private String message;

    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;


    public TechnicalException(Exception e) {
        super(e.getMessage(), e);
        this.message = e.getMessage();
    }

    public TechnicalException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

}
