package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.exceptions.SpecialtyNotFoundException;
import com.tecsup.petclinic.repositories.SpecialtyRepository;

@Service
@Slf4j
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialityRepository;

    public SpecialtyServiceImpl(SpecialtyRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Specialty create(Specialty speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public Specialty update(Specialty speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void delete(Integer id) throws SpecialtyNotFoundException {
        Specialty speciality = findById(id);
        specialityRepository.delete(speciality);
    }

    @Override
    public Specialty findById(Integer id) throws SpecialtyNotFoundException {
        Optional<Specialty> speciality = specialityRepository.findById(id);

        if (!speciality.isPresent())
            throw new SpecialtyNotFoundException("Especialidad con ID " + id + " no encontrada.");

        return speciality.get();
    }

    @Override
    public List<Specialty> findByName(String name) {
        List<Specialty> list = specialityRepository.findByName(name);
        list.forEach(s -> log.info("" + s));
        return list;
    }

    @Override
    public List<Specialty> findByDescriptionContaining(String keyword) {
        List<Specialty> list = specialityRepository.findByDescriptionContaining(keyword);
        list.forEach(s -> log.info("" + s));
        return list;
    }

    @Override
    public List<Specialty> findAll() {
        return specialityRepository.findAll();
    }
}