package org.medtech.medmeet.billing.api.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.medtech.medmeet.billing.domain.model.entity.Payment;
import org.medtech.medmeet.billing.domain.service.PaymentService;
import org.medtech.medmeet.billing.mapping.PaymentMapper;
import org.medtech.medmeet.billing.resource.CreatePaymentResource;
import org.medtech.medmeet.billing.resource.PaymentResource;
import org.medtech.medmeet.billing.resource.UpdatePaymentResource;
import org.medtech.medmeet.schedule.resource.appointment.AppointmentResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Payments", description = "Create, Read, Update ande delete payments entities")
@RestController
@RequestMapping("api/v1/payments")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentMapper mapper;

    @Operation(summary = "Get all registered payments", responses = {
            @ApiResponse(description = "Successfully fetched all payments",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @GetMapping
    public List<Payment> fetchAll() {
        return paymentService.fetchAll();
    }

    @Operation(summary = "Get a payment by id", responses = {
            @ApiResponse(description = "Successfully fetched payment by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @GetMapping("{id}")
    public PaymentResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(paymentService.fetchById(id));
    }

    @Operation(summary = "Save a payment", responses = {
            @ApiResponse(description = "Payment successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @PostMapping
    public PaymentResource save(@RequestBody CreatePaymentResource resource) {
        return mapper.toResource( paymentService.save(mapper.toModel(resource)));
    }

    @Operation(summary = "Update a payment by id", responses = {
            @ApiResponse(description = "Successfully updated payment by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
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

    @Operation(summary = "Delete a payment by id", responses = {
            @ApiResponse(description = "Successfully deleted payment by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (paymentService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
