package com.example.crudPractica11.Dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteDto {
    private String nombre;
    private Date nacimiento;
    private String identificacion;
    private String tipo_identificacion;
    private String eps;
    private String historia_clinica;

}