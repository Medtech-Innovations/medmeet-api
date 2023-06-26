package org.medtech.medmeet.schedule.resource.specialty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateSpecialtyResource {
    @NotNull
    @Size(max = 128)
    private String name;
}
