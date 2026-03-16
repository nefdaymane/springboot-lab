package org.lab.springboot.dto;

import jakarta.validation.constraints.NotBlank;

public record FiliereRequestDto(
        @NotBlank
        String name
) {
}
