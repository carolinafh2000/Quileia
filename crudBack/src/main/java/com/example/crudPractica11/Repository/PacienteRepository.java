package com.example.crudPractica11.Repository;

import com.example.crudPractica11.Entity.Medico;
import com.example.crudPractica11.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findByNombre(String nombre);

    boolean existsPacienteByNombre(String nombre);
}
