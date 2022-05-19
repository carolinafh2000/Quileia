package com.example.crudPractica11.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class Mensaje {

    private String mensaje;


    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }


}
