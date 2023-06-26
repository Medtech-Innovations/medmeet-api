package org.medtech.medmeet.billing.api.rest;

import lombok.AllArgsConstructor;
import org.medtech.medmeet.billing.domain.model.entity.Payment;
import org.medtech.medmeet.billing.domain.service.PaymentService;
import org.medtech.medmeet.billing.mapping.PaymentMapper;
import org.medtech.medmeet.billing.resource.CreatePaymentResource;
import org.medtech.medmeet.billing.resource.PaymentResource;
import org.medtech.medmeet.billing.resource.UpdatePaymentResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payments")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentMapper mapper;

    @GetMapping
    public List<Payment> fetchAll() {
        return paymentService.fetchAll();
    }

    @GetMapping("{id}")
    public PaymentResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(paymentService.fetchById(id));
    }

    @PostMapping
    public PaymentResource save(@RequestBody CreatePaymentResource resource) {
        return mapper.toResource( paymentService.save(mapper.toModel(resource)));
    }

    @PutMapping("{id}")
    public ResponseEntity<PaymentResource> update(@PathVariable Integer id,
                                                      @RequestBody UpdatePaymentResource resource) {
        if (id.equals(resource.getId())) {
            PaymentResource paymentResource = mapper.toResource(
                    paymentService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(paymentResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (paymentService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
