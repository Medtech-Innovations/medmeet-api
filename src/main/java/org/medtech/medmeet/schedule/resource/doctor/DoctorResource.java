package org.medtech.medmeet.schedule.resource.doctor;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResource {
    private Integer id;
    private Integer userId;
}
