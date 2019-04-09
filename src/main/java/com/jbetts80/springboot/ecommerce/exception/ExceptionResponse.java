
package com.jbetts80.springboot.ecommerce.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {

    private String message;

    private String details;

    private LocalDateTime date;

    public ExceptionResponse(String message, String details, LocalDateTime date) {
        super();
        this.message = message;
        this.details = details;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
