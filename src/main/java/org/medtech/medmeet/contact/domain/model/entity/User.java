package org.medtech.medmeet.contact.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 50, message = "User mail should be between 5 and 50 characters")
    @Column(name = "emails", unique = true)
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 9, message = "User phone number should have only 9 characters")
    @Column(name = "phones", unique = true)
    private String phone;

    @NotNull
    @NotBlank
    @Size(max = 15, message = "User configuration should be between 1 and 15 characters")   //advise user 1, 2, 3 days before appointment
                                                                                            //and also the minutes before a taking a medicine
    @Column(name = "configurations")
    private String configuration;

    @NotNull
    @NotBlank
    @Size(max = 10, message = "User mode should not exceed 10 characters") //mail or sms or web notification
    @Column(name = "modes")
    private String mode;

    //Relationships
    @JsonIgnore
    @OneToOne
    private Detail detail;
}
