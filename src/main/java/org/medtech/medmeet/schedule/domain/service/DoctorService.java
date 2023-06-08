package org.medtech.medmeet.schedule.domain.service;

import org.medtech.medmeet.schedule.domain.model.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> fetchAll();
    Doctor fetchById(Integer id);
    Doctor save(Doctor doctor);
    Doctor update(Doctor doctor);
    boolean deleteById(Integer id);
}
