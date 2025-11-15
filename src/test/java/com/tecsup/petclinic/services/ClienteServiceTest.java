package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Cliente;
import com.tecsup.petclinic.exceptions.ClienteNotFoundException;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    /**
     * Test para buscar cliente por ID
     */
    @Test
    public void testFindClienteById() {

        Integer ID = 1;
        String NOMBRE_ESPERADO = "Bryan Coronel";

        Cliente cliente = null;

        try {
            cliente = this.clienteService.findById(ID);
        } catch (ClienteNotFoundException e) {
            fail(e.getMessage());
        }

        assertEquals(NOMBRE_ESPERADO, cliente.getNombre());
    }

    /**
     * Test para buscar clientes por nombre
     */
    @Test
    public void testFindClienteByNombre() {

        String NOMBRE_BUSCAR = "Carla Mendoza";
        int TAMANO_ESPERADO = 1;

        List<Cliente> clientes = this.clienteService.findByNombre(NOMBRE_BUSCAR);

        assertEquals(TAMANO_ESPERADO, clientes.size());
    }

    /**
     * Test para buscar clientes por correo
     */
    @Test
    public void testFindClienteByCorreo() {

        String CORREO_BUSCAR = "bryan@gmail.com";
        int TAMANO_ESPERADO = 1;

        List<Cliente> clientes = this.clienteService.findByCorreo(CORREO_BUSCAR);

        assertEquals(TAMANO_ESPERADO, clientes.size());
    }

    /**
     * Test para buscar clientes por sexo
     */
    @Test
    public void testFindClienteBySexo() {

        String SEXO_BUSCAR = "M";
        int TAMANO_ESPERADO = 4; // Bryan, Luis, Pedro, Carlos

        List<Cliente> clientes = this.clienteService.findBySexo(SEXO_BUSCAR);

        assertEquals(TAMANO_ESPERADO, clientes.size());
    }

    /**
     * Test para crear un nuevo cliente
     */
    @Test
    public void testCreateCliente() {

        String NOMBRE = "Carlos Ramírez";
        String CORREO = "carlos.ramirez@example.com";
        String SEXO = "M";

        Cliente cliente = new Cliente(NOMBRE, CORREO, SEXO);

        Cliente clienteCreado = this.clienteService.create(cliente);

        log.info("CLIENTE CREADO: " + clienteCreado.toString());

        assertNotNull(clienteCreado.getId());
        assertEquals(NOMBRE, clienteCreado.getNombre());
        assertEquals(CORREO, clienteCreado.getCorreo());
        assertEquals(SEXO, clienteCreado.getSexo());
    }

    /**
     * Test para actualizar un cliente
     */
    @Test
    public void testUpdateCliente() {

        String NOMBRE = "Luis Soto";
        String CORREO = "luis.soto@example.com";
        String SEXO = "M";

        String UP_NOMBRE = "Luis Alberto Soto";
        String UP_CORREO = "luis.alberto@example.com";
        String UP_SEXO = "M";

        Cliente cliente = new Cliente(NOMBRE, CORREO, SEXO);

        // Crear cliente
        Cliente clienteCreado = this.clienteService.create(cliente);
        log.info("CLIENTE CREADO: " + clienteCreado);

        // Actualizar datos
        clienteCreado.setNombre(UP_NOMBRE);
        clienteCreado.setCorreo(UP_CORREO);
        clienteCreado.setSexo(UP_SEXO);

        Cliente clienteActualizado = this.clienteService.update(clienteCreado);
        log.info("CLIENTE ACTUALIZADO: " + clienteActualizado);

        assertEquals(UP_NOMBRE, clienteActualizado.getNombre());
        assertEquals(UP_CORREO, clienteActualizado.getCorreo());
        assertEquals(UP_SEXO, clienteActualizado.getSexo());
    }

    /**
     * Test para eliminar cliente
     */
    @Test
    public void testDeleteCliente() {

        String NOMBRE = "Pedro Ruiz";
        String CORREO = "pedro.ruiz@example.com";
        String SEXO = "M";

        Cliente cliente = new Cliente(NOMBRE, CORREO, SEXO);
        cliente = this.clienteService.create(cliente);
        log.info("CLIENTE CREADO: " + cliente);

        try {
            this.clienteService.delete(cliente.getId());
        } catch (ClienteNotFoundException e) {
            fail(e.getMessage());
        }

        // Validar eliminación
        try {
            this.clienteService.findById(cliente.getId());
            fail("El cliente no debería existir después de ser eliminado.");
        } catch (ClienteNotFoundException e) {
            assertTrue(true);
        }
    }
}