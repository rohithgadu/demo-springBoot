package com.example.cmsapplication.exception;

public class ApplicatonError {

    private int code;
    private String message;
    private String details;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
