package com.transperfect.store.exception;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private HttpHeaders headers = new HttpHeaders();

    public GlobalExceptionHandler() {
        this.headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Error> handleBusinessException(BusinessException e, HttpServletResponse response) {
        logger.error("Business Error handled : {}", e.getMessage());
        Error error = new Error();
        error.setLogRef(e.getClass().getSimpleName());
        error.setMessage(e.getMessage());
        response.setStatus(e.getStatus().value());
        return new ResponseEntity<>(error, headers, e.getStatus());
    }

    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<Error> handleTechnicalException(TechnicalException e, HttpServletResponse response) {
        logger.error("Technical Error handled : {}", e.getMessage());
        Error error = new Error();
        error.setLogRef(e.getClass().getSimpleName());
        error.setMessage(e.getMessage());
        response.setStatus(e.getStatus().value());
        return new ResponseEntity<>(error, headers, e.getStatus());
    }
}

@Data
class Error {
    String logRef;
    String message;
}
