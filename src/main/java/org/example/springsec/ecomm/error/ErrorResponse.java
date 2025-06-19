package org.example.springsec.ecomm.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class ErrorResponse {
    private String message;
    private boolean success;
    private LocalDate date;
    private List<String> details;

    ErrorResponse(String message,List<String> details) {
        this.message = message;
        this.details = details;
        this.success = true;
        this.date = LocalDate.now();
    }
}
