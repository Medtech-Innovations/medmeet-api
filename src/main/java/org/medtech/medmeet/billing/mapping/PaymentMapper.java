package org.medtech.medmeet.billing.mapping;

import org.medtech.medmeet.billing.domain.model.entity.Payment;
import org.medtech.medmeet.billing.resource.CreatePaymentResource;
import org.medtech.medmeet.billing.resource.PaymentResource;
import org.medtech.medmeet.billing.resource.UpdatePaymentResource;
import org.medtech.medmeet.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class PaymentMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Payment toModel(UpdatePaymentResource resource) {
        return this.mapper.map(resource, Payment.class);
    }
    public Payment toModel(CreatePaymentResource resource) {
        return this.mapper.map(resource, Payment.class);
    }
    public PaymentResource toResource(Payment payment) {
        return this.mapper.map(payment, PaymentResource.class);
    }
}
