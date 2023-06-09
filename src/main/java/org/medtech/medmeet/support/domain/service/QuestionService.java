package org.medtech.medmeet.support.domain.service;

import org.medtech.medmeet.support.domain.model.entity.Question;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> fetchAll();
    @Transactional(readOnly = true)
    Optional<Question> fetchById(Integer id);
    Question save(Question question);
    Question update(Question question);
    boolean deleteById(Integer id);

}
