package org.medtech.medmeet.schedule.mapping;

import org.medtech.medmeet.schedule.domain.model.entity.Appointment;
import org.medtech.medmeet.schedule.resource.AppointmentResource;
import org.medtech.medmeet.schedule.resource.CreateAppointmentResource;
import org.medtech.medmeet.schedule.resource.UpdateAppointmentResource;
import org.medtech.medmeet.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class AppointmentMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Appointment toModel(CreateAppointmentResource resource) {
        return this.mapper.map(resource, Appointment.class);
    }
    public Appointment toModel(UpdateAppointmentResource resource) {
        return this.mapper.map(resource, Appointment.class);
    }
    public AppointmentResource toResource(Appointment appointment) {
        return this.mapper.map(appointment, AppointmentResource.class);
    }
}
