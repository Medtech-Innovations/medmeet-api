package org.medtech.medmeet.schedule.resource.doctor;

import lombok.*;
import org.medtech.medmeet.schedule.domain.model.entity.Specialty;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResource {
    private Integer id;
    private Integer userId;
        private Specialty specialty;
}
