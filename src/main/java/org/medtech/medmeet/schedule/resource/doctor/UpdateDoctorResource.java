package org.medtech.medmeet.schedule.resource.doctor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.medtech.medmeet.schedule.domain.model.entity.Specialty;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDoctorResource {
    @NotNull
    @NotBlank
    @Min(1)
    private Integer id;

    @NotNull
    @NotBlank
    private Integer userId;
}
