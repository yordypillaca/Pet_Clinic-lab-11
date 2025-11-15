package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Cliente;
import com.tecsup.petclinic.exceptions.ClienteNotFoundException;

/**
 * 
 * @author bryan
 *
 */
public interface ClienteService {

    /**
     * Crear un nuevo cliente
     * 
     * @param cliente
     * @return
     */
    Cliente create(Cliente cliente);

    /**
     * Actualizar un cliente existente
     * 
     * @param cliente
     * @return
     */
    Cliente update(Cliente cliente);

    /**
     * Eliminar un cliente por su ID
     * 
     * @param id
     * @throws ClienteNotFoundException
     */
    void delete(Integer id) throws ClienteNotFoundException;

    /**
     * Buscar cliente por ID
     * 
     * @param id
     * @return
     * @throws ClienteNotFoundException
     */
    Cliente findById(Integer id) throws ClienteNotFoundException;

    /**
     * Buscar clientes por nombre
     * 
     * @param nombre
     * @return
     */
    List<Cliente> findByNombre(String nombre);

    /**
     * Buscar clientes por correo
     * 
     * @param correo
     * @return
     */
    List<Cliente> findByCorreo(String correo);

    /**
     * Buscar clientes por sexo
     * 
     * @param sexo
     * @return
     */
    List<Cliente> findBySexo(String sexo);

    /**
     * Listar todos los clientes
     * 
     * @return
     */
    List<Cliente> findAll();
}