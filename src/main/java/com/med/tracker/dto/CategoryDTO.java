package com.med.tracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Category Data Transfer Object to transfer data between client and server"
)
public record CategoryDTO(Long id, @Schema(
        description = "Category name"
) String name) {
}
