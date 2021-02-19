package miv.study.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class NoResultEntity {
    private int status;
    private String message;
    private LocalTime time;

    public NoResultEntity(int status, String message, LocalTime time) {
        this.status = status;
        this.message = message;
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
