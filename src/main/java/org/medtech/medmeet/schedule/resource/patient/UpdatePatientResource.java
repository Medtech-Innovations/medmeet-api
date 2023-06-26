package org.medtech.medmeet.schedule.resource.patient;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePatientResource {
    @NotNull
    @NotBlank
    @Min(1)
    private Integer id;

    @NotNull
    private Integer userId;
}
