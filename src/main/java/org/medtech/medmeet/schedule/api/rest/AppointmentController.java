package org.medtech.medmeet.schedule.api.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.medtech.medmeet.schedule.domain.model.entity.Appointment;
import org.medtech.medmeet.schedule.domain.service.AppointmentService;
import org.medtech.medmeet.schedule.mapping.AppointmentMapper;
import org.medtech.medmeet.schedule.resource.appointment.AppointmentResource;
import org.medtech.medmeet.schedule.resource.appointment.CreateAppointmentResource;
import org.medtech.medmeet.schedule.resource.appointment.UpdateAppointmentResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Appointments", description = "Create, Read, Update ande delete appointments entities")
@RestController
@RequestMapping("api/v1/appointments")
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final AppointmentMapper mapper;

    @Operation(summary = "Get all registered appointments", responses = {
            @ApiResponse(description = "Successfully fetched all appointments",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @GetMapping
    public List<Appointment> fetchAll() {
        return appointmentService.fetchAll();
    }

    @Operation(summary = "Get an appointment by id", responses = {
            @ApiResponse(description = "Successfully fetched appointment by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @GetMapping("{id}")
    public AppointmentResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(appointmentService.fetchById(id).get());
    }

    @Operation(summary = "Save an appointment", responses = {
            @ApiResponse(description = "Appointment successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @PostMapping
    public AppointmentResource save(@RequestBody CreateAppointmentResource resource) {
        return mapper.toResource( appointmentService.save(mapper.toModel(resource), resource.getGivenDoctorId()));
    }

    @Operation(summary = "Update an appointment by id", responses = {
            @ApiResponse(description = "Successfully updated appointment by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @PutMapping("{id}")
    public ResponseEntity<AppointmentResource>update(@PathVariable Integer id,
                                                     @RequestBody UpdateAppointmentResource resource) {
        if (id.equals(resource.getId())) {
            AppointmentResource appointmentResource = mapper.toResource(
                    appointmentService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(appointmentResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Delete an appointment by id", responses = {
            @ApiResponse(description = "Successfully deleted appointment by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (appointmentService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}