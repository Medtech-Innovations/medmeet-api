package org.medtech.medmeet.schedule.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "appointment_date")
    @Temporal(TemporalType.DATE)
    private Date appointmentDate;

    @NotNull
    @Column(name = "minutes_duration")
    @PositiveOrZero(message = "Minutes duration must be positive or zero")
    private Integer minutesDuration;

    @NotNull
    @Column(name = "appointment_session-url")
    @Size(max = 256, message = "Prescription URL should not exceed 256 characters")
    private String appointmentSessionUrl;

    @Column(name = "appointment_prescription-url")
    @Size(max = 256, message = "Prescription URL should not exceed 256 characters")
    private String appointmentPrescriptionUrl;

    @NotNull
    @Column(name = "status")
    private Boolean status;

    // Relationships

    // From User Context
    @NotNull
    private Integer userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
    }
}
