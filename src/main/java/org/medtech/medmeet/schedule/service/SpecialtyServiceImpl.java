package org.medtech.medmeet.schedule.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.medtech.medmeet.schedule.domain.model.entity.Specialty;
import org.medtech.medmeet.schedule.domain.persistence.SpecialtyRepository;
import org.medtech.medmeet.schedule.domain.service.SpecialtyService;
import org.medtech.medmeet.shared.exception.ResourceNotFoundException;
import org.medtech.medmeet.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
    private static final String ENTITY = "Specialty";

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private Validator validator;

    public SpecialtyServiceImpl(SpecialtyRepository _specialtyRepository, Validator _validator) {
        this.specialtyRepository = _specialtyRepository;
        this.validator = _validator;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Specialty> fetchAll() {
        return specialtyRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Specialty> fetchById(Integer id) {
        if (specialtyRepository.existsById(id)) {
            return specialtyRepository.findById(id);
        } else {
            throw new ResourceNotFoundException(ENTITY, id);
        }
    }

    @Override
    public Specialty save(Specialty specialty) {
        Set<ConstraintViolation<Specialty>> violations = validator.validate(specialty);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        if (specialtyRepository.findByName(specialty.getName()).isPresent()) {
            throw new ResourceValidationException(ENTITY, "name already exists in database");
        }

        return specialtyRepository.save(specialty);
    }

    @Override
    public Specialty update(Specialty specialty) {
        Set<ConstraintViolation<Specialty>> violations = validator.validate(specialty);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return specialtyRepository
                .findById(specialty.getId())
                .map(specialtyToUpdate -> {
                    specialtyToUpdate.setName(specialty.getName());
                    specialtyToUpdate.setDescription(specialty.getDescription());

                    return specialtyRepository.save(specialtyToUpdate);
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, specialty.getId()));
    }

    @Override
    public boolean deleteById(Integer id) {
        var specialtyToDelete = specialtyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));

        specialtyRepository.delete(specialtyToDelete);
        return true;
    }
}
