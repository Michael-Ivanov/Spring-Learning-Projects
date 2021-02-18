package miv.study.exception;

import miv.study.entity.StudentErrorResponse;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }
}
