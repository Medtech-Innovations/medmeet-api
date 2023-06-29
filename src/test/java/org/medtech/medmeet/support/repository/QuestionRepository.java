package org.medtech.medmeet.support.repository;

import org.medtech.medmeet.support.domain.model.entity.Question;

public interface QuestionRepository {
    Question findById(Integer id);
}
