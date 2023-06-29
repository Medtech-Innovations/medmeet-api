package org.medtech.medmeet.schedule.domain.service;

import org.medtech.medmeet.schedule.domain.model.entity.Appointment;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<Appointment>fetchAll();
    Optional<Appointment> fetchById(Integer id);
    Appointment save(Appointment appointment, Integer givenDoctorId);
    Appointment update(Appointment appointment);
    boolean deleteById(Integer id);
}
