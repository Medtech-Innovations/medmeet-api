package org.medtech.medmeet.authentication.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.medtech.medmeet.authentication.domain.model.entity.User;
import org.medtech.medmeet.authentication.repository.UserRepositoryImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest{
    @InjectMocks
    private UserServiceImp userService;

    @Mock
    private UserRepositoryImpl userRepository;

    @Test
    public void testBuscarPorId(){
        User espero = new User(123,"Jose","Rodriguez","JoseRodriguez","hola123");
        Mockito.when(userRepository.findById(Mockito.anyInt()))
                .thenReturn(new User(20,"Pedro","Martinez","Pedrito","hola1234"));

        User recibo = userService.buscarporId(20);


        Assertions.assertEquals(espero.getId(),recibo.getId());
        Assertions.assertEquals(espero.getFirstName(),recibo.getFirstName());
        Assertions.assertEquals(espero.getLastName(),recibo.getLastName());
        Assertions.assertEquals(espero.getUsername(),recibo.getUsername());
        Assertions.assertEquals(espero.getPassword(),recibo.getPassword());

        Mockito.verify(userRepository,Mockito.times(1)).findById(Mockito.anyInt());
    }

    @Test
    public void testBuscarPorIdMenor20(){
        User espero = new User(6,"FirstName","LastName","Username","Password");
        Mockito.when(userRepository.findById(Mockito.anyInt()))
                .thenReturn(new User(3,"FirstName","LastName","Username","Password"));

        User recibo = userService.buscarporId(3);

        Assertions.assertEquals(espero.getId(),recibo.getId());
        Assertions.assertEquals(espero.getFirstName(),recibo.getFirstName());
        Assertions.assertEquals(espero.getLastName(),recibo.getLastName());
        Assertions.assertEquals(espero.getUsername(),recibo.getUsername());
        Assertions.assertEquals(espero.getPassword(),recibo.getPassword());

        Mockito.verify(userRepository,Mockito.times(1)
        ).findById(Mockito.anyInt());
    }

}
