package com.box.boxservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class AuthenticationDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String email;
    private String clave;

}
