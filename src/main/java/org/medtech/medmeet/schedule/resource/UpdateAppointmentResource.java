package org.medtech.medmeet.schedule.resource;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAppointmentResource {
    @NotNull
    @NotBlank
    @Min(1)
    private Integer id;

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
}
