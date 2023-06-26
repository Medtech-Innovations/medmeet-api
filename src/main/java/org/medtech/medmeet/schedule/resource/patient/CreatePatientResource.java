package org.medtech.medmeet.schedule.resource.patient;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreatePatientResource {
    @NotNull
    private Integer userId;
}
