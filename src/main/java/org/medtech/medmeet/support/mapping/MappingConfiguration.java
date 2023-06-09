package org.medtech.medmeet.support.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public QuestionMapper questionMapper(){ return new QuestionMapper();}
}
