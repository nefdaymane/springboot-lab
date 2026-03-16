package org.lab.springboot.controller;

import jakarta.validation.Valid;
import org.lab.springboot.dto.FiliereRequestDto;
import org.lab.springboot.dto.FiliereResponseDto;
import org.lab.springboot.service.FiliereService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    private final FiliereService filiereService;

    public FiliereController(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FiliereResponseDto addFiliere(@Valid @RequestBody FiliereRequestDto dto) {
        return filiereService.addFiliere(dto);
    }

    @GetMapping("/{id}")
    public FiliereResponseDto getFiliereById(@PathVariable Long id) {
        return filiereService.getFiliereById(id);
    }

    @GetMapping
    public List<FiliereResponseDto> getAllFilieres() {
        return filiereService.getFilieres();
    }

    @PutMapping("/{id}")
    public FiliereResponseDto updateFiliere(@PathVariable Long id,@Valid @RequestBody FiliereRequestDto dto) {
        return filiereService.updateFiliere(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFiliere(@PathVariable Long id) {
        filiereService.deleteFiliere(id);
    }

}
