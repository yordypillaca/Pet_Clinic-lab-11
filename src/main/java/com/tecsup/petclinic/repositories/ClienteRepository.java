package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Cliente;

/**
 * 
 * @author bryan
 *
 */
@Repository
public interface ClienteRepository 
        extends JpaRepository<Cliente, Integer> {

    
    List<Cliente> findByNombre(String nombre);

    
    List<Cliente> findByCorreo(String correo);

    
    List<Cliente> findBySexo(String sexo);

    @Override
    List<Cliente> findAll();
}