package org.medtech.medmeet.schedule.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.medtech.medmeet.schedule.domain.model.entity.Doctor;
import org.medtech.medmeet.schedule.domain.model.entity.Specialty;
import org.medtech.medmeet.schedule.domain.persistence.DoctorRepository;
import org.medtech.medmeet.schedule.domain.service.DoctorService;
import org.medtech.medmeet.shared.exception.ResourceNotFoundException;
import org.medtech.medmeet.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DoctorServiceImpl implements DoctorService {
    private static final String ENTITY = "Doctor";

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private Validator validator;

    public DoctorServiceImpl(DoctorRepository _doctorRepository, Validator _validator) {
        this.doctorRepository = _doctorRepository;
        this.validator = _validator;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Doctor> fetchAll() {
        return doctorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Doctor> fetchById(Integer id) {
        if (doctorRepository.existsById(id)) {
            return doctorRepository.findById(id);
        } else {
            throw new ResourceNotFoundException(ENTITY, id);
        }
    }

    @Override
    public Doctor save(Doctor doctor) {
        Set<ConstraintViolation<Doctor>> violations = validator.validate(doctor);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Doctor doctor) {
        Set<ConstraintViolation<Doctor>> violations = validator.validate(doctor);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return doctorRepository
                .findById(doctor.getId())
                .map(doctorToUpdate -> {
                    doctorToUpdate.setUserId(doctor.getUserId());
                    doctorToUpdate.setSpecialty(doctor.getSpecialty());

                    return doctorRepository.save(doctorToUpdate);
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, doctor.getId()));
    }

    @Override
    public boolean deleteById(Integer id) {
        var doctorToDelete = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));

        doctorRepository.delete(doctorToDelete);
        return true;
    }
}