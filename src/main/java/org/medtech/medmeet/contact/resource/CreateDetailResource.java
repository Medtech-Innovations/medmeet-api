package org.medtech.medmeet.contact.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateDetailResource {
    @NotNull
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date detailDate;
}
