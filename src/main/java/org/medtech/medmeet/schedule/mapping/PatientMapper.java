package org.medtech.medmeet.schedule.mapping;


import org.medtech.medmeet.schedule.domain.model.entity.Patient;
import org.medtech.medmeet.schedule.resource.patient.CreatePatientResource;
import org.medtech.medmeet.schedule.resource.patient.PatientResource;
import org.medtech.medmeet.schedule.resource.patient.UpdatePatientResource;
import org.medtech.medmeet.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class PatientMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Patient toModel(CreatePatientResource resource) {
        return this.mapper.map(resource, Patient.class);
    }
    public Patient toModel(UpdatePatientResource resource) {
        return this.mapper.map(resource, Patient.class);
    }
    public PatientResource toResource(Patient patient) {
        return this.mapper.map(patient, PatientResource.class);
    }
}
