package org.lab.springboot.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentRequestDTO(
        @NotBlank(message = "prenom obligatoire")
        String firstName,
        @NotBlank(message = "nom obligatoire")
        String lastName,
        @NotBlank(message = "email obligatoire")
        String email,
        @NotNull(message = "age est obligatoire")
        @Min(value = 17, message = "age min est 17")
        @Max(value = 100, message = "age max est 100")
        Integer age,
        @NotNull(message = "filiere obligatoire")
        Long filiereId
) {
}
