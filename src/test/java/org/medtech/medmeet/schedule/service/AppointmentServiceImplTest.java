package org.medtech.medmeet.schedule.service;

import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.medtech.medmeet.schedule.domain.model.entity.Appointment;
import org.medtech.medmeet.schedule.domain.model.entity.Doctor;
import org.medtech.medmeet.schedule.domain.persistence.AppointmentRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceImplTest {
    @InjectMocks
    private AppointmentServiceImpl appointmentService;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private Validator validator;

    @Test
    public void testFetchAll() {
        List<Appointment> expected = this.expectedListAppointments();
        Mockito.when(appointmentRepository.findAll())
                .thenReturn(this.actualListAppointments());
        List<Appointment> actual = appointmentService.fetchAll();

        Assertions.assertEquals(expected.get(0).getId(), actual.get(0).getId());
        Assertions.assertEquals(expected.get(0).getMinutesDuration(), actual.get(0).getMinutesDuration());
        Assertions.assertEquals(expected.get(0).getAppointmentSessionUrl(), actual.get(0).getAppointmentSessionUrl());
        Assertions.assertEquals(expected.get(0).getAppointmentPrescriptionUrl(), actual.get(0).getAppointmentPrescriptionUrl());
        Assertions.assertEquals(expected.get(0).getUserId(), actual.get(0).getUserId());
        Assertions.assertEquals(expected.get(0).getPaymentId(), actual.get(0).getPaymentId());
    }

    @Test
    public void testFetchById(){
        Integer idExpected = 1;
        Integer idActual = 1;
        Optional<Appointment> expected = this.expectedOptionalAppointment(idExpected);

        Mockito.when(appointmentRepository.existsById(Mockito.anyInt()))
                .thenReturn(true);
        Mockito.when(appointmentRepository.findById(Mockito.anyInt()))
                .thenReturn(actualOptionalAppointment(idActual));

        Optional<Appointment> actual = appointmentService.fetchById(idActual);

        Assertions.assertEquals(expected.get().getId(), actual.get().getId());
        Assertions.assertEquals(expected.get().getMinutesDuration(), actual.get().getMinutesDuration());
        Assertions.assertEquals(expected.get().getAppointmentSessionUrl(), actual.get().getAppointmentSessionUrl());
        Assertions.assertEquals(expected.get().getAppointmentPrescriptionUrl(), actual.get().getAppointmentPrescriptionUrl());
        Assertions.assertEquals(expected.get().getUserId(), actual.get().getUserId());
        Assertions.assertEquals(expected.get().getPaymentId(), actual.get().getPaymentId());
    }

    public List<Appointment> expectedListAppointments() {
        List<Appointment> expected = new ArrayList<>();
        Doctor doctor = new Doctor();

        Appointment appointment = new Appointment();

        appointment.setId(1);
        appointment.setCreatedDate(LocalDateTime.now());
        appointment.setAppointmentDate(new Date());
        appointment.setMinutesDuration(120);
        appointment.setAppointmentSessionUrl("https://www.google.com");
        appointment.setAppointmentPrescriptionUrl("https://www.prescription.com");
        appointment.setPaymentId(1);
        appointment.setUserId(1);
        appointment.setDoctor(doctor);
        appointment.setStatus(true);

        expected.add(appointment);
        return expected;
    }
    public List<Appointment> actualListAppointments() {
        List<Appointment> expected = new ArrayList<>();
        Doctor doctor = new Doctor();

        Appointment appointment = new Appointment();
        appointment.setId(1);
        appointment.setCreatedDate(LocalDateTime.now());
        appointment.setAppointmentDate(new Date());
        appointment.setMinutesDuration(120);
        appointment.setAppointmentSessionUrl("https://www.google.com");
        appointment.setAppointmentPrescriptionUrl("https://www.prescription.com");
        appointment.setPaymentId(1);
        appointment.setUserId(1);
        appointment.setDoctor(doctor);
        appointment.setStatus(true);

        expected.add(appointment);
        return expected;
    }
    public Optional<Appointment> expectedOptionalAppointment(Integer id) {
        return Optional.of(createAppointment(id));
    }
    public Optional<Appointment> actualOptionalAppointment(Integer id) {
        return Optional.of(createAppointment(id));
    }

    public Appointment createAppointment(Integer id) {
        Appointment appointment = new Appointment();
        Doctor doctor = new Doctor();

        appointment.setId(id);
        appointment.setCreatedDate(LocalDateTime.now());
        appointment.setAppointmentDate(new Date());
        appointment.setMinutesDuration(120);
        appointment.setAppointmentSessionUrl("https://www.google.com");
        appointment.setAppointmentPrescriptionUrl("https://www.prescription.com");
        appointment.setPaymentId(1);
        appointment.setUserId(1);
        appointment.setDoctor(doctor);
        appointment.setStatus(true);
        return appointment;
    }
}
