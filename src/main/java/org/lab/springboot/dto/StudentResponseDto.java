package org.lab.springboot.dto;

public record StudentResponseDto(
         Long id,
         String firstName,
         String lastName,
         String email,
         Integer age,
         String filiereName
) {
}
