package org.lab.springboot.mapper;

import org.lab.springboot.dto.StudentRequestDTO;
import org.lab.springboot.dto.StudentResponseDto;
import org.lab.springboot.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequestDTO dto) {
        Student student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        student.setAge(dto.age());
        return student;
    }

    public StudentResponseDto toResponseDTO(Student student) {
        return new StudentResponseDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getAge(),
                student.getFiliere().getName()
        );
    }

    public void updateEntityFromDto(StudentRequestDTO dto, Student student) {
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        student.setAge(dto.age());
    }
}
