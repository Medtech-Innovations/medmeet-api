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

    @NotNull

    private Integer stars;

    @NotNull
    private Integer price;

    @NotNull
    private Integer givenSpecialtyId;
}
