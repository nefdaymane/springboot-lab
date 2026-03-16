package org.lab.springboot.repository;

import org.lab.springboot.entity.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FiliereRepository extends JpaRepository<Filiere, Long> {

    Optional<Filiere> findByName(String name);
    boolean existsByName(String name);
}
