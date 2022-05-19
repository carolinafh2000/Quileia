package com.example.crudPractica11.Service;

import com.example.crudPractica11.Entity.Medico;
import com.example.crudPractica11.Entity.Paciente;
import com.example.crudPractica11.Repository.MedicoRepository;
import com.example.crudPractica11.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@Transactional
public class Service {
    @Autowired
    MedicoRepository medicoRepository;
    @Autowired
    PacienteRepository pacienteRepository;

    //Metodos para medicos

    public List<Medico> list(){
        return medicoRepository.findAll();
    }

    public Optional<Medico> getOne(int id){
        return medicoRepository.findById(id);
    }

    public Optional<Medico> getByNombre(String nombre){
        return medicoRepository.findByNombre(nombre);
    }

    public void save(Medico medico){
        medicoRepository.save(medico);
    }

    public void delete(int id){
        medicoRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return medicoRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return medicoRepository.existsByNombre(nombre);
    }

    // Metodos para pacientes

    public List<Paciente> listPaciente(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> getOnePaciente(int id){
        return pacienteRepository.findById(id);
    }

    public Optional<Paciente> getPacienteByNombre(String nombre){ return pacienteRepository.findByNombre(nombre); }

    public void savePaciente(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    public void deletePaciente(int id){
        pacienteRepository.deleteById(id);
    }

    public boolean existsPacienteById(int id){
        return pacienteRepository.existsById(id);
    }

    public boolean existsPacienteByNombre(String nombre){
        return pacienteRepository.existsPacienteByNombre(nombre);
    }
}

