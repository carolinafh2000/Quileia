package com.example.crudPractica11.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String identificacion;

    private String tipo_identificacion;

    private String tarjeta_profesional;

    private float experiencia;

    private String especialidad;

    private String inicio_atencion;

    private String fin_atencion;

    public Medico(String nombre, String identificacion, String tipo_identificacion, String tarjeta_profesional, float experiencia, String especialidad, String inicio_atencion, String fin_atencion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tipo_identificacion = tipo_identificacion;
        this.tarjeta_profesional = tarjeta_profesional;
        this.experiencia = experiencia;
        this.especialidad = especialidad;
        this.inicio_atencion = inicio_atencion;
        this.fin_atencion = fin_atencion;
    }
}
