package org.medtech.medmeet.support.repository;

import org.medtech.medmeet.support.domain.model.entity.Question;
import org.medtech.medmeet.support.util.QuestionValidator;

public class QuestionRepositoryImpl implements QuestionRepository{

    @Override
    public Question findById(Integer id){
        QuestionValidator.validateQuestionId(id);
        return new Question(id,"firstName","question_text");
    }
}
