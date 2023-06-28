package org.medtech.medmeet.schedule.mapping;

import org.medtech.medmeet.schedule.domain.model.entity.Doctor;
import org.medtech.medmeet.schedule.resource.doctor.CreateDoctorResource;
import org.medtech.medmeet.schedule.resource.doctor.DoctorResource;
import org.medtech.medmeet.schedule.resource.doctor.UpdateDoctorResource;
import org.medtech.medmeet.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class DoctorMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Doctor toModel(CreateDoctorResource resource) { return this.mapper.map(resource, Doctor.class); }
    public Doctor toModel(UpdateDoctorResource resource) {
        return this.mapper.map(resource, Doctor.class);
    }
    public DoctorResource toResource(Doctor doctor) {
        return this.mapper.map(doctor, DoctorResource.class);
    }
}
