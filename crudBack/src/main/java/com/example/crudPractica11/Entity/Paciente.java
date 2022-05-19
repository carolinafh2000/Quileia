package com.example.crudPractica11.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private Date nacimiento;

    private String identificacion;

    private String tipo_identificacion;

    private String eps;

    private String historia_clinica;

    public Paciente(String nombre, Date nacimiento, String identificacion, String tipo_identificacion, String eps, String historia_clinica) {

        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.identificacion = identificacion;
        this.tipo_identificacion = tipo_identificacion;
        this.eps = eps;
        this.historia_clinica = historia_clinica;
    }
}
