package org.medtech.medmeet.schedule.resource.doctor;

import jakarta.validation.constraints.*;
import lombok.*;

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
    @Min(1)
    @Max(5)
    private Integer stars;

    @NotNull
    @NotBlank
    @Min(1)
    private Integer price;

    @NotNull
    @NotBlank
    private Integer userId;

    @NotNull
    @NotBlank
    private Integer givenSpecialtyId;
}
