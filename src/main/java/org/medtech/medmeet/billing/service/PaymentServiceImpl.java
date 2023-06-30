package org.medtech.medmeet.billing.service;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.medtech.medmeet.billing.domain.model.entity.Payment;
import org.medtech.medmeet.billing.domain.persistence.PaymentRepository;
import org.medtech.medmeet.billing.domain.service.PaymentService;
import org.medtech.medmeet.shared.exception.ResourceNotFoundException;
import org.medtech.medmeet.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PaymentServiceImpl implements PaymentService {
    private static final String ENTITY = "Payment";

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private Validator validator;

    public PaymentServiceImpl(PaymentRepository _paymentRepository, Validator _validator) {
        this.paymentRepository = _paymentRepository;
        this.validator = _validator;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Payment> fetchAll() {
        return paymentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Payment> fetchById(Integer id) {
        if (paymentRepository.existsById(id)) {
            return paymentRepository.findById(id);
        } else {
            throw new ResourceNotFoundException(ENTITY, id);
        }
    }

    @Override
    public Payment update(Payment payment) {
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return paymentRepository
                .findById(payment.getId())
                .map(paymentToUpdate -> {
                    paymentToUpdate.setAmount(payment.getAmount());
                    paymentToUpdate.setDescription(payment.getDescription());
                    paymentToUpdate.setAppointment(payment.getAppointment());
                    return paymentRepository.save(paymentToUpdate);
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, payment.getId()));
    }

    @Override
    public Payment save(Payment payment) {
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }
        return paymentRepository.save(payment);
    }

    @Override
    public boolean deleteById(Integer id) {
        var paymentToDelete = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));

        paymentRepository.delete(paymentToDelete);
        return true;
    }
}
