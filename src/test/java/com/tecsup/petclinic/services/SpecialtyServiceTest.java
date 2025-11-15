package com.tecsup.petclinic.services;
import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.exceptions.SpecialtyNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class SpecialtyServiceTest {

	@Autowired
	private SpecialtyService specialtyService;

	/**
	 * Test: buscar una especialidad por su ID
	 */
	@Test
	public void testFindSpecialtyById() {
		Integer ID = 1;
		String EXPECTED_NAME = "Radiology";
		String EXPECTED_DESCRIPTION = "Specialty focused on diagnostic imaging.";
		Specialty specialty = null;

		try {
			specialty = specialtyService.findById(ID);
		} catch (SpecialtyNotFoundException e) {
			fail("No se encontró la especialidad con ID: " + ID);
		}

		log.info("Especialidad encontrada: {}", specialty);

		assertNotNull(specialty);
		assertEquals(EXPECTED_NAME, specialty.getName());
		assertEquals(EXPECTED_DESCRIPTION, specialty.getDescription());
	}

	/**
	 * Test: crear una nueva especialidad
	 */
	@Test
	public void testCreateSpecialty() {
		String NAME = "Cardiology";
		String DESCRIPTION = "Specialty focused on heart diseases.";

		Specialty specialty = new Specialty(NAME, DESCRIPTION);
		Specialty savedSpecialty = specialtyService.create(specialty);

		log.info("Especialidad creada: {}", savedSpecialty);

		assertNotNull(savedSpecialty.getId());
		assertEquals(NAME, savedSpecialty.getName());
		assertEquals(DESCRIPTION, savedSpecialty.getDescription());
	}

	/**
	 * Test: actualizar una especialidad existente
	 */
	@Test
	public void testUpdateSpecialty() throws SpecialtyNotFoundException {
		Integer ID = 2;
		String NEW_NAME = "Plastic Surgery";
		String NEW_DESCRIPTION = "Specialty for cosmetic and reconstructive surgery.";

		Specialty specialty = specialtyService.findById(ID);
		specialty.setName(NEW_NAME);
		specialty.setDescription(NEW_DESCRIPTION);

		Specialty updatedSpecialty = specialtyService.update(specialty);

		log.info("Especialidad actualizada: {}", updatedSpecialty);

		assertEquals(NEW_NAME, updatedSpecialty.getName());
		assertEquals(NEW_DESCRIPTION, updatedSpecialty.getDescription());
	}

	/**
	 * Test: eliminar una especialidad
	 */
	@Test
	public void testDeleteSpecialty() throws SpecialtyNotFoundException {
		// Primero creamos una especialidad temporal para eliminarla
		Specialty specialty = new Specialty("Neurology", "Specialty for brain and nervous system.");
		Specialty saved = specialtyService.create(specialty);

		Integer ID = saved.getId();
		log.info("Especialidad temporal creada con ID: {}", ID);

		// Eliminamos la especialidad
		specialtyService.delete(ID);

		// Verificamos que ya no exista
		assertThrows(SpecialtyNotFoundException.class, () -> {
			specialtyService.findById(ID);
		});

		log.info("Especialidad eliminada correctamente con ID: {}", ID);
	}

	@Test
	public void testFindSpecialtyByName() {
		String NAME = "Radiology";
		List<Specialty> results = specialtyService.findByName(NAME);
		assertFalse(results.isEmpty());
		assertEquals(NAME, results.get(0).getName());
	}

	@Test
	public void testFindSpecialtyByDescriptionContaining() {
		String KEYWORD = "diagnostic";
		List<Specialty> results = specialtyService.findByDescriptionContaining(KEYWORD);
		assertFalse(results.isEmpty());
		assertTrue(results.get(0).getDescription().contains(KEYWORD));
	}

	@Test
	public void testFindAllSpecialties() {
		List<Specialty> all = specialtyService.findAll();
		assertNotNull(all);
		assertTrue(all.size() >= 3);
	}
}