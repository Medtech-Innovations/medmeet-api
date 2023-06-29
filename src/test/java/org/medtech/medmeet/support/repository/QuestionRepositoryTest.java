package org.medtech.medmeet.support.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.medtech.medmeet.support.domain.model.entity.Question;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class QuestionRepositoryTest {

    @InjectMocks
    private QuestionRepositoryImpl questionRepository;

    @Test
    @DisplayName("Test for find by id from question")
    public void testFindById(){
        Question espero = new Question(5,"firstName","question_text");

        Question recibo = questionRepository.findById(5);
        Assertions.assertEquals(espero.getId(),recibo.getId());
        Assertions.assertEquals(espero.getFirstName(),recibo.getFirstName());
        Assertions.assertEquals(espero.getQuestion_text(),recibo.getQuestion_text());
    }

    @Test
    @DisplayName("Test for find by id from question is Less Zero")
    public void testFindByIdIsLessZero(){
        Integer id=-2;
        IllegalArgumentException illegalArgumentException
                = Assertions.assertThrows(IllegalArgumentException.class,
                () -> questionRepository.findById(id));
        Assertions.assertEquals("No hay Id", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Test for find by id from question is null")
    public void testFindByIdisNull(){
        NullPointerException nullPointerException
                = Assertions.assertThrows(NullPointerException.class,
                () -> questionRepository.findById(null));
        Assertions.assertEquals("Is Null",nullPointerException.getMessage());
    }

}
