package org.medtech.medmeet.schedule.domain.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @Min(1)
    @Max(5)
    private Integer stars;

    @NotNull
    @Min(1)
    private Integer price;

    // Relationships
    @NotNull
    private Integer userId;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;
}
