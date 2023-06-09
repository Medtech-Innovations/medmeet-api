package org.medtech.medmeet.authentication.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private Integer id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;
}
