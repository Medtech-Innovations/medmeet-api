package org.medtech.medmeet.schedule.resource.doctor;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.medtech.medmeet.schedule.domain.model.entity.Specialty;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateDoctorResource {
    @NotNull
    private Integer userId;
}
