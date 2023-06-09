package org.medtech.medmeet.authentication.resource;

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
public class UpdateUserResource {
    @NotNull
    @NotBlank
    @Min(1)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    private String password;
}
