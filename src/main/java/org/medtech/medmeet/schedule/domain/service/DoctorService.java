package org.medtech.medmeet.schedule.domain.service;

import org.medtech.medmeet.schedule.domain.model.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> fetchAll();
    Optional<Doctor> fetchById(Integer id);
    Doctor save(Doctor doctor, Integer assignedSpecialtyId);
    Doctor updateSpecialty(Doctor doctor, Integer specialtyId);
    boolean deleteById(Integer id);
}
