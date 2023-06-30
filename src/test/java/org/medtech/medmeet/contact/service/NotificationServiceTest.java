package org.medtech.medmeet.contact.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.medtech.medmeet.contact.domain.model.entity.Notification;
import org.medtech.medmeet.contact.repository.NotificationRepositoryImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {
    @InjectMocks
    private NotificationServiceImpl questionService;

    @Mock
    private NotificationRepositoryImpl questionRepository;

    @Test
    public void testBuscarPorId(){
        Notification espero = new Notification(12,"hola123");
        Mockito.when(questionRepository.findById(Mockito.anyInt()))
                .thenReturn(new Notification(20,"hola1234"));

        Notification recibo = questionService.buscarporId(20);

        Assertions.assertEquals(espero.getId(),recibo.getId());
        Assertions.assertEquals(espero.getDescription(),recibo.getDescription());

        Mockito.verify(questionRepository,Mockito.times(1)).findById(Mockito.anyInt());
    }

    @Test
    public void testBuscarPorIdMenor20(){
        Notification espero = new Notification(6, "Descriotion");
        Mockito.when(questionRepository.findById(Mockito.anyInt()))
                .thenReturn(new Notification(3,"Description"));

        Notification recibo = questionService.buscarporId(3);

        Assertions.assertEquals(espero.getId(),recibo.getId());
        Assertions.assertEquals(espero.getDescription(),recibo.getDescription());

        Mockito.verify(questionRepository, Mockito.times(1))
                .findById(Mockito.anyInt());
    }
}
