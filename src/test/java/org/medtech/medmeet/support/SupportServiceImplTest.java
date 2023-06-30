package org.medtech.medmeet.support;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.medtech.medmeet.support.domain.model.entity.Question;
import org.medtech.medmeet.support.domain.persistence.QuestionRepository;
import org.medtech.medmeet.support.service.QuestionServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class SupportServiceImplTest {

    @InjectMocks
    private QuestionServiceImpl questionService;

    @Mock
    private QuestionRepository questionRepository;

    @Test
    public void test_fetchAll() {
        List<Question> expected = this.expectedListQuestions();
        Mockito.when(questionRepository.findAll())
                .thenReturn(this.actualListQuestions());
        List<Question> actual = questionService.fetchAll();

        Assertions.assertEquals(expected.get(0).getId(), actual.get(0).getId());
        Assertions.assertEquals(expected.get(0).getFirstName(), actual.get(0).getFirstName());
        Assertions.assertEquals(expected.get(0).getQuestion_text(),actual.get(0).getQuestion_text());
    }

    @Test
    public void testCountIds() {
        // Ejemplos
        List<Question> questionList = Arrays.asList(
                new Question(1, "Juan", "¿Qué es paracetamol?"),
                new Question(2, "Pedro", "¿Cuáles son los síntomas característicos de la enfermedad 'Gripe'?"),
                new Question(3, "María", "¿Cuál es la dosis recomendada del medicamento 'Antiinflamex' para tratar la enfermedad 'Artritis' y con qué frecuencia debo tomarlo?")
        );

        // Configuración del comportamiento simulado del repository
        Mockito.when(questionRepository.findAll()).thenReturn(questionList);

        // Llamada al método a probar
        List<Question> retrievedQuestions = questionService.countIds();

        // Verificación de la cantidad de IDs existentes
        int idCount = retrievedQuestions.size();
        Assertions.assertEquals(3, idCount);
    }

    @Test
    public void testFetchById(){
        Integer idExpected = 1;
        Integer idActual = 1;
        Optional<Question> expected = this.expectedOptionalQuestions(idExpected);

        Mockito.when(questionRepository.existsById(Mockito.anyInt())).thenReturn(true);
        Mockito.when(questionRepository.findById(Mockito.anyInt())).thenReturn(actualOptionalQuestions(idActual));

        Optional<Question> actual= questionService.fetchById(idActual);

        Assertions.assertEquals(expected.get().getId(), actual.get().getId());
        Assertions.assertEquals(expected.get().getFirstName(), actual.get().getFirstName());
        Assertions.assertEquals(expected.get().getQuestion_text(),actual.get().getQuestion_text());
    }

    public List<Question> expectedListQuestions(){
        List<Question> expected = new ArrayList<>();
        Question question = new Question();

        question.setId(1);
        question.setFirstName(question.getFirstName());
        question.setQuestion_text(question.getQuestion_text());
        question.setCategory(question.getCategory());

        expected.add(question);
        return expected;
    }

    public List<Question> actualListQuestions(){
        List<Question> expected = new ArrayList<>();
        Question question = new Question();

        question.setId(1);
        question.setFirstName(question.getFirstName());
        question.setQuestion_text(question.getQuestion_text());
        question.setCategory(question.getCategory());

        expected.add(question);
        return expected;
    }

    public Optional<Question> expectedOptionalQuestions(Integer id) {

        return Optional.of(createQuestions(id));
    }
    public Optional<Question> actualOptionalQuestions(Integer id) {

        return Optional.of(createQuestions(id));
    }

    public Question createQuestions(Integer id) {
        Question question = new Question();

        question.setId(id);
        question.setFirstName(question.getFirstName());
        question.setQuestion_text(question.getQuestion_text());
        question.setCategory(question.getCategory());
        return question;
    }

}
