package org.medtech.medmeet.support.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.medtech.medmeet.support.domain.model.entity.Question;
import org.medtech.medmeet.support.repository.QuestionRepositoryImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {

    @InjectMocks
    private QuestionServiceImpl questionService;

    @Mock
    private QuestionRepositoryImpl questionRepository;

    @Test
    public void testBuscarPorId(){
        Question espero = new Question(100,"Juan","Que es paracetamol");
        Mockito.when(questionRepository.findById(Mockito.anyInt()))
                .thenReturn(new Question(20,"Juan","Que es paracetamol"));

        Question recibo = questionService.buscarporId(20);

        Assertions.assertEquals(espero.getId(),recibo.getId());
        Assertions.assertEquals(espero.getFirstName(),recibo.getFirstName());
        Assertions.assertEquals(espero.getQuestion_text(),recibo.getQuestion_text());

       Mockito.verify(questionRepository,Mockito.times(1)).findById(Mockito.anyInt());
    }

    @Test
    public void testBuscarPorIdMenor20(){
        Question espero = new Question(6,"Mario","hola?");
        Mockito.when(questionRepository.findById(Mockito.anyInt()))
                .thenReturn(new Question(3,"Mario","hola?"));

        Question recibo = questionService.buscarporId(3);

        Assertions.assertEquals(espero.getId(),recibo.getId());
        Assertions.assertEquals(espero.getFirstName(),recibo.getFirstName());
        Assertions.assertEquals(espero.getQuestion_text(),recibo.getQuestion_text());

        Mockito.verify(questionRepository,Mockito.times(1)
        ).findById(Mockito.anyInt());
    }

}
