package org.medtech.medmeet.contact.mapping;

import org.medtech.medmeet.contact.domain.model.entity.Detail;
import org.medtech.medmeet.contact.resource.CreateDetailResource;
import org.medtech.medmeet.contact.resource.DetailResource;
import org.medtech.medmeet.contact.resource.UpdateDetailResource;
import org.medtech.medmeet.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class DetailMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Detail toModel(CreateDetailResource resource){
        return this.mapper.map(resource, Detail.class);
    }
    public Detail toModel(UpdateDetailResource resource){
        return this.mapper.map(resource, Detail.class);
    }
    public DetailResource toResource(Detail detail){
        return this.mapper.map(detail, DetailResource.class);
    }
}
