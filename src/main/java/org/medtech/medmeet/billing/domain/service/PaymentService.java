package org.medtech.medmeet.billing.domain.service;

import org.medtech.medmeet.billing.domain.model.entity.Payment;
import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> fetchAll();
    Payment fetchById(Integer id);
    Payment update(Payment payment);
    Payment save(Payment payment);
    boolean deleteById(Integer id);
}
