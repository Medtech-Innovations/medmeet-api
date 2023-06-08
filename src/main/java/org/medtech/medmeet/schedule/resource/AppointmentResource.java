package org.medtech.medmeet.schedule.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResource {
    private Integer id;
    private Date scheduledDate;
    private Integer minutesDuration;
    private String appointmentSessionUrl;
    private String appointmentPrescriptionUrl;
}
