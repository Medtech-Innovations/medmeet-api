package org.medtech.medmeet.support.mapping;

import org.medtech.medmeet.shared.mapping.EnhancedModelMapper;
import org.medtech.medmeet.support.domain.model.entity.Question;
import org.medtech.medmeet.support.resource.CreateQuestionResource;
import org.medtech.medmeet.support.resource.QuestionResource;
import org.medtech.medmeet.support.resource.UpdateQuestionResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class QuestionMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;
    public Question toModel(CreateQuestionResource question){
        return this.mapper.map(question,Question.class);
    }

    public Question toModel(UpdateQuestionResource question){
        return this.mapper.map(question, Question.class);
    }

    public QuestionResource toResource(Question question){
        return this.mapper.map(question,QuestionResource.class);
    }
}
