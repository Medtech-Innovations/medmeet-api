package org.medtech.medmeet.schedule.resource.doctor;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateDoctorResource {
    @NotNull
    private Integer userId;
}