package org.lab.springboot.repository;

import org.lab.springboot.entity.Filiere;
import org.lab.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByEmail(String email);
    List<Student> findByFiliereId(Long id);
    boolean existsByEmailIgnoreCase(String email);
}
