package org.medtech.medmeet.billing.resource;


import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentResource {

    @NotNull
    @Min(value = 1, message = "El monto mínimo debe ser mayor o igual a 1")
    @Max(value = 1000, message = "El monto máximo permitido es 1000")
    private BigDecimal amount;

    @NotNull
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    @Size(max = 300)
    public String description;
}
