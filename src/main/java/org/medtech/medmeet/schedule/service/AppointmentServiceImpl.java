package org.medtech.medmeet.schedule.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.medtech.medmeet.schedule.domain.model.entity.Appointment;
import org.medtech.medmeet.schedule.domain.persistence.AppointmentRepository;
import org.medtech.medmeet.schedule.domain.service.AppointmentService;
import org.medtech.medmeet.shared.exception.ResourceNotFoundException;
import org.medtech.medmeet.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private static final String ENTITY = "Appointment";

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private Validator validator;

    public AppointmentServiceImpl(AppointmentRepository _appointmentRepository, Validator _validator) {
        this.appointmentRepository = _appointmentRepository;
        this.validator = _validator;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Appointment> fetchAll() {
           return appointmentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Appointment> fetchById(Integer id) {
        if (appointmentRepository.existsById(id)) {
            return appointmentRepository.findById(id);
        } else {
            throw new ResourceNotFoundException(ENTITY, id);
        }
    }

    @Override
    public Appointment save(Appointment appointment, Integer givenDoctorId) {
        Set<ConstraintViolation<Appointment>> violations = validator.validate(appointment);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        if (givenDoctorId == null) {
            throw new ResourceValidationException("Doctor ID", "Assigned Doctor ID cannot be null. Provide a givenDoctorId parameter.");
        }

        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Appointment appointment) {
        Set<ConstraintViolation<Appointment>> violations = validator.validate(appointment);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return appointmentRepository
                .findById(appointment.getId())
                .map(appointmentToUpdate -> {
                    appointmentToUpdate.setAppointmentDate(appointment.getAppointmentDate());
                    appointmentToUpdate.setMinutesDuration(appointment.getMinutesDuration());
                    appointmentToUpdate.setAppointmentSessionUrl(appointment.getAppointmentSessionUrl());
                    appointmentToUpdate.setAppointmentPrescriptionUrl(appointment.getAppointmentPrescriptionUrl());
                    appointmentToUpdate.setUserId(appointment.getUserId());
                    appointmentToUpdate.setStatus(appointment.getStatus());

                    return appointmentRepository.save(appointmentToUpdate);
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, appointment.getId()));
    }

    @Override
    public boolean deleteById(Integer id) {
        var appointmentToDelete = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));

        appointmentRepository.delete(appointmentToDelete);
        return true;
    }
}
