package org.medtech.medmeet.schedule.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "reservation_date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reservationDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "appointment-date")
    @Temporal(TemporalType.DATE)
    private Date scheduledDate;

    @NotNull
    @DateTimeFormat(pattern = "hh:mm")
    @Column(name = "appointment-time")
    @Temporal(TemporalType.TIME)
    private Date scheduledTime;

    @NotNull
    @Column(name = "minutes-duration")
    @PositiveOrZero(message = "Minutes duration must be positive or zero")
    private Integer minutesDuration;

    @NotNull
    @Column(name = "appointment-session-url")
    @Size(max = 256, message = "Prescription URL should not exceed 256 characters")
    private String appointmentSessionUrl;

    @Column(name = "appointment-prescription-url")
    @Size(max = 256, message = "Prescription URL should not exceed 256 characters")
    private String appointmentPrescriptionUrl;

    // Relationships

    // From Payment Context
    @NotNull
    @Column(name = "payment-id")
    private Integer paymentId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor-id")
    private Doctor doctor;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient-id")
    private Patient patient;

    @NotNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status-id")
    private Status status;
}
