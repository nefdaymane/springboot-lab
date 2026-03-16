package org.lab.springboot.controller;

import jakarta.validation.Valid;
import org.lab.springboot.dto.StudentRequestDTO;
import org.lab.springboot.dto.StudentResponseDto;
import org.lab.springboot.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDTO dto) {
        return studentService.addStudent(dto);
    }

    @GetMapping("/{id}")
    public StudentResponseDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/email/{email}")
    public StudentResponseDto getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

    @GetMapping
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/filiere/{id}")
    public List<StudentResponseDto> getAllStudentsByFiliere(@PathVariable Long id) {
        return studentService.getStudentsByFiliereId(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequestDTO dto) {
        return studentService.updateStudentById(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
}