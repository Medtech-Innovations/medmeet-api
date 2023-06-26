package org.medtech.medmeet.schedule.api.rest;

import lombok.AllArgsConstructor;
import org.medtech.medmeet.schedule.domain.model.entity.Appointment;
import org.medtech.medmeet.schedule.domain.model.entity.Specialty;
import org.medtech.medmeet.schedule.domain.service.AppointmentService;
import org.medtech.medmeet.schedule.domain.service.SpecialtyService;
import org.medtech.medmeet.schedule.mapping.AppointmentMapper;
import org.medtech.medmeet.schedule.mapping.SpecialtyMapper;
import org.medtech.medmeet.schedule.resource.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("specialties")
@AllArgsConstructor
public class SpecialtyController {
    private final SpecialtyService specialtyService;
    private final SpecialtyMapper mapper;

    @GetMapping
    public List<Specialty> fetchAll() {
        return specialtyService.fetchAll();
    }

    @GetMapping("{id}")
    public SpecialtyResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(specialtyService.fetchById(id).get());
    }

    @PostMapping
    public SpecialtyResource save(@RequestBody CreateSpecialtyResource resource) {
        return mapper.toResource(specialtyService.save(mapper.toModel(resource)));
    }

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

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (specialtyService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
