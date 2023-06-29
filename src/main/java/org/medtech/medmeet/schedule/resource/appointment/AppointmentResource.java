package org.medtech.medmeet.schedule.resource.appointment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.medtech.medmeet.schedule.domain.model.entity.Doctor;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResource {
    private Integer id;
    private Date appointmentDate;
    private Integer minutesDuration;
    private String appointmentSessionUrl;
    private String appointmentPrescriptionUrl;
    private Integer userId;
    private Boolean status;
    private Doctor doctor;
}
