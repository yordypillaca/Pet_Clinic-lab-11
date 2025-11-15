package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Cliente;
import com.tecsup.petclinic.exceptions.ClienteNotFoundException;
import com.tecsup.petclinic.repositories.ClienteRepository;

/**
 * 
 * @author bryan
 *
 */
@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Crear cliente
     */
    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Actualizar cliente
     */
    @Override
    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Eliminar cliente
     */
    @Override
    public void delete(Integer id) throws ClienteNotFoundException {
        Cliente cliente = findById(id);
        clienteRepository.delete(cliente);
    }

    /**
     * Buscar cliente por ID
     */
    @Override
    public Cliente findById(Integer id) throws ClienteNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (!cliente.isPresent())
            throw new ClienteNotFoundException("Cliente con ID " + id + " no encontrado.");

        return cliente.get();
    }

    /**
     * Buscar cliente por nombre
     */
    @Override
    public List<Cliente> findByNombre(String nombre) {
        List<Cliente> clientes = clienteRepository.findByNombre(nombre);
        clientes.forEach(c -> log.info("" + c));
        return clientes;
    }

    /**
     * Buscar cliente por correo
     */
    @Override
    public List<Cliente> findByCorreo(String correo) {
        List<Cliente> clientes = clienteRepository.findByCorreo(correo);
        clientes.forEach(c -> log.info("" + c));
        return clientes;
    }

    /**
     * Buscar cliente por sexo
     */
    @Override
    public List<Cliente> findBySexo(String sexo) {
        List<Cliente> clientes = clienteRepository.findBySexo(sexo);
        clientes.forEach(c -> log.info("" + c));
        return clientes;
    }

    /**
     * Listar todos los clientes
     */
    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

}