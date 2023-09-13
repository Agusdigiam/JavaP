package com.box.boxservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    // admin : $2a$10$3.9uXWm3/0aoh9QGO.aV8.RUOshXmymptNfnWuiOrC64saLYwiuoi
    private String password;
    private String name;
    // ADMIN
    private String rol;
    private String account_id;

}
