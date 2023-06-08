package org.medtech.medmeet.schedule.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "appointment-status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 3, max = 50, message = "Appointment status name should be between 3 and 50 characters")
    @Column(name = "name", unique = true)
    private String name;

    // Relationships
    @JsonIgnore
    @OneToMany(mappedBy = "status")
    private Collection<Appointment> appointments;
}
