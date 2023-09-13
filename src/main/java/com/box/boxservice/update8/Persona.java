package com.box.boxservice.update8;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Persona implements IPersona{
    private String nombre;

    @Override
    public Persona crear(String nombre) {
        return new Persona(nombre+"override");
    }
}
