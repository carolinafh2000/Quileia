package com.example.crudPractica11.Controller;


import com.example.crudPractica11.Dto.MedicoDto;
import com.example.crudPractica11.Dto.Mensaje;
import com.example.crudPractica11.Dto.PacienteDto;
import com.example.crudPractica11.Entity.Medico;
import com.example.crudPractica11.Entity.Paciente;
import com.example.crudPractica11.Service.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/hospital")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ServiceController {
    @Autowired
    Service service;

    // Peticiones para Medicos

    @GetMapping("/list")
    public ResponseEntity<List<Medico>> list(){
        List<Medico> list = service.list();
        return new ResponseEntity<List<Medico>>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Medico> getById(@PathVariable("id") int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Medico medico = service.getOne(id).get();
        return new ResponseEntity<Medico>(medico, HttpStatus.OK);
    }

    @GetMapping("/detailname/{id}")
    public ResponseEntity<Medico> getByNombre(@PathVariable("nombre") String nombre){
        if(!service.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Medico medico = service.getByNombre(nombre).get();
        return new ResponseEntity<Medico>(medico, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody MedicoDto medicoDto){
        if(StringUtils.isBlank(medicoDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(service.existsByNombre(medicoDto.getNombre()))
            return new ResponseEntity(new Mensaje("Nombre ya existente"), HttpStatus.BAD_REQUEST);
        Medico medico = new Medico(medicoDto.getNombre(), medicoDto.getIdentificacion(), medicoDto.getTipo_identificacion(),
                medicoDto.getTarjeta_profesional(), medicoDto.getExperiencia(), medicoDto.getEspecialidad(),
                medicoDto.getInicio_atencion(), medicoDto.getFin_atencion());
        service.save(medico);
        return new ResponseEntity(new Mensaje("Medico creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody MedicoDto medicoDto){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if(service.existsByNombre(medicoDto.getNombre())&& service.getByNombre(medicoDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Nombre ya existente"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(medicoDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Medico medico = service.getOne(id).get();
        medico.setNombre(medicoDto.getNombre());
        medico.setIdentificacion(medicoDto.getIdentificacion());
        medico.setTipo_identificacion(medicoDto.getTipo_identificacion());
        medico.setTarjeta_profesional(medicoDto.getTarjeta_profesional());
        medico.setExperiencia(medicoDto.getExperiencia());
        medico.setEspecialidad(medicoDto.getEspecialidad());
        medico.setInicio_atencion(medicoDto.getInicio_atencion());
        medico.setFin_atencion(medicoDto.getFin_atencion());
        service.save(medico);
        return new ResponseEntity(new Mensaje("Medico actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (!service.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new Mensaje("Medico eliminado"), HttpStatus.OK);
    }

    // Peticiones para pacientes

    @GetMapping("/listPacientes")
    public ResponseEntity<List<Paciente>> listPaciente(){
        List<Paciente> list = service.listPaciente();
        return new ResponseEntity<List<Paciente>>(list, HttpStatus.OK);
    }

    @GetMapping("/detailPacientes/{id}")
    public ResponseEntity<Paciente> getByIdPaciente(@PathVariable("id") int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Paciente paciente = service.getOnePaciente(id).get();
        return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
    }

    @GetMapping("/detailnamePacientes/{id}")
    public ResponseEntity<Paciente> getByNombrePaciente(@PathVariable("nombre") String nombre){
        if(!service.existsPacienteByNombre(nombre))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Paciente paciente = service.getPacienteByNombre(nombre).get();
        return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
    }

    @PostMapping("/createPacientes")
    public ResponseEntity<?> create (@RequestBody PacienteDto pacienteDto){
        if(StringUtils.isBlank(pacienteDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(service.existsPacienteByNombre(pacienteDto.getNombre()))
            return new ResponseEntity(new Mensaje("Nombre ya existente"), HttpStatus.BAD_REQUEST);
        // Arreglar ****
        Paciente paciente = new Paciente(pacienteDto.getNombre(), pacienteDto.getNacimiento(), pacienteDto.getIdentificacion(),
                pacienteDto.getTipo_identificacion(), pacienteDto.getEps(), pacienteDto.getHistoria_clinica());
        service.savePaciente(paciente);
        return new ResponseEntity(new Mensaje("Paciente creado"), HttpStatus.OK);
    }

    @PutMapping("/updatePacientes/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody PacienteDto pacienteDto){
        if(!service.existsPacienteById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if(service.existsPacienteByNombre(pacienteDto.getNombre())&& service.getPacienteByNombre(pacienteDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Nombre ya existente"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(pacienteDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        Paciente paciente = service.getOnePaciente(id).get();
        paciente.setNombre(pacienteDto.getNombre());
        paciente.setNacimiento(pacienteDto.getNacimiento());
        paciente.setIdentificacion(pacienteDto.getIdentificacion());
        paciente.setTipo_identificacion(pacienteDto.getTipo_identificacion());
        paciente.setEps(pacienteDto.getEps());
        paciente.setHistoria_clinica(pacienteDto.getHistoria_clinica());
        service.savePaciente(paciente);
        return new ResponseEntity(new Mensaje("Paciente actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/deletePacientes/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable("id") int id){
        if (!service.existsPacienteById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        service.deletePaciente(id);
        return new ResponseEntity(new Mensaje("Paciente eliminado"), HttpStatus.OK);
    }
}
