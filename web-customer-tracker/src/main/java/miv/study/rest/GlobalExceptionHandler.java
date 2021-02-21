package miv.study.rest;

import miv.study.entity.NoResultEntity;
import miv.study.exception.CustomerAlreadyExistsException;
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

    @ExceptionHandler
    public ResponseEntity<NoResultEntity> customerAlreadyExists(
            CustomerAlreadyExistsException exception) {
        NoResultEntity entity = new NoResultEntity(
                HttpStatus.FORBIDDEN.value(),
                exception.getMessage(),
                LocalTime.now()
        );
        return new ResponseEntity<>(entity, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    public ResponseEntity<NoResultEntity> exceptionHandling(Exception exception) {
        NoResultEntity entity = new NoResultEntity(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                LocalTime.now()
        );
        return new ResponseEntity<>(entity, HttpStatus.BAD_REQUEST);
    }
}
