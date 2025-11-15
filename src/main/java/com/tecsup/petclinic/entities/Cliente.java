package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad Cliente
 * 
 * Representa a los clientes del sistema PetClinic.
 * 
 * @author Bryan
 */
@Entity(name = "clients")
@NoArgsConstructor
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String correo;

    private String sexo;


    public Cliente(Integer id, String nombre, String correo, String sexo) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.sexo = sexo;
    }

    
    public Cliente(String nombre, String correo, String sexo) {
        super();
        this.nombre = nombre;
        this.correo = correo;
        this.sexo = sexo;
    }
}