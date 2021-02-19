package miv.study.rest;

import miv.study.entity.NoResultEntity;
import miv.study.exception.NoSuchCustomerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<NoResultEntity> customerNotFound(NoSuchCustomerException exception) {
        NoResultEntity entity = new NoResultEntity(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalTime.now());
        return new ResponseEntity<>(entity, HttpStatus.NOT_FOUND);
    }
}
