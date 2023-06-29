package org.medtech.medmeet.support.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.medtech.medmeet.shared.exception.ResourceNotFoundException;
import org.medtech.medmeet.shared.exception.ResourceValidationException;
import org.medtech.medmeet.support.domain.model.entity.Question;
import org.medtech.medmeet.support.domain.persistence.QuestionRepository;
import org.medtech.medmeet.support.domain.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class QuestionImpl implements QuestionService {

    private static final String ENTITY = "Question";

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private Validator validator;

    @Transactional(readOnly = true)
    @Override
    public List<Question> fetchAll() {
        return questionRepository.findAll();
    }


    @Transactional(readOnly = true)
    @Override
    public Optional<Question> fetchById(Integer id) {
        if(questionRepository.existsById(id)){
            return questionRepository.findById(id);
        }else{
            throw new ResourceNotFoundException(ENTITY,id);
        }
    }

    @Transactional
    @Override
    public Question save(Question question){
        Set<ConstraintViolation<Question>>violations=validator.validate(question);
        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY,violations);
        }
        return questionRepository.save(question);
    }

    @Override
    public Question update(Question question) {
        return questionRepository.save(question);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if(questionRepository.existsById(id)){
            questionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
