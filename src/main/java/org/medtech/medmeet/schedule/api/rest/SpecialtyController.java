package org.medtech.medmeet.schedule.api.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.medtech.medmeet.schedule.domain.model.entity.Specialty;
import org.medtech.medmeet.schedule.domain.service.SpecialtyService;
import org.medtech.medmeet.schedule.mapping.SpecialtyMapper;
import org.medtech.medmeet.schedule.resource.appointment.AppointmentResource;
import org.medtech.medmeet.schedule.resource.specialty.CreateSpecialtyResource;
import org.medtech.medmeet.schedule.resource.specialty.SpecialtyResource;
import org.medtech.medmeet.schedule.resource.specialty.UpdateSpecialtyResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Specialties", description = "Create, Read, Update ande delete specialties entities")
@RestController
@RequestMapping("api/v1/specialties")
@AllArgsConstructor
public class SpecialtyController {
    private final SpecialtyService specialtyService;
    private final SpecialtyMapper mapper;

    @Operation(summary = "Get all registered specialties", responses = {
            @ApiResponse(description = "Successfully fetched all specialties",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SpecialtyResource.class)))
    })
    @GetMapping
    public List<Specialty> fetchAll() {
        return specialtyService.fetchAll();
    }

    @Operation(summary = "Get a specialty by id", responses = {
            @ApiResponse(description = "Successfully fetched specialty by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SpecialtyResource.class)))
    })
    @GetMapping("{id}")
    public SpecialtyResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(specialtyService.fetchById(id).get());
    }

    @Operation(summary = "Save a specialty", responses = {
            @ApiResponse(description = "Specialty successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SpecialtyResource.class)))
    })
    @PostMapping
    public SpecialtyResource save(@RequestBody CreateSpecialtyResource resource) {
        return mapper.toResource(specialtyService.save(mapper.toModel(resource)));
    }

    @Operation(summary = "Update a specialty by id", responses = {
            @ApiResponse(description = "Successfully updated specialty by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SpecialtyResource.class)))
    })
    @PutMapping("{id}")
    public ResponseEntity<SpecialtyResource> update(@PathVariable Integer id,
                                                    @RequestBody UpdateSpecialtyResource resource) {
        if (id.equals(resource.getId())) {
            SpecialtyResource specialtyResource = mapper.toResource(
                    specialtyService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(specialtyResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Delete a specialty by id", responses = {
            @ApiResponse(description = "Successfully deleted specialty by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SpecialtyResource.class)))
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (specialtyService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}