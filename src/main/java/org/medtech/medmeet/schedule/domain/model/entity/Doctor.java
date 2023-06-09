package org.medtech.medmeet.schedule.domain.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relationships
    @NotNull
    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;
}
