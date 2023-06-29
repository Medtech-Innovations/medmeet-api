package org.medtech.medmeet.contact.api.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.medtech.medmeet.contact.domain.model.entity.Detail;
import org.medtech.medmeet.contact.domain.service.DetailService;
import org.medtech.medmeet.contact.mapping.DetailMapper;
import org.medtech.medmeet.contact.resource.CreateDetailResource;
import org.medtech.medmeet.contact.resource.DetailResource;
import org.medtech.medmeet.contact.resource.UpdateDetailResource;
import org.medtech.medmeet.schedule.resource.appointment.AppointmentResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Details", description = "Create, Read, Update ande delete details entities")
@RestController
@RequestMapping("api/v1/details")
@AllArgsConstructor
public class DetailController {
    private final DetailService detailService;
    private final DetailMapper mapper;

    @Operation(summary = "Get all registered details", responses = {
            @ApiResponse(description = "Successfully fetched all details",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @GetMapping
    public List<Detail> fetchAll(){
        return detailService.fetchAll();
    }

    @Operation(summary = "Get a detail by id", responses = {
            @ApiResponse(description = "Successfully fetched detail by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @GetMapping({"{id}"})
    public  DetailResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(detailService.fetchByID(id));
    }

    @Operation(summary = "Save a detail", responses = {
            @ApiResponse(description = "Detail successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @PostMapping
    public DetailResource save(@RequestBody CreateDetailResource resource){
        return mapper.toResource( detailService.save(mapper.toModel(resource)));
    }

    @Operation(summary = "Update a detail by id", responses = {
            @ApiResponse(description = "Successfully updated detail by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @PutMapping("{id}")
    public ResponseEntity<DetailResource>update(@PathVariable Integer id,
                                                @RequestBody UpdateDetailResource resource){
        if(id.equals(resource.getId())){
            DetailResource detailResource = mapper.toResource(
                    detailService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(detailResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Delete a detail by id", responses = {
            @ApiResponse(description = "Successfully deleted detail by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (detailService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
