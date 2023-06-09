package org.medtech.medmeet.schedule.domain.service;

import org.medtech.medmeet.schedule.domain.model.entity.Specialty;

import java.util.List;

public interface SpecialtyService {
    List<Specialty> fetchAll();
    Specialty fetchById(Integer id);
    Specialty save(Specialty specialty);
    Specialty update(Specialty specialty);
    boolean deleteById(Integer id);
}
