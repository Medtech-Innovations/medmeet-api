package org.medtech.medmeet.schedule.domain.persistence;

import org.medtech.medmeet.schedule.domain.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
