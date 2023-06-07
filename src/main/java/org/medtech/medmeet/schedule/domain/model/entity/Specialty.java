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
@Table(name = "specialties")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name")
    @Size(min = 3, max = 50)
    private String name;

    // Relationships
    @JsonIgnore
    @OneToMany(mappedBy = "specialties", fetch = FetchType.LAZY)
    private Collection<Doctor> doctors;
}
