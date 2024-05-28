package com.med.tracker.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ErrorInfo {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private String errorCode;

}
