package com.example.crudPractica11.Repository;

import com.example.crudPractica11.Entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    Optional<Medico> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
