package org.medtech.medmeet.schedule.service;

import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.medtech.medmeet.schedule.domain.model.entity.Appointment;
import org.medtech.medmeet.schedule.domain.model.entity.Doctor;
import org.medtech.medmeet.schedule.domain.model.entity.Patient;
import org.medtech.medmeet.schedule.domain.model.entity.Specialty;
import org.medtech.medmeet.schedule.domain.persistence.AppointmentRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        Assertions.assertEquals(expected.get(0).getCreatedDate(), actual.get(0).getCreatedDate());
        Assertions.assertEquals(expected.get(0).getAppointmentDate(), actual.get(0).getAppointmentDate());
        Assertions.assertEquals(expected.get(0).getMinutesDuration(), actual.get(0).getMinutesDuration());
        Assertions.assertEquals(expected.get(0).getAppointmentSessionUrl(), actual.get(0).getAppointmentSessionUrl());
        Assertions.assertEquals(expected.get(0).getAppointmentPrescriptionUrl(), actual.get(0).getAppointmentPrescriptionUrl());
        Assertions.assertEquals(expected.get(0).getPaymentId(), actual.get(0).getPaymentId());
        Assertions.assertEquals(expected.get(0).getPatient(), actual.get(0).getPatient());
        Assertions.assertEquals(expected.get(0).getDoctor(), actual.get(0).getDoctor());
    }


    public List<Appointment> expectedListAppointments() {
        List<Appointment> expected = new ArrayList<>();
        Specialty specialty = new Specialty();
        Patient patient = new Patient();
        Doctor doctor = new Doctor();

        Appointment appointment = new Appointment();
        appointment.setId(1);
        appointment.setCreatedDate(LocalDateTime.now());
        appointment.setAppointmentDate(new Date());
        appointment.setMinutesDuration(120);
        appointment.setAppointmentSessionUrl("https://www.google.com");
        appointment.setAppointmentPrescriptionUrl("https://www.prescription.com");
        appointment.setPaymentId(1);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setStatus(true);

        expected.add(appointment);
        return expected;
    }

    public List<Appointment> actualListAppointments() {
        List<Appointment> expected = new ArrayList<>();
        Specialty specialty = new Specialty();
        Patient patient = new Patient();
        Doctor doctor = new Doctor();

        Appointment appointment = new Appointment();
        appointment.setId(1);
        appointment.setCreatedDate(LocalDateTime.now());
        appointment.setAppointmentDate(new Date());
        appointment.setMinutesDuration(120);
        appointment.setAppointmentSessionUrl("https://www.google.com");
        appointment.setAppointmentPrescriptionUrl("https://www.prescription.com");
        appointment.setPaymentId(1);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setStatus(true);

        expected.add(appointment);
        return expected;
    }


}
