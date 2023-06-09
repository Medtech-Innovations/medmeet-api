package org.medtech.medmeet.billing.resource;

import lombok.*;
import org.medtech.medmeet.schedule.domain.model.entity.Appointment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResource {
    private Integer id;
    private BigDecimal amount;
    private LocalDateTime createdDate;
    public String description;
    private Appointment appointment;
}
