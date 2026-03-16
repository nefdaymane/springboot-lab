package org.lab.springboot.mapper;

import org.lab.springboot.dto.FiliereRequestDto;
import org.lab.springboot.dto.FiliereResponseDto;
import org.lab.springboot.entity.Filiere;
import org.springframework.stereotype.Component;

@Component
public class FiliereMapper {

    public Filiere toEntity(FiliereRequestDto dto){
        Filiere filiere = new Filiere();
        filiere.setName(dto.name());
        return filiere;
    }

    public FiliereResponseDto toResponseDTO(Filiere filiere){
        return new FiliereResponseDto(
                filiere.getId(),
                filiere.getName()
        );
    }

    public void updateEntityFromDto(FiliereRequestDto dto, Filiere filiere){
        filiere.setName(dto.name());
    }
}
