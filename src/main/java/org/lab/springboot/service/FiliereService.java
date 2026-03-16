package org.lab.springboot.service;

import org.lab.springboot.dto.FiliereRequestDto;
import org.lab.springboot.dto.FiliereResponseDto;
import org.lab.springboot.entity.Filiere;
import org.lab.springboot.exception.ResourceNotFoundException;
import org.lab.springboot.mapper.FiliereMapper;
import org.lab.springboot.repository.FiliereRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService {

    private final FiliereRepository filiereRepository;
    private final FiliereMapper filiereMapper;

    public FiliereService(FiliereRepository filiereRepository, FiliereMapper filiereMapper) {
        this.filiereRepository = filiereRepository;
        this.filiereMapper = filiereMapper;
    }

    public FiliereResponseDto addFiliere(FiliereRequestDto dto) {
        Filiere filiere = filiereMapper.toEntity(dto);
        Filiere savedFiliere = filiereRepository.save(filiere);
        return filiereMapper.toResponseDTO(savedFiliere);
    }

    public List<FiliereResponseDto> getFilieres() {
        return filiereRepository.findAll().stream().map(filiereMapper::toResponseDTO).toList();
    }

    public FiliereResponseDto getFiliereById(Long id) {
        Filiere filiere = filiereRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Filiere not found" + id));
        return filiereMapper.toResponseDTO(filiere);
    }

    public FiliereResponseDto updateFiliere(Long id,FiliereRequestDto dto) {
        Filiere filiere = filiereRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Filiere not found" + id));
        filiereMapper.updateEntityFromDto(dto,filiere);

        Filiere updatedFiliere = filiereRepository.save(filiere);
        return filiereMapper.toResponseDTO(updatedFiliere);
    }

    public void deleteFiliere(Long id) {
        Filiere filiere = filiereRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Filiere not found" + id));
        filiereRepository.delete(filiere);
    }
}
