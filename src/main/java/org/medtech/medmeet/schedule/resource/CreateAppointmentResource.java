package org.medtech.medmeet.schedule.resource;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    private Integer paymentId;
}
