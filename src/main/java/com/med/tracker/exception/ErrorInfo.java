package com.med.tracker.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Schema(description = "Error Information Data Transfer Object to transfer error response data between client and server")
public class ErrorInfo {
    @Schema(
            description = "The timestamp when the error occurred",
            example = "2024-05-27T11:28:44.001"
    )

    private LocalDateTime timestamp;
    @Schema(
            description = "A brief message describing the error",
            example = "Resource not found"
    )
    private String message;
    @Schema(
            description = "Detailed information about the error",
            example = "Resource not found"
    )
    private String details;
    @Schema(
            description = "An error code categorizing the error",
            example = "CATEGORY_NOT_FOUND"
    )
    private String errorCode;

}
