package org.medtech.medmeet.contact.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.medtech.medmeet.contact.domain.model.entity.Notification;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NotificationRepositoryTest {
    @InjectMocks
    private NotificationRepositoryImpl notificationRepository;

    @Test
    @DisplayName("Test for find by id from notification")
    public void testFindById(){
        Notification expected = new Notification(10,"cual es la notificacion?");

        Notification recibo = notificationRepository.findById(10);
        Assertions.assertEquals(expected.getId(),recibo.getId());
        Assertions.assertEquals(expected.getDescription(),recibo.getDescription());
    }

    @Test
    @DisplayName("Test for find by id from notifications is Less Zero")
    public void testFindByIdLessZero(){
        Integer id=2;
        IllegalArgumentException illegalArgumentException
                = Assertions.assertThrows(IllegalArgumentException.class,
                () -> notificationRepository.findById(id));
        Assertions.assertEquals("No hay Id", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Test for find by id from user is null")
    public void testFindByIdisNull(){
        NullPointerException nullPointerException
                = Assertions.assertThrows(NullPointerException.class,
                () -> notificationRepository.findById(null));
        Assertions.assertEquals("Is Null",nullPointerException.getMessage());
    }
}
