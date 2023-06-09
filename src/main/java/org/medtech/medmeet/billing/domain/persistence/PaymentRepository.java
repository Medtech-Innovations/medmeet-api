package org.medtech.medmeet.billing.domain.persistence;

import org.medtech.medmeet.billing.domain.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
