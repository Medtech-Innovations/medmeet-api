package org.medtech.medmeet.schedule.domain.service;

import org.medtech.medmeet.schedule.domain.model.entity.Specialty;

import java.util.List;
import java.util.Optional;

public interface SpecialtyService {
    List<Specialty> fetchAll();
    Optional<Specialty> fetchById(Integer id);
    Specialty save(Specialty specialty);
    Specialty update(Specialty specialty);
    boolean deleteById(Integer id);
}
