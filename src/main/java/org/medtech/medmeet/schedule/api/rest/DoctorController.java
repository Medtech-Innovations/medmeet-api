package org.medtech.medmeet.schedule.api.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.medtech.medmeet.schedule.domain.model.entity.Doctor;
import org.medtech.medmeet.schedule.domain.persistence.SpecialtyRepository;
import org.medtech.medmeet.schedule.domain.service.DoctorService;
import org.medtech.medmeet.schedule.mapping.DoctorMapper;
import org.medtech.medmeet.schedule.resource.appointment.AppointmentResource;
import org.medtech.medmeet.schedule.resource.doctor.CreateDoctorResource;
import org.medtech.medmeet.schedule.resource.doctor.DoctorResource;
import org.medtech.medmeet.schedule.resource.doctor.UpdateDoctorResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Doctors", description = "Create, Read, Update ande delete doctors entities")
@RestController
@RequestMapping("doctors")
@AllArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    private final SpecialtyRepository specialtyRepository;
    private Validator validator;
    private final DoctorMapper mapper;

    @Operation(summary = "Get all registered doctors", responses = {
            @ApiResponse(description = "Successfully fetched all doctors",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @GetMapping
    public List<Doctor> fetchAll() {
        return doctorService.fetchAll();
    }

    @Operation(summary = "Get an doctor by id", responses = {
            @ApiResponse(description = "Successfully fetched doctor by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @GetMapping("{id}")
    public DoctorResource fetchById(@PathVariable Integer id) {
        return this.mapper.toResource(doctorService.fetchById(id).get());
    }

    @Operation(summary = "Save a doctor", responses = {
            @ApiResponse(description = "Doctor successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @PostMapping
    public DoctorResource save(@RequestBody CreateDoctorResource resource) {
        return mapper.toResource(doctorService.save(mapper.toModel(resource), resource.getGivenSpecialtyId()));
    }

    @Operation(summary = "Update a doctor by id", responses = {
            @ApiResponse(description = "Successfully updated doctor by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @PutMapping("{id}")
    public ResponseEntity<DoctorResource> update(@PathVariable Integer id,
                                                    @RequestBody UpdateDoctorResource resource) {
        if (id.equals(resource.getId())) {
            DoctorResource doctorResource = mapper.toResource(
                    doctorService.updateSpecialty(mapper.toModel(resource), resource.getGivenSpecialtyId()));
            return new ResponseEntity<>(doctorResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Delete a doctor by id", responses = {
            @ApiResponse(description = "Successfully deleted doctor by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (doctorService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
