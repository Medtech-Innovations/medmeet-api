package org.medtech.medmeet.billing.service;


import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.medtech.medmeet.billing.domain.model.entity.Payment;
import org.medtech.medmeet.billing.domain.persistence.PaymentRepository;
import org.medtech.medmeet.schedule.domain.model.entity.Appointment;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {
    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    public Payment createPayment(Integer id) {
        Payment payment = new Payment();
        Appointment appointment = new Appointment();

        payment.setId(id);
        payment.setAmount(BigDecimal.valueOf(800.00));
        payment.setCreatedDate(LocalDateTime.now());
        payment.setDescription("This is a description");
        payment.setAppointment(appointment);

        return payment;
    }

    public List<Payment> expectedListPayments() {
        List<Payment> expected = new ArrayList<>();

        Appointment appointment = new Appointment();
        Payment payment = new Payment();

        payment.setId(1);
        payment.setAmount(BigDecimal.valueOf(800.00));
        payment.setCreatedDate(LocalDateTime.now());
        payment.setDescription("This is a description");
        payment.setAppointment(appointment);

        expected.add(payment);
        return expected;
    }

    public List<Payment> actualListPayments() {
        List<Payment> actual = new ArrayList<>();

        Appointment appointment = new Appointment();
        Payment payment = new Payment();

        payment.setId(1);
        payment.setAmount(BigDecimal.valueOf(800.00));
        payment.setCreatedDate(LocalDateTime.now());
        payment.setDescription("This is a description");
        payment.setAppointment(appointment);

        actual.add(payment);
        return actual;
    }

    public Optional<Payment> expectedOptionalPayment(Integer id) {
       return Optional.of(createPayment(id));
    }

    public Optional<Payment> actualOptionalPayment(Integer id) {
        return Optional.of(createPayment(id));
    }

    @Test
    public void testFetchAll() {
        List<Payment> expected = this.expectedListPayments();
        Mockito.when(paymentRepository.findAll())
                .thenReturn(this.actualListPayments());
        List<Payment> actual = paymentService.fetchAll();

        Assertions.assertEquals(expected.get(0).getId(), actual.get(0).getId());
        Assertions.assertEquals(expected.get(0).getAmount(), actual.get(0).getAmount());
        Assertions.assertEquals(expected.get(0).getDescription(), actual.get(0).getDescription());
    }

    @Test
    public void testFetchById() {
        Integer actualId = 1;
        Integer expectedId = 1;

        Optional<Payment> expected =
                this.expectedOptionalPayment(expectedId);

        Mockito.when(paymentRepository.existsById(Mockito.anyInt()))
                .thenReturn(true);
        Mockito.when(paymentRepository.findById(Mockito.anyInt()))
                .thenReturn(actualOptionalPayment(actualId));

        Optional<Payment> actual = paymentService.fetchById(actualId);

        Assertions.assertEquals(expected.get().getId(), actual.get().getId());
        Assertions.assertEquals(expected.get().getAmount(), actual.get().getAmount());
        Assertions.assertEquals(expected.get().getDescription(), actual.get().getDescription());
    }
}
