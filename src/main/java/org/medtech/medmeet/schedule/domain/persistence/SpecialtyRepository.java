package org.medtech.medmeet.schedule.domain.persistence;

import org.medtech.medmeet.schedule.domain.model.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {
}
