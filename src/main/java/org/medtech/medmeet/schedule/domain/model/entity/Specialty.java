package org.medtech.medmeet.schedule.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "specialties")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name")
    @Size(min = 3, max = 50)
    private String name;

    @Column(name = "description")
    @Size(max = 512)
    private String description;

    // Relationships
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Doctor> doctors;
}
