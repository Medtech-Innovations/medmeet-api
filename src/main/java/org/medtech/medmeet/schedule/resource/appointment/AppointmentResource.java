package org.medtech.medmeet.schedule.resource.appointment;

import lombok.*;

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
}
