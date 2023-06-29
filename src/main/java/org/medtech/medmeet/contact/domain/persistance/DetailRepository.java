package org.medtech.medmeet.contact.domain.persistance;

import org.medtech.medmeet.contact.domain.model.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {
}
