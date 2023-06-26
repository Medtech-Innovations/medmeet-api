package org.medtech.medmeet.schedule.resource;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSpecialtyResource {
    @NotNull
    @NotBlank
    @Min(1)
    private Integer id;

    @Size(max = 128)
    private String name;
}
