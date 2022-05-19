package com.example.crudPractica11.Dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicoDto {
    private String nombre;
    private String identificacion;
    private String tipo_identificacion;
    private String tarjeta_profesional;
    private float experiencia;
    private String especialidad;
    private String inicio_atencion;
    private String fin_atencion;

}