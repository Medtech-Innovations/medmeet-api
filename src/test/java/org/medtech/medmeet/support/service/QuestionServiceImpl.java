package org.medtech.medmeet.support.service;

import lombok.AllArgsConstructor;
import org.medtech.medmeet.support.domain.model.entity.Question;
import org.medtech.medmeet.support.repository.QuestionRepository;

@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Question buscarporId(Integer id){
        Question question = questionRepository.findById(id);
        if (question.getId()<20){
            question.setId(question.getId()*2);
        }else {
            question.setId(question.getId()*5);
        }
        return question;
    }
}
