package org.medtech.medmeet.schedule.domain.persistence;

import org.medtech.medmeet.schedule.domain.model.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {
    Optional<Specialty> findByName(String name);
}
