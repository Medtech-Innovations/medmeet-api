package org.medtech.medmeet.schedule.mapping;

import org.medtech.medmeet.schedule.domain.model.entity.Appointment;
import org.medtech.medmeet.schedule.domain.model.entity.Patient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("scheduleMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public AppointmentMapper appointmentMapper() {
        return new AppointmentMapper();
    }

    @Bean
    public SpecialtyMapper specialtyMapper() {
        return new SpecialtyMapper();
    }

    @Bean
    public DoctorMapper doctorMapper() {
        return new DoctorMapper();
    }

    @Bean
    public PatientMapper patientMapper() {
        return new PatientMapper();
    }
}
