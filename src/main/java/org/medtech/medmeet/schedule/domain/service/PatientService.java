package org.medtech.medmeet.schedule.domain.service;

import org.medtech.medmeet.schedule.domain.model.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> fetchAll();
    Patient fetchById(Integer id);
    Patient save(Patient patient);
    Patient update(Patient patient);
    boolean deleteById(Integer id);
}
