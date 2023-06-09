package org.medtech.medmeet.schedule.domain.persistence;

import org.medtech.medmeet.schedule.domain.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
