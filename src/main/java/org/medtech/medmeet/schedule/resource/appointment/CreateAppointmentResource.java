package org.medtech.medmeet.schedule.resource.appointment;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateAppointmentResource {
    @NotNull
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;

    @NotNull
    @Size(min=0, max=120)
    private Integer minutesDuration;

    @NotNull
    @Size(max = 256)
    private String appointmentSessionUrl;

    @NotNull
    @Size(max = 256)
    private String appointmentPrescriptionUrl;

    @NotNull
    @Size(min=0)
    private Integer userId;

    @NotNull
    private Boolean status;
}
