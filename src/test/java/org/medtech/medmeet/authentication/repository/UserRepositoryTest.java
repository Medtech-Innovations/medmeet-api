package org.medtech.medmeet.authentication.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.medtech.medmeet.authentication.domain.model.entity.User;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {
    @InjectMocks
    private UserRepositoryImpl userRepository;

    @Test
    @DisplayName("Test for find by id from user")
    public void testFindById(){
        User espero = new User(12,"cual es tu nombre?","cual es tu apellido?","cual es tu username?","cual es tu password?");

        User recibo =  userRepository.findById(12);
        Assertions.assertEquals(espero.getId(),recibo.getId());
        Assertions.assertEquals(espero.getFirstName(),recibo.getFirstName());
        Assertions.assertEquals(espero.getLastName(),recibo.getLastName());
        Assertions.assertEquals(espero.getUsername(),recibo.getUsername());
        Assertions.assertEquals(espero.getPassword(),recibo.getPassword());
    }

    @Test
    @DisplayName("Test for find by id from user is Less Zero")
    public void testFindByIdIsLessZero(){
        Integer id=-2;
        IllegalArgumentException illegalArgumentException
                = Assertions.assertThrows(IllegalArgumentException.class,
                () -> userRepository.findById(id));
        Assertions.assertEquals("No hay Id", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Test for find by id from user is null")
    public void testFindByIdisNull(){
        NullPointerException nullPointerException
                = Assertions.assertThrows(NullPointerException.class,
                () -> userRepository.findById(null));
        Assertions.assertEquals("Is Null",nullPointerException.getMessage());
    }

}
