package org.medtech.medmeet.schedule.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UpdateAppointmentResource {
    @NotNull
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;

    @NotNull
    @NotBlank
    @DateTimeFormat(pattern = "hh:mm")
    private Date appointmentTime;

    @NotNull
    @Size(min=0, max=120)
    private Integer minutesDuration;

    @NotNull
    @Size(max = 256)
    private String appointmentSessionUrl;

    @NotNull
    @Size(max = 256)
    private String appointmentPrescriptionUrl;
}
