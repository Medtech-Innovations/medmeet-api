package org.medtech.medmeet.schedule.domain.service;

import org.medtech.medmeet.schedule.domain.model.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment>fetchAll();
    Appointment fetchById(Integer id);
    Appointment save(Appointment appointment);
    Appointment update(Appointment appointment);
    boolean deleteById(Integer id);
}
