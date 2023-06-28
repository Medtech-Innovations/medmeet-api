package org.medtech.medmeet.schedule.mapping;

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
}
