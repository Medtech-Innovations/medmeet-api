package org.medtech.medmeet.support.domain.persistence;

import org.medtech.medmeet.support.domain.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
