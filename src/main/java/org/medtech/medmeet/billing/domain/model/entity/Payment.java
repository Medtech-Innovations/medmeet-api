package org.medtech.medmeet.billing.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.medtech.medmeet.schedule.domain.model.entity.Appointment;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Setter
@Getter
@Entity
@Table(name = "payments")
public class Payment  {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @NotNull
        @Min(value = 1, message = "El monto mínimo debe ser mayor o igual a 1")
        @Max(value = 1000, message = "El monto máximo permitido es 1000")
        @Column(name = "amount", nullable = false)
        private BigDecimal amount;
        @Temporal(TemporalType.TIMESTAMP)
        @NotNull
        @Column(name = "created_date", nullable = false)
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdDate;

        @Size(max = 300, min = 0)
        public String description;

        //Relationships
        //Schedule Context
        @JsonIgnore
        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "appointment_id")
        private Appointment appointment;

        @PrePersist
        public void prePersist() {
                this.createdDate = LocalDateTime.now();
        }
}