package org.medtech.medmeet.schedule.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.medtech.medmeet.schedule.domain.model.entity.Patient;
import org.medtech.medmeet.schedule.domain.persistence.PatientRepository;
import org.medtech.medmeet.schedule.domain.service.PatientService;
import org.medtech.medmeet.shared.exception.ResourceNotFoundException;
import org.medtech.medmeet.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientServiceImpl implements PatientService {
    private static final String ENTITY = "Patient";

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private Validator validator;

    public PatientServiceImpl(PatientRepository _patientRepository, Validator _validator) {
        this.patientRepository = _patientRepository;
        this.validator = _validator;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Patient> fetchAll() {
        return patientRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Patient> fetchById(Integer id) {
        if (patientRepository.existsById(id)) {
            return patientRepository.findById(id);
        } else {
            throw new ResourceNotFoundException(ENTITY, id);
        }
    }

    @Override
    public Patient save(Patient patient) {
        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Patient patient) {
        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return patientRepository
                .findById(patient.getId())
                .map(patientToUpdate -> {
                    patientToUpdate.setUserId(patient.getUserId());

                    return patientRepository.save(patientToUpdate);
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, patient.getId()));
    }

    @Override
    public boolean deleteById(Integer id) {
        var patientToDelete = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));

        patientRepository.delete(patientToDelete);
        return true;
    }
}
