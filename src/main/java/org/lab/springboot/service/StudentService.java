package org.lab.springboot.service;

import org.lab.springboot.dto.StudentRequestDTO;
import org.lab.springboot.dto.StudentResponseDto;
import org.lab.springboot.entity.Filiere;
import org.lab.springboot.entity.Student;
import org.lab.springboot.exception.DuplicateResourceException;
import org.lab.springboot.exception.ResourceNotFoundException;
import org.lab.springboot.mapper.StudentMapper;
import org.lab.springboot.repository.FiliereRepository;
import org.lab.springboot.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final FiliereRepository filiereRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, FiliereRepository filiereRepository ,StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.filiereRepository =  filiereRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto addStudent(StudentRequestDTO dto) {

        Filiere filiere = filiereRepository.findById(dto.filiereId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Filiere not found with id " + dto.filiereId()));

        if (existsByEmail(dto.email())){
            throw new DuplicateResourceException("Email already exists");
        }

        Student student = studentMapper.toEntity(dto);
        student.setFiliere(filiere);

        Student savedStudent = studentRepository.save(student);

        return studentMapper.toResponseDTO(savedStudent);
    }

    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll().stream().map(studentMapper::toResponseDTO).toList();
    }

    public List<StudentResponseDto> getStudentsByFiliereId(Long filiereId) {
        Filiere filiere = filiereRepository.findById(filiereId).orElseThrow(()-> new ResourceNotFoundException("Filiere not found" + filiereId));
        return studentRepository.findByFiliereId(filiereId).stream().map(studentMapper::toResponseDTO).toList();

    }

    public StudentResponseDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        return studentMapper.toResponseDTO(student);
    }

    public StudentResponseDto getStudentByEmail(String email) {
        Student student = studentRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Student not found with email " + email));
        return studentMapper.toResponseDTO(student);
    }

    public boolean existsByEmail(String email) {
        return studentRepository.existsByEmailIgnoreCase(email);
    }

    public StudentResponseDto updateStudentById(Long id, StudentRequestDTO dto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));

        Filiere filiere = filiereRepository.findById(dto.filiereId()).orElseThrow(() -> new ResourceNotFoundException("Filiere not found" + dto.filiereId()) );

        studentMapper.updateEntityFromDto(dto, student);
        student.setFiliere(filiere);

        Student updatedStudent = studentRepository.save(student);

        return studentMapper.toResponseDTO(updatedStudent);
    }

    public void deleteStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        studentRepository.delete(student);
    }
}
