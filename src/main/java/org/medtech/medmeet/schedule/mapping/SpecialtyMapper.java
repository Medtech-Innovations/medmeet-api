package org.medtech.medmeet.schedule.mapping;

import org.medtech.medmeet.schedule.domain.model.entity.Specialty;
import org.medtech.medmeet.schedule.resource.*;
import org.medtech.medmeet.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;


public class SpecialtyMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Specialty toModel(CreateSpecialtyResource resource) {
        return this.mapper.map(resource, Specialty.class);
    }
    public Specialty toModel(UpdateSpecialtyResource resource) {
        return this.mapper.map(resource, Specialty.class);
    }
    public SpecialtyResource toResource(Specialty specialty) {
        return this.mapper.map(specialty, SpecialtyResource.class);
    }
}
